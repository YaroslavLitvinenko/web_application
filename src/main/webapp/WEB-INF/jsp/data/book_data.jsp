<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form action="data_variation_book" method="post" commandName="book">
		<table border="0">
			<tr>
				<th align="right">
					<form:label path="bookID" >
						ID:
					</form:label>
				</th>
				<th align="right">
					<form:input path="bookID" readonly="true"/>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="name" >
						Name:
					</form:label>
				</th>
				<th>
					<form:input path="name" />
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="category" >
						Genre:
					</form:label>
				</th>
				<th>
					<form:select path="category">
						<c:if test="${book.bookID != null}">
							<option selected value="${book.category.categoryID}">${book.category.name}</option>
						</c:if>
						<form:options items="${listCategory}" itemValue="categoryID" itemLabel="name"/>						
					</form:select>
				</th>
			</tr>
			<tr>
				<th align="right">Cell:</th>
				<th>
					<select size="1" name="cellID" >
						<c:if test="${book != null}">
							<c:if test="${bookCell != null}">
								<option value="">On hands</option>
								<option selected value="${bookCell.cellID}">${bookCell.cellNumber}</option>
							</c:if>
							<c:if test="${bookCell == null}">
								<option selected value="">On hands</option>
							</c:if>
						</c:if>
						<c:if test="${book == null}">
							<option value="">On hands</option>
						</c:if>
						<c:forEach items="${emptyCells}" var="cell">
							<option value="${cell.cellID}">${cell.cellNumber}</option>
						</c:forEach>
					</select>
				</th>
			</tr>
			<tr>
				<th align="center" colspan="2">
					<select size="${sizeSelect}" multiple name="authors1">
						<c:forEach items="${book.authors}" var="author">
							<option selected value="${author.authorID}">${author.lastName} ${author.firstName} <c:if test="${author.middleName != null}">${author.middleName}</c:if></option>
						</c:forEach>
						<c:forEach items="${allAuthors}" var="author">
							<option value="${author.authorID}">${author.lastName} ${author.firstName} <c:if test="${author.middleName != null}">${author.middleName}</c:if></option>
						</c:forEach>
					</select>
				</th>
		    </tr>
			<tr>
				<th colspan="2" align="right">
					<input type="submit" value="submit"/>
		    	</th>
		   	</tr>
   		</table>
   	</form:form>
</t:template>