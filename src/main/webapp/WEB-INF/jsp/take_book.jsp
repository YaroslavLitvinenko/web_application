<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url value="/j_spring_security_logout" var="loginUrl"/>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Library</title>
		<link rel="stylesheet" type="text/css" href="public/style/style.css">
	</head>
	<body>
		<h1>Library</h1>
		<div class="header1">
			<form:form action="${loginUrl}" method="POST">
				<input type="submit" name="submit" value="Log Out">
			</form:form>
		</div>
		<form>
			<table>
				<tr>
					<td align="right">Cell:</td>
					<td align="left">
						<select size="1" name="cellID" >
							<c:forEach items="${listCell}" var="cell">
								<option value="${cell.cellID}">${cell.cellNumber}</option>
							</c:forEach>
						</select>
					</td>
					<td align="right">Date fact return:</td>
					<td colspan="2" align="left">
						<input type="text" name="dateFactReturn" value="${dateFactReturn}">
						<div class="error"><i>${answer}</i></div>
					</td>
				</tr>
				<c:forEach items="${listJournal}" var="journal">
					<tr>
						<th>[${journal.book.bookID}] ${journal.book.name}</th>
						<th>${journal.client.firstName} ${journal.client.lastName}</th>
						<th>${journal.dateIssue}</th>
						<th>${journal.dateReturn}</th>
						<th>
							<button class="cellbut" type="submit" formmethod="post" formaction="take_book" name ="action" value="takeBook_${journal.recordID}">Take</button>
						</th>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>