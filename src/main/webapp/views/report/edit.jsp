<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="report/referee/edit.do" modelAttribute="report"
	method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="referee" />
	<form:hidden path="complaint" />
	<form:hidden path="moment" />

	<form:label path="description">
		<spring:message code="report.description" />:
	</form:label>
	<jstl:if test="${report.version==0 }">
		<form:input path="description" />
	</jstl:if>
	<jstl:if test="${report.version!=0 }">
		<form:input path="description" value="${report.description}" />
	</jstl:if>
	<form:errors cssClass="error" path="description" />
	<br />
	
	<form:label path="attachements">
		<spring:message code="report.attachements" />:
	</form:label>
	<form:input path="attachements" placeholder="${report.attachements}"/>
	<form:errors cssClass="error" path="attachements" />
	<br />
	
	<form:checkbox path="draft" />Draft
	<br />
	
	<form:label path="collectionNotes">
		<spring:message code="report.collectionNotes" />:
	</form:label>
	<spring:url value="/note/customer,referee,handyWorker/list.do?reportId=*" var="list">
		<i class="far fa-eye"></i>
	</spring:url>
	
	

	<input type="submit" name="save"
		value="<spring:message code="report.save"/>" />

	<input type="button" name="cancel"
		value="<spring:message code="report.cancel" />"
		onclick="javascript: relativeRedir('report/referee/list.do');" />


</form:form>