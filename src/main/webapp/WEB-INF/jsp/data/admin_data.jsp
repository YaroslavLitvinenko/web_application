<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form onsubmit="return validate_admin(this)" action="data_variation_d" method="post" commandName="admin">
		<table border="0">
			<tr>
				<th align="right">
					<form:label path="adminID" >
						ID:
					</form:label>
				</th>
				<th align="right">
					<form:input path="adminID" readonly="true"/>
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
			</tr>
			<tr>
				<th align="right">
					<form:label path="user.nickname" >
						Nickname:
					</form:label>
				</th>
				<th align="right">
					<form:input path="user.nickname" />
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
			</tr>
			<tr>
				<th colspan="2" align="right">
					<c:if test="${admin.adminID == null}">
						<input type="checkbox" name="role" id="ch1" checked value="Administrator"><label for="ch1">Administrator</label>
						<input type="checkbox" name="role" id="ch2" value="Director"><label for="ch2">Director</label>
					</c:if>
					<c:if test="${admin.adminID != null}">
						<c:choose>
	    					<c:when test="${fn:length(admin.user.roles) == 1}">
		    					<c:choose>
			    					<c:when test="${admin.user.roles[0] == 'Administrator'}">
			    						<input type="checkbox" name="role" id="ch1" checked value="Administrator"><label for="ch1">Administrator</label>
										<input type="checkbox" name="role" id="ch2" value="Director"><label for="ch2">Director</label>
			    					</c:when>
			    					<c:otherwise>
			    						<input type="checkbox" name="role" id="ch1" value="Administrator"><label for="ch1">Administrator</label>
										<input type="checkbox" name="role" id="ch2" checked value="Director"><label for="ch2">Director</label>
			   						</c:otherwise>
    							</c:choose>
		 	   				</c:when>
	    					<c:otherwise>
	    						<input type="checkbox" name="role" id="ch1" checked value="Administrator"><label for="ch1">Administrator</label>
								<input type="checkbox" name="role" id="ch2" checked value="Director"><label for="ch2">Director</label>
	   						</c:otherwise>
    					</c:choose>
					</c:if>
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