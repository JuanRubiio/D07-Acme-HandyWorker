<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="fixUpTask/handyWorker/showhw.do" modelAttribute="fixUpTask"
	method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	

	<form:label path="ticker">
		<spring:message code="fixUpTask.ticker" />: ${fixUpTask.ticker}
	</form:label>

	<form:label path="moment">
		<spring:message code="fixUpTask.moment" />: ${fixUpTask.moment}
	</form:label>
	
	<form:label path="description">
		<spring:message code="fixUpTask.description" />: ${fixUpTask.description}
	</form:label>

	<a href="application/handyWorker/create.do">Send application</a>

	<form:label path="address">
		<spring:message code="fixUpTask.address" />: ${fixUpTask.address}
	</form:label>
	
	<form:label path="minPrice">
		<spring:message code="fixUpTask.minPrice" />:  ${fixUpTask.minPrice}
	</form:label>
	
	<form:label path="maxPrice">
		<spring:message code="fixUpTask.maxPrice" />: ${fixUpTask.maxPrice}
	</form:label>
	
	<form:label path="minDate">
		<spring:message code="fixUpTask.minDate" />: ${fixUpTask.minDate}
	</form:label>
	
	<form:label path="maxDate">
		<spring:message code="fixUpTask.maxDate" />: ${fixUpTask.maxDate}
	</form:label>


	<input type="button" name="cancel"
		value="<spring:message code="fixUpTask.cancel" />"
		onclick="javascript: relativeRedir('fixUpTask/handyWorker/listhw.do');" />


</form:form>