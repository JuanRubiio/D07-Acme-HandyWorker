
<%--
 * edit.jsp
 *
 * Copyright (C) 2016 Universidad de Sevilla
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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<fieldset>
	<form:form action="message/create.do" modelAttribute="message" method="post">

		<form:hidden path="id" />
		<form:hidden path="version" />
		<form:hidden path="sender" />
		<form:hidden path="date" />
		<form:hidden path="spam" />

		<acme:select path="recipient" code="message.recipient" items="${actors}"
		itemLabel="name" />
	

		<acme:textbox path="subject" code="message.subject" />
		<acme:textbox path="body" code="message.body" />
	

		<form:label path="priority">
			<spring:message code="message.priority" />:
	</form:label>
		<form:select path="priority">
			<form:option value="HIGH" label="HIGH" />
			<form:option value="NEUTRAL" label="NEUTRAL" />
			<form:option value="LOW" label="LOW" />
		</form:select>
		<form:errors cssClass="error" path="priority" />
		<br />
		<br />


		<input type="submit" name="save"
			value="<spring:message code="message.save" />" />&nbsp; 
		
		<input type="button" name="cancel"
			value="<spring:message code="message.cancel" />"
			onclick="javascript: window.location.replace('welcome/index.do');" />
		<br />

	</form:form>
</fieldset>
