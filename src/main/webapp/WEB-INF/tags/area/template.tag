<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/j_spring_security_logout" var="loginUrl"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Library</title>
	<link rel="stylesheet" type="text/css" href="public/style/style.css">
	<script type="text/javascript" src="public/js/jquery.js"></script>
	<script type="text/javascript" src="public/js/underscore.js"></script>
	<script type="text/javascript" src="public/js/backbone.js"></script>
	<script type="text/javascript" src="public/js/scriptForOnePage.js"></script>
	<script type="text/javascript" src="public/js/scriptForRest.js"></script>
	<script type="text/javascript" src="public/js/scriptForAllocation.js"></script>
	<style type="text/css">
		.allocation{
			background-color: blue;
		}
	</style>
</head>
<body>
	<h1>Library</h1>
	<div class="header1">
		<form:form action="${loginUrl}" method="POST">
			<input type="submit" name="submit" value="Log Out">
		</form:form>
	</div>
	<form>
		<jsp:doBody/>
	</form>	
</body>
</html>