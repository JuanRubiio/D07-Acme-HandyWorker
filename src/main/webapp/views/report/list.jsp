<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<display:table name="report" requestURI="report/referee/list.do"
	class="displaytag">
	<display:column>
		<jstl:if test="${!report.draft }">
			<security:authorize
				access="hasRole('REFEREE'||'CUSTOMER'||'HANDYWORKER')">
				<spring:url value="report/referee/show.do?reportId=${report.id}"
					var="show">
					<i class="far fa-eye"></i>
				</spring:url>
			</security:authorize>
		</jstl:if>
		<jstl:if test="${report.draft }">
			<security:authorize access="hasRole('REFEREE')">
				<spring:url value="report/referee/edit.do?reportId=${report.id}"
					var="edit">
					<i class="fas fa-pencil-alt"></i>
				</spring:url>
				<spring:url
					value="report/referee/delete.do?reportId=${fixUpTask.id}"
					var="delete">
					<i class="fas fa-trash-alt"></i>
				</spring:url>
			</security:authorize>
		</jstl:if>
	</display:column>
	<display:column property="id" titleKey="report.id" />
	<display:column property="moment" titleKey="report.moment" />
	<display:column property="description" titleKey="report.description" />
	<display:column property="draft" titleKey="report.draft" />
</display:table>
<br />
<security:authorize access="hasRole('REFEREE')">
<spring:url
	value="report/referee/create.do"
	var="add">
	<i class="fas fa-plus"></i>
</spring:url>
</security:authorize>
<br />