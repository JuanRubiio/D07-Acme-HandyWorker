<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="message/authenticate/create.do" modelAttribute="message">
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="sender" />
	<form:hidden path="date" />
	<form:hidden path="recipient" />
	<form:hidden path="spam" />

	<acme:textbox code="message.subject" path="subject" />

	<acme:textarea code="message.body" path="body" />

	<spring:message code="message.recipient" />
	<form:select path="recipient">
		<form:option label="----" value="0" />
		<form:options items="${actors}" itemLabel="name" itemValue="id" />
	</form:select>
	<form:errors cssClass="error" path="recipient" />
	<br>

	<spring:message code="message.priority" />
	<form:select path="priority">
		<form:option label="LOW" value="0" />
		<form:option label="NEUTRAL" value="1" />
		<form:option label="HIGH" value="2" />
	</form:select>
	<form:errors cssClass="error" path="priority" />
	<br>
	<acme:textbox code="message.tags" path="tags" />

	<acme:submit name="save" code="message.save" />

	<acme:cancel url="messagebox/list.do"
		code="message.cancel" />

</form:form>
