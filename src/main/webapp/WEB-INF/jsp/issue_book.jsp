<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form action="issue_book" method="post" commandName="journal">
		<table border="0">
			<tr>
				<th align="right">
					<form:label path="book" >
						Book:
					</form:label>
				</th>
				<th align="right">
					<form:select size="15" path="book">
						<form:options items="${listBook}" itemValue="bookID"/>			
					</form:select>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="client" >
						Client:
					</form:label>
				</th>
				<th align="right">
					<form:select size="15" path="client">
						<form:options items="${listClient}" itemValue="clientID"/>	
					</form:select>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="dateIssue" >
						Date issue:
					</form:label>
				</th>
				<th align="right">
					<input type="text" path="dateIssue" class= "date" name = "dateIssue" 
						value = "<fmt:formatDate value="${journal.dateIssue}" pattern="yyyy-MM-dd hh:mm" />"/>
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="dateReturn" >
						Date return:
					</form:label>
				</th>
				<th align="right">
					<input type="text" path="dateReturn" class= "date" name = "dateReturn" 
						value = "<fmt:formatDate value="${journal.dateReturn}" pattern="yyyy-MM-dd hh:mm" />"/>
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th colspan="2" align="right">
		    		<button class="cellbut" type="submit" formmethod="post" formaction="issue_book" name ="action" value="new_record">Submit</button>
				</th>
			</tr>
		</table>
	</form:form>
</t:template>