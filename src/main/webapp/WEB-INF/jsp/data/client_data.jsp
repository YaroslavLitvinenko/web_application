<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form onsubmit="return validate_client(this)" action="data_variation_client" method="post" commandName="client">
		<table border="0">
			<tr>
				<th align="right">
					<form:label path="clientID" >
						ID:
					</form:label>
				</th>
				<th align="right">
					<form:input path="clientID" readonly="true"/>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="firstName" >
						First Name:
					</form:label>
				</th>
				<th align="right">
					<form:input path="firstName" />
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="lastName" >
						Last Name:
					</form:label>
				</th>
				<th align="right">
					<form:input path="lastName" />
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="phoneNumber" >
						Phone:
					</form:label>
				</th>
				<th align="right">
					<form:input path="phoneNumber" />
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="user.nickname" >
						Nickname:
					</form:label>
				</th>
				<th align="right">
					<form:input path="user.nickname" name="nickname"/>
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
				</th>
			</tr>
			<tr>
				<th align="right">
					<form:label path="user.password" >
						Password:
					</form:label>
				</th>
				<th align="right">
					<form:input path="user.password" />
				</th>
				<th>
					<div class="error"><i>${answer}</i></div>
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