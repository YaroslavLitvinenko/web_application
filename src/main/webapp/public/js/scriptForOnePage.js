$(function () {

    var AppState = Backbone.Model.extend({
        defaults: {
            state: "table"
        }
    });

    var appState = new AppState();

    var AuthorModel = Backbone.Model.extend({
    	defaults: {
    		authorID: null,
    		firstName: "",
    		lastName: "",
    		middleName: ""
    	},
    	idAttribute: "authorID",
    	urlRoot: 'http://localhost:8080/spring/rest/author'
    });

    var Authors = Backbone.Collection.extend({

        model: AuthorModel,
        url : "rest/author",
        
        getAuthor: function(id) {
        	var findResult = this.findWhere({authorID: id});
        	return findResult;
		}
    });
    
    var listOfAuthors = new Authors();
    
    listOfAuthors.fetch({
    	success: function() {
    		block.render();
    	}
    });

    var Controller = Backbone.Router.extend({
        routes: {
            "": "table", 
            "!/": "table", 
            "!/author": "author",
        },

        table: function () {
            appState.set({ state: "table" });
        },

        author: function () {
            appState.set({ state: "author" });
        },
    });

    var controller = new Controller(); 
    
    function backlight() {
    	var elem = this.parentNode;
    	if (elem.className == 'allocation') {
    		elem.className = '';
    	} else {
    		elem.className = 'allocation';
    	}
    }

    function alocation(table) {
    	table.children("tbody").children().children().click(function() {
    		var elem = this.parentNode;
        	if (elem.className == 'allocation') {
        		elem.className = '';
        	} else {
        		elem.className = 'allocation';
        	}
    	})
    	/*
    	var lines = table.getElementsByTagName('td');
    	for (var i = 0; i < lines.length; ++i) {
    		lines[i].onclick = backlight;
    	}*/
    }

    var Block = Backbone.View.extend({
        el: $("#block"), 

        templates: { 
            "table": _.template($('#table').html()),
            "author": _.template($('#author').html())
        },

        events: {
        	"click button#create":"createRec",
        	"click button#submit":"submit",
        	"click button#update":"updateRec",
        	"click button#delete":"deleteRec"
        },

        initialize: function () { 
            this.model.bind('change', this.render, this);
        },

        createRec: function() {
        	appState.set({"state": "author"});
        },
        
        updateRec: function() {
        	var elementForDel = $("#tableAuthor").children("tbody").children(".allocation").children("#authorID");
        	if (elementForDel.length == 1) {
        		var upd = listOfAuthors.get(elementForDel[0].innerHTML);
            	this.author = upd;
            	appState.set({"state": "author"});
        	}
        },
        
        deleteRec: function() {
        	var elementForDel = $("#tableAuthor").children("tbody").children(".allocation").children("#authorID");
        	if (elementForDel.length != 0) {
        		for (var i = 0; i < elementForDel.length; i++) {
            		var del = new AuthorModel({
                		authorID: elementForDel[i].innerHTML
                	});
                	del.destroy();
                	listOfAuthors.remove(del);
            	}
        		block.render();
        	}
        },
        
        submit: function() {
        	if ($("#authorID").val() == ""){
        		var newAuthor = new AuthorModel({
    	    		firstName: $("#firstName").val(),
    		    	lastName: $("#lastName").val(),
    		    	middleName: $("#middleName").val() == "" ? null : $("#middleName").val()
    	    	});
    	    	newAuthor.save({}, {success: function(model, response){
    	    		listOfAuthors.add(response);
    	    		block.render();
    	    	}});
        	} else {
        		var updAuthor = new AuthorModel({
        			authorID: $("#authorID").val(),
    	    		firstName: $("#firstName").val(),
    		    	lastName: $("#lastName").val(),
    		    	middleName: $("#middleName").val() == "" ? null : $("#middleName").val()
    	    	});
        		
        		updAuthor.save({}, {success: function(model, response){
        			listOfAuthors.fetch({
        		    	success: function() {
        		    		block.render();
        		    	}
        		    });
        		}});
        	}
	    	appState.set({"state": "table"});
        },

        render: function () {
            var state = this.model.get("state");
            $(this.el).html(this.templates[state](this.model.toJSON()));
            listOfAuthors.each(function(author) {
	    		$('#table-body').append(
	    		    '<tr>' +
	    		      '<td id="authorID">' + author.get('authorID') + '</td>' +
	    		      '<td>' + author.get('firstName') + '</td>' +
	    		      '<td>' + author.get('lastName') + '</td>' +
	    		      '<td>' + author.get('middleName') + '</td>' +
	    		    '</tr>'
	    		  );
	    		});
            
            //alert($("#tableAuthor").children("tbody").children().children().length);
            alocation($("#tableAuthor"));
            
            if (this.author != null) {
            	$("#authorID").val(this.author.get("authorID"));
            	$("#firstName").val(this.author.get("firstName"));
            	$("#lastName").val(this.author.get("lastName"));
            	$("#middleName").val(this.author.get("middleName"));
            	this.author = null;
            }
            
    
            return this;
        }
    });

    var block = new Block({ model: appState }); 

    appState.trigger("change");

    appState.bind("change:state", function () { 
        var state = this.get("state");
        if (state == "table")
            controller.navigate("!/", false);  
                                             
        else
            controller.navigate("!/author", false);
    });

    Backbone.history.start();     


});
    