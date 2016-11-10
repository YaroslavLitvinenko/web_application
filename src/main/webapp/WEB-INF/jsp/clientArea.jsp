<%@ taglib prefix="t" tagdir="/WEB-INF/tags/area" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %>


<t:template>
	<h1>Hello ${client.lastName} ${client.firstName}</h1>
</t:template>