<%@ taglib prefix="t" tagdir="/WEB-INF/tags/area" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %>


<t:template>
	<div class="header2">
		<button class="cellbut" type="submit" formmethod="get" formaction="issue_book" name ="action" value="issueBook">Issue book</button><br/><br/>
		<button class="cellbut" type="submit" formmethod="get" formaction="take_book" name ="action" value="takeBook">Take a book</button>
	</div>
	<div class="spoiler">
		<input id="categorySpoiler" type="checkbox">
	    <label for="categorySpoiler">Category</label>
	    <div class="spoiler_body">
	    	<table id="categoryTable" >
	    		<tr>
	    			<th>ID</th>
	    			<th>Name</th>
	    			<th colspan="2"><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="new_category">Create</button></th>
	    		</tr>
	   			<c:forEach items="${listCategory}" var="category">
	   				<tr>
	   					<td>${category.categoryID}</td>
	   					<td>${category.name}</td>
    					<td><button class="cellbut" type="submit" formmethod="post" formaction="admin_area" name ="action" value="del_category_${category.categoryID}">Delete</button></td>
	   					<td><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="upd_category_${category.categoryID}">Update</button></td>
	   				</tr>
	   			</c:forEach>
	   		</table>
	    </div>
	</div>
	<div class="spoiler">
		<input id="authorSpoiler" type="checkbox">
	    <label for="authorSpoiler">Author</label>
	    <div class="spoiler_body">
	    	<div id="block" class="block"></div>
    
    		<script type="text/template" id="table">
				<table class="table" id="tableAuthor" border="1">
					<thead>
						<tr>
        					<th>ID</th>
							<th>First name</th>
 		      				<th>Last name</th>
							<th>Middle name</th>
 		     			</tr>
 			   		</thead>
 			   		<tbody id="table-body"></tbody>
 				</table>
				<br/>
				<div>
					<button style="width:7%" id="create">Create</button>
					<button style="width:7%" id="delete">Delete</button>
					<button style="width:7%" id="update">Update</button>
				</div>
			</script>

			<script type="text/template" id="author">
				<div class="author">
					<label for="authorID" >ID:</label>
			    	<input name="authorID" id="authorID" readonly="true"/><br/><br/>
					<label for="firstName">First name:</label>
			    	<input path="firstName" id="firstName"/><br/><br/>
			   		<label for="lastName">Last name:</label>
			   		<input path="lastName" id="lastName"/><br/><br/>
			   		<label for="middleName">Middle name:</label>
					<input path="middleName" id="middleName"/><br/><br/>
		    		<button style="width: 7%" id="submit">Submit</button>
					<a href="#!/">Go back</a>
				</div>
			</script>
	    </div>
	</div>
	<div class="spoiler">
		<input id="bookSpoiler" type="checkbox">
	    <label for="bookSpoiler">Book</label>
	    <div class="spoiler_body">
	    		<table>
	    			<tr>
	    				<th>ID</th>
	    				<th>Name</th>
	    				<th>Category</th>
	    				<th>Author</th>
	    				<th colspan="2"><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="new_book">Create</button></th>
	    			</tr>
	    			<c:forEach items="${listBook}" var="book">
	    				<tr>
	    					<td>${book.bookID}</td>
	    					<td>${book.name}</td>
	    					<td>${book.category.name}</td>
	    					<td>
	    						<c:forEach items="${book.authors}" var="author" varStatus="loop">
	    							${author}<c:if test="${!loop.last}">,</c:if>
	    						</c:forEach>
	    					</td>
	    					<td><button class="cellbut" type="submit" formmethod="post" formaction="admin_area" name ="action" value="del_book_${book.bookID}">Delete</button></td>
	    					<td><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="upd_book_${book.bookID}">Update</button></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    </div>
	</div>
	<div class="spoiler">
		<input id="cellSpoiler" type="checkbox">
	    <label for="cellSpoiler">Cell</label>
	    <div class="spoiler_body">
	    		<table>
	    			<tr>
	    				<th>ID</th>
	    				<th>Number</th>
	    				<th>Book</th>
	    				<th colspan="2"><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="new_cell">Create</button></th>
	    			</tr>
	    			<c:forEach items="${listCell}" var="cell">
	    				<tr>
	    					<td>${cell.cellID}</td>
	    					<td>${cell.cellNumber}</td>
	    					<td>
	    						<c:if test="${cell.book != null}">
	    							[${cell.book.bookID}] ${cell.book.name}
	    						</c:if>
	    					</td>
	    					<td><button class="cellbut" type="submit" formmethod="post" formaction="admin_area" name ="action" value="del_cell_${cell.cellID}">Delete</button></td>
	    					<td><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="upd_cell_${cell.cellID}">Update</button></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    </div>
	</div>
	<div class="spoiler">
		<input id="clientSpoiler" type="checkbox">
	    <label for="clientSpoiler">Client</label>
	    <div class="spoiler_body">
	    		<table>
	    			<tr>
	    				<th>ID</th>
	    				<th>First name</th>
	    				<th>Last name</th>
	    				<th>Phone number</th>
	    				<th colspan="2"><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="new_client">Create</button></th>
	    			</tr>
	    			<c:forEach items="${listClient}" var="client">
	    				<tr>
	    					<td>${client.clientID}</td>
	    					<td>${client.firstName}</td>
	    					<td>${client.lastName}</td>
	    					<td>${client.phoneNumber}</td>
	    					<td><button class="cellbut" type="submit" formmethod="post" formaction="admin_area" name ="action" value="del_client_${client.clientID}">Delete</button></td>
	    					<td><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="upd_client_${client.clientID}">Update</button></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    </div>
	</div>
	<div class="spoiler">
		<input id="journalSpoiler" type="checkbox">
	    <label for="journalSpoiler">Journal</label>
	    <div class="spoiler_body">
	    		<table id="journalTable">
	    			<tr>
	    				<th>ID record</th>
	    				<th>Book</th>
	    				<th>Client</th>
	    				<th>Data issue</th>
	    				<th>Date return</th>
	    				<th>Date fact return</th>
	    				<th colspan="2"></th>
	    			</tr>
	    			<c:forEach items="${listJournal}" var="journal">
	    				<tr>
	    					<td>${journal.recordID}</td>
	    					<td>[${journal.book.bookID}] ${journal.book.name}</td>
	    					<td>${journal.client.firstName} ${journal.client.lastName}</td>
	    					<td>${journal.dateIssue}</td>
	    					<td>${journal.dateReturn}</td>
	    					<td>${journal.dateFactReturn}</td>
	    					<td>
	    					<c:if test="${journal.dateFactReturn == null}">
	    						<button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="upd_journal_${journal.recordID}">Update</button>
	    					</c:if>
	    					</td>
	    					<td><button class="cellbut" type="submit" formmethod="get" formaction="data_variation" name ="action" value="new_journal_${journal.recordID}">Detailed</button></td>
	    				</tr>
	    			</c:forEach>
	    		</table>
	    </div>
	</div>
	<br/>
	<script>
		alocation(document.getElementById('categoryTable'));
		alocation(document.getElementById('journalTable'));
	</script>
</t:template>