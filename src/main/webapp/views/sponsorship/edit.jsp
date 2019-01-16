<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="sponsorship/sponsor/edit.do" modelAttribute="sponsorship" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="tutorial" />
	<form:hidden path="sponsor" />
	
	
	
	<form:label path="link">
		<spring:message code="sponsorship.link" />:
	</form:label>
	<form:input path="link"/>
	<form:errors cssClass="error" path="link" />
	<br />
	
	<form:label path="banner">
		<spring:message code="sponsorship.banner" />:
	</form:label>
	<form:input path="banner"/>
	<form:errors cssClass="error" path="banner" />
	<br />

	<form:label path="creditCard">
		<spring:message code="sponsorship.creditCard" />:
	</form:label>
	<form:input path="creditCard"/>
	<form:errors cssClass="error" path="creditCard" />
	<br />

	<input type="submit" name="Save"
		value="<spring:message code="sponsorship.save"/>" />

	<input type="submit" name="Cancel"
		value="<spring:message code="sponsorship.cancel" />"
		onclick="javascript: relativeRedir('sponsorship/sponsor/list.do');" />


</form:form>