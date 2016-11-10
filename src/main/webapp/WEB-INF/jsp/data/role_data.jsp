<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<t:template>
	<c:if test="${roleChanges != null}">
	<tr>
		<th align="right">ID:</th>
		<th><input readonly type="text" name="roleID" value="${roleChanges.roleID}"><br></th>
		<th><div class="error"><i>${answer}</i></div></th>
	</tr>
	</c:if>
	<tr>
		<th align="right">Name:</th>
		<th><input type="text" name="name" <c:if test="${roleChanges != null}">value="${roleChanges.name}"</c:if>><br></th>
		<th><div class="error"><i>${answer}</i></div></th>
	</tr>
	<tr>
		<th colspan="2" align="right">
		<c:choose>
    		<c:when test="${roleChanges != null}">
    			<button class="cellbut" type="submit" formmethod="post" formaction="data_changes" name ="action" value="upd_role_${role.roleID}">Submit</button>
    		</c:when>
    		<c:otherwise>
    			<button class="cellbut" type="submit" formmethod="post" formaction="data_changes" name ="action" value="new_role">Submit</button>
    			</c:otherwise>
    		</c:choose>
		</th>
	</tr>
</t:template>