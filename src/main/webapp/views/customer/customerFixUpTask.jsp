<%--
 * show.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form
	action="customer/handyWorker/show.do?customerId=${customer.id}"
	modelAttribute="fixUpTask" method="post">
	<security:authorize access="hasRole('HANDYWORKER')">
		<form:label path="name">
			<spring:message code="customer.name" />: ${fixUpTask.customer.name}
		</form:label>

		<form:label path="middleName">
			<spring:message code="customer.middleName" />: ${fixUpTask.customer.middleName}
		</form:label>

		<form:label path="surName">
			<spring:message code="customer.surName" />: ${fixUpTask.customer.surName}
		</form:label>

		<form:label path="photo">
			<spring:message code="customer.photo" />: ${fixUpTask.customer.photo}
		</form:label>

		<form:label path="email">
			<spring:message code="customer.email" />: ${fixUpTask.customer.email}
		</form:label>

		<form:label path="address">
			<spring:message code="customer.address" />: ${fixUpTask.customer.address}
		</form:label>

		<form:label path="phone">
			<spring:message code="customer.phone" />: ${fixUpTask.customer.phone}
		</form:label>


		<display:table name="fixUpTask">
			<jstl:forEach var="fixUpTask" items="${customer.fixUpTasks}">
				<display:column property="id"
					titleKey="<jstl:out value="${fixUpTask.id}"/>" />
				<display:column property="id"
					titleKey="<jstl:out value="${fixUpTask.ticker}"/>"/>
				<display:column property="id" titleKey=" <jstl:out value="${fixUpTask.moment}"/>"/>
			</jstl:forEach>
		</display:table>
	</security:authorize>
</form:form>