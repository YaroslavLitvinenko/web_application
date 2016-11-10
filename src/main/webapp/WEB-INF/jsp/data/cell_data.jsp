<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form action="data_variation_cell" method="post" commandName="cell">
		<table border="0">
			<tr>
				<th align="right">
					<form:label path="cellID" >
						ID:
					</form:label>
				</th>
				<th align="right">
					<form:input path="cellID" readonly="true"/>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr> 
			<tr>
				<th align="right">
					<form:label path="cellNumber">
						Number:
					</form:label>
				</th>
				<th>
					<form:input path="cellNumber" />
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="book">
						Book:
					</form:label>
				</th>
				<th>
					<form:select path="book">
						<c:choose>
			    			<c:when test="${cell.book == null}">
			    				<option selected value="null">On hands</option>
				 	   		</c:when>
			    			<c:otherwise>
			    				<option value="null">On hands</option>
			    				<option selected value="${cell.book.bookID}">${cell.book}</option>
			   				</c:otherwise>
			    		</c:choose>
						<form:options items="${listBookForCell}" itemValue="bookID"/>						
					</form:select>
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th colspan="2" align="right">
					<input type="submit" value="submit"/>
				</th>
			</tr>
		</table>
	</form:form>
</t:template>