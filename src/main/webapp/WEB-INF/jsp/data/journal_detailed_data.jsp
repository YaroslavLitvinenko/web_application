<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<t:template>
	<table>
		<tr>
			<th align="right">ID:</th>
			<th><input readonly type="text" value="${journalChanges.recordID}"><br></th>
		</tr>
		<tr>
			<th align="right">Date issue:</th>
			<th><input readonly type="text" value="${journalChanges.dateIssue}"><br></th>
		</tr>
		<tr>
			<th align="right">Date return:</th>
			<th><input readonly type="text" value="${journalChanges.dateReturn}"><br></th>
		</tr>
		<tr>
			<th align="right">Date fact return:</th>
			<th><input readonly type="text" value="${journalChanges.dateFactReturn}"><br></th>
		</tr>
		<tr><th></th></tr>
		<tr><th colspan="2">Book</th></tr>
		<tr>
			<th align="right">Book ID:</th>
			<th><input readonly type="text" value="${journalChanges.book.bookID}"><br></th>
		</tr>
		<tr>
			<th align="right">Name:</th>
			<th><input readonly type="text" value="${journalChanges.book.name}"><br></th>
		</tr>
		<tr><th></th></tr>
		<tr><th colspan="2">Client</th></tr>
		<tr>
			<th align="right">Client ID:</th>
			<th><input readonly type="text" value="${journalChanges.client.clientID}"><br></th>
		</tr>
		<tr>
			<th align="right">First name:</th>
			<th><input readonly type="text" value="${journalChanges.client.firstName}"><br></th>
		</tr>
		<tr>
			<th align="right">Last name:</th>
			<th><input readonly type="text" value="${journalChanges.client.lastName}"><br></th>
		</tr>
		<tr>
			<th align="right">Phone number:</th>
			<th><input readonly type="text" value="${journalChanges.client.phoneNumber}"><br></th>
		</tr>
		<tr><th></th></tr>
		<tr><th colspan="2">Administrator</th></tr>
		<tr>
			<th align="right">First name:</th>
			<th><input readonly type="text" value="${journalChanges.admin.firstName}"><br></th>
		</tr>
		<tr>
			<th align="right">Last name:</th>
			<th><input readonly type="text" value="${journalChanges.admin.lastName}"><br></th>
		</tr>
		<tr>
			<th align="right">Phone number:</th>
			<th><input readonly type="text" value="${journalChanges.admin.middleName}"><br></th>
		</tr>
	</table>
</t:template>