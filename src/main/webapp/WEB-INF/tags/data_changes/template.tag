<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/j_spring_security_logout" var="loginUrl"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Library</title>
	<style type="text/css">
		table {border:0px;}
		.header1 { position: absolute; top: 2%; right: 2%; width:10%; text-align:center;}
	</style>
	<script type="text/javascript" src="public/js/validation.js"></script>
</head>
<body>
	<h1>Library</h1>
	<div class="header1">
		<form:form action="${loginUrl}" method="POST">
			<input type="submit" name="submit" value="Log Out">
		</form:form>
	</div>
	<jsp:doBody/>
</body>
</html>