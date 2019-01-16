<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="tutorial/handyworker/edit.do" modelAttribute="tutorial" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="momentCreate" />
	<form:hidden path="momentUpdate" />
	<form:hidden path="handyWorker" />
	<form:hidden path="sections" />

	<form:label path="title">
		<spring:message code="tutorial.title" />:
	</form:label>
	<form:input path="title"/>
	<form:errors cssClass="error" path="title" />
	<br />
	
	<form:label path="summary">
		<spring:message code="tutorial.summary" />:
	</form:label>
	<form:input path="summary"/>
	<form:errors cssClass="error" path="summary" />
	<br />

	<form:label path="pictures">
		<spring:message code="tutorial.pictures" />:
	</form:label>
	<form:input path="pictures"/>
	<form:errors cssClass="error" path="pictures" />
	<br />

	<input type="submit" name="Save"
		value="<spring:message code="tutorial.save"/>" />

	<input type="submit" name="Cancel"
		value="<spring:message code="tutorial.cancel" />"
		onclick="javascript: relativeRedir('tutorial/handyworker/list.do');" />


</form:form>