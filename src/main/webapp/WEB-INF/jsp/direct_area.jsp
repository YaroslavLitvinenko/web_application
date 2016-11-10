<%@ taglib prefix="t" tagdir="/WEB-INF/tags/area" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<t:template>
	<table style="width:88%" id="adminTable">
		<tr>
	   		<th>ID</th>
	   		<th>First name</th>
	 		<th>Last name</th>
	   		<th>Middle name</th>
   			<th>User</th>
   			<th colspan="2"><button class="cellbut" type="submit" formmethod="get" formaction="data_variation_d" name ="action" value="new">Create</button></th>
	    </tr>
	    <c:forEach items="${listAdmin}" var="admin">
	    	<tr>
	  			<td>${admin.adminID}</td>
	   			<td>${admin.firstName}</td>
	   			<td>${admin.lastName}</td>
	 			<td>${admin.middleName}</td>
				<td>${admin.user.nickname} ${admin.user.password}</td>
				<td><button class="cellbut" type="submit" formmethod="post" formaction="director_area" name ="action" value="${admin.adminID}">Delete</button></td>
	   			<td><button class="cellbut" type="submit" formmethod="get" formaction="data_variation_d" name ="action" value="upd_${admin.adminID}">Update</button></td>
	   		</tr>
    	</c:forEach>
    </table>
    <script>
		alocation(document.getElementById('adminTable'));
	</script>
</t:template>