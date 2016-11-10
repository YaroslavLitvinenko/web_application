function deleteRec(number) {
	var xhr = new XMLHttpRequest();
			
	xhr.open('DELETE', ('rest/author?authorID=' + number), true);
	xhr.send();
			
	xhr.onreadystatechange = function() {
		if (xhr.readyState != 4) return;
			
		if (xhr.status != 200) { 
			alert(xhr.status + ': ' + xhr.statusText); 
		} else {
			var tableRef = document.getElementById('authorTable');
			var length = tableRef.rows.length;
			for (var i = 0; i < length; i++) {
				if(tableRef.rows[i].cells[0].innerHTML == number) {
					tableRef.deleteRow(i);
				}
			}
		}
	}
}

function getListAuthors() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'rest/author/find_all', true);
	xhr.send();
			
	xhr.onreadystatechange = function() {
		if (xhr.readyState != 4)
			return;
		
		if (xhr.status != 200) { 
			alert(xhr.status + ': ' + xhr.statusText); 
		} else {
			return JSON.parse(xhr.responseText);
		}
	}
}
		
function getTable(obj) {
	var tableRef = document.getElementById('authorTable');
	if(obj.checked == true) {
		var xhr = new XMLHttpRequest();
		xhr.open('GET', 'rest/author/find_all', true);
		xhr.send();
				
		xhr.onreadystatechange = function() {
		if (xhr.readyState != 4)
			return;
			
		if (xhr.status != 200) { 
			alert(xhr.status + ': ' + xhr.statusText); 
		} else {
			var doc = JSON.parse(xhr.responseText);
					
			for (var i = 0; i < doc.length; i++) {
				var newRow   = tableRef.insertRow(-1);
				var j = 0;
				for (key in doc[i]) {
					var newCell  = newRow.insertCell(j++);
					newCell.appendChild(document.createTextNode(doc[i][key]));
				}
						
				var btnDel = document.createElement('input');
				btnDel.type = 'button';
				btnDel.value = 'Delete';
				btnDel.setAttribute('class', 'cellbut');
				btnDel.setAttribute('onClick', 'deleteRec(' + doc[i].authorID + ')');
				
				var btnUpd = document.createElement("input");
				btnUpd.type = 'button';
				btnUpd.value = 'Update';
				btnUpd.setAttribute('class', 'cellbut');
				btnUpd.setAttribute('onClick', '');
							
				var newCellForDel  = newRow.insertCell(j++);
				newCellForDel.appendChild(btnDel);
				var newCellForUpd  = newRow.insertCell(j++);
				newCellForUpd.appendChild(btnUpd);
			}
						
			alocation(tableRef);			
		}
	}
} else {
		var length = tableRef.rows.length;
		for (var i = 0; i < length; i++) {
			tableRef.deleteRow(1);
		}		
	}
}