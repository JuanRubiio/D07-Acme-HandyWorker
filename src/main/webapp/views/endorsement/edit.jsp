<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="endorsement/endorser/edit.do" modelAttribute="endorsement" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="moment" />
	<form:hidden path="writeFrom" />
	<form:hidden path="writeFor" />

	<form:label path="comments">
		<spring:message code="endorsement.comments" />:
	</form:label>
	<form:input path="comments"/>
	<form:errors cssClass="error" path="comments" />
	<br />
	
	<input type="submit" name="Save"
		value="<spring:message code="endorsement.save"/>" />

	<input type="button" name="Cancel"
		value="<spring:message code="endorsement.cancel" />"
		onclick="javascript: relativeRedir('endorsement/endorser/list.do');" />


</form:form>