<%@ taglib prefix="t" tagdir="/WEB-INF/tags/area" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<t:template>
	<h2>Please enter the area</h2>
	<c:if test="${client != null}">
		<a href="client_area">Go to client area</a><br/><br/>
	</c:if>
	<c:if test="${admin != null}">
		<a href="admin_area">Go to administrator area</a><br/><br/>
	</c:if>
	<c:if test="${dir != null}">
		<a href="director_area">Go to director area</a>
	</c:if>
</t:template>
