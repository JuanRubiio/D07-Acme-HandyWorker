<%--
 * show.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<security:authorize access="hasRole('HANDYWORKER')">

	<form:form action="application/save.do" modelAttribute="application"  method="post">
		
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		<form:hidden path="handyWorker"/>
		<form:hidden path="workplan"/>
		<form:hidden path="fixUpTask"/>

		<form:label path="moment">
			<spring:message code="application.moment" />:
		</form:label>
		<form:input path="moment" value="${application.moment}" readonly="true"/>		
		<br />
		
		<form:label path="price">
			<spring:message code="application.price" />: 
		</form:label>
		<form:input path="price" value="${application.price}" readonly="true"/>
		<br />

		<%-- IF status.Accepted --%>
		<jstl:if test="${application.status=='ACCEPTED'}">
			<form:label path="status">
				<spring:message code="application.status" />: 
			</form:label>
			<form:input path="status" value="${application.status}" readonly="true"/>
			<br />
			
			<form:label path="creditCard">
				<spring:message code="application.creditCard" />: 
			</form:label>
			<form:input path="creditCard" value="${application.creditCard}" readonly="true"/>
			<br />
		
			<form:label path="workplan">
				<spring:url value="phase/show.do?phaseId={phase}">
					<i class="fas fa-plus"></i>
					<spring:param name="phase" value="${phase.id}"/>
				</spring:url>
			</form:label>
		</jstl:if>
		<%-- ENDIF --%>
	
		<form:label path="handyWorkerComments">
			<spring:message code="application.handyWorkerComments" />: 
		</form:label>
		<form:input path="handyWorkerComments" value="${application.handyWorkerComments}" readonly="true"/>
		<br/>
		<form:label path="CustomerComments">
			<spring:message code="application.CustomerComments" />: 
		</form:label>
		<form:input path="CustomerComments" value="${application.CustomerComments}" readonly="true"/>
		<br />
		
		<spring:url value="application/list.do">
			<i class="fas fa-backward">Back</i>
		</spring:url>
	</form:form>

</security:authorize>