<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form action="data_variation_author" method="post" commandName="author">
		<table border="0">
			<tr>
				<th align="right">
					<form:label path="authorID" >
						ID:
					</form:label>
				</th>
				<th align="right">
					<form:input path="authorID" readonly="true"/>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr> 
			<tr>
				<th align="right">
					<form:label path="firstName">
						First name:
					</form:label>
				</th>
				<th>
					<form:input path="firstName" />
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="lastName">
						Last name:
					</form:label>
				</th>
				<th>
					<form:input path="lastName" />
				</th>
				<th><div class="error"><i>${answer}</i></div></th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="middleName">
						Middle name:
					</form:label>
				</th>
				<th>
					<form:input path="middleName" />
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