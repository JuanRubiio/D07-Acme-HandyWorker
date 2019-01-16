<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="report/referee/show.do" modelAttribute="report"
	method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="referee" />
	<form:hidden path="complaint" />
	<form:hidden path="collectionNotes" />
	<form:hidden path="moment" />

	<form:label path="description">
		<spring:message code="report.description" />: ${report.description}
	</form:label>

	<form:label path="attachements">
		<spring:message code="report.attachements" />: ${report.attachments}
	</form:label>


	<input type="button" name="cancel"
		value="<spring:message code="report.cancel" />"
		onclick="javascript: relativeRedir('report/referee/list.do');" />


</form:form>