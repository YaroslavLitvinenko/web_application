<%@ taglib prefix="t" tagdir="/WEB-INF/tags/data_changes" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<t:template>
	<form:form onsubmit="return validate_category(this)" action="data_variation_category" method="post" commandName="category">
		<table style="border:0px">
			<tr>
				<th align="right">
					<form:label path="categoryID" >
						ID:
					</form:label>
				</th>
				<th align="right">
					<form:input path="categoryID" readonly="true"/>
				</th>
			</tr> 
			<tr>
				<th align="right">
					<form:label path="name">
						Name:
					</form:label>
				</th>
				<th>
					<form:input path="name" id="name" name="name"/>
				</th>
				<th><div id="infname"></div></th>
			</tr>
			<tr>
				<th colspan="2" align="right">
					<input type="submit" value="submit" />
				</th>
			</tr>
		</table>
		<script type="text/javascript" src="public/js/scriptForPageCategoryData.js"></script>
	</form:form>
</t:template>