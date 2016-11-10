<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/j_spring_security_check" var="loginUrl"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
	<body>
		<h2>Hello</h2>
		<form:form action="${loginUrl}" method="POST">

        <p><input type="text" name="j_username" placeholder="Login" maxlength="50"></p>

        <p><input type="password" name="j_password" placeholder="Password" maxlength="20"></p>

        <input type="submit" name="submit" class="login login-submit" value="Login">

        <c:if test="${not empty param['error']}">
            <h5>Login or Password is not valid. Please try again.</h5>
        </c:if>

    </form:form>
	</body>
</html>