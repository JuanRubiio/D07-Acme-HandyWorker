<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="customer/handyWorker/show.do"
	modelAttribute="customer" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />


	<form:label path="name">
		<spring:message code="customer.name" />: ${customer.name}
	</form:label>

	<form:label path="middlename">
		<spring:message code="customer.middlename" />: ${customer.middlename}
	</form:label>

	<form:label path="surname">
		<spring:message code="customer.surname" />: ${customer.surname}
	</form:label>

	<form:label path="photo">
		<spring:message code="customer.photo" />: ${customer.photo}
	</form:label>

	<form:label path="email">
		<spring:message code="customer.email" />: ${customer.email}
	</form:label>

	<form:label path="address">
		<spring:message code="customer.address" />: ${customer.address}
	</form:label>

	<form:label path="phone">
		<spring:message code="customer.phone" />: ${customer.phone}
	</form:label>

	<display:table name="fixUpTask"
		requestURI="fixUpTask/handyWorker/listhw.do" class="displaytag">
		<jstl:if test="${fixUpTask.customer.id==customer.id }">
			<display:column property="id" titleKey="fixUpTask.id" />
			<display:column property="ticker" titleKey="fixUpTask.ticker" />
			<display:column property="moment" titleKey="fixUpTask.moment" />
		</jstl:if>
	</display:table>
	<br />

	<input type="button" name="cancel"
		value="<spring:message code="report.cancel" />"
		onclick="javascript: relativeRedir('fixUpTask/handyWorker/list.do');" />


</form:form>