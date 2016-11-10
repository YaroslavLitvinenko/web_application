<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<t:template>
	<c:if test="${userChanges != null}">
		<tr>
			<th align="right">ID:</th>
			<th><input readonly type="text" name="userID" value="${userChanges.userID}"><br></th>
			<th><div class="error"><i>${answer}</i></div></th>
		</tr>
	</c:if>
	<tr>
		<th align="right">Nickname:</th>
		<th><input type="text" name="nickname" <c:if test="${userChanges != null}">value="${userChanges.nickname}"</c:if>><br></th>
		<th><div class="error"><i>${answer}</i></div></th>
	</tr>
	<tr>
		<th align="right">Password:</th>
		<th><input type="text" name="password" <c:if test="${userChanges != null}">value="${userChanges.password}"</c:if>><br></th>
		<th><div class="error"><i>${answer}</i></div></th>
	</tr>
	<tr>
		<th align="right">Roles:</th>
		<th>
			<select multiple size="${sizeListRole}" name="roles[]">
				<c:if test="${userChanges != null}">
					<c:forEach items="${userChanges.roles}" var="role">
						<option selected value="${role.roleID}">${role.name}</option>
					</c:forEach>
				</c:if>
				<c:forEach items="${allRoles}" var="role">
					<option value="${role.roleID}">${role.name}</option>
				</c:forEach>
			</select>
		</th>
		<th><div class="error"><i>${answer}</i></div></th>
	</tr>
	<tr>
		<th>
		<c:choose>
    		<c:when test="${userChanges != null}">
    			<button class="cellbut" type="submit" formmethod="post" formaction="data_changes" name ="action" value="upd_user_${user.userID}">Submit</button>
    		</c:when>
    		<c:otherwise>
    			<button class="cellbut" type="submit" formmethod="post" formaction="data_changes" name ="action" value="new_user">Submit</button>
   			</c:otherwise>
    		</c:choose>
    	</th>
   </tr>
</t:template>