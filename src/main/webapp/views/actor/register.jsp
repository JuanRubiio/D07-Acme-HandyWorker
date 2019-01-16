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

<form:form action="actor/register.do" modelAttribute="actor">

	<fieldset>
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="userAccount" />
	<form:hidden path="messageboxes" />
	<form:hidden path="suspicious" />
	

	<form:label path="name">
		<spring:message code="actor.name" />:  
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br></br>

	<form:label path="surname">
		<spring:message code="actor.surname" />:  
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br></br>
	
	<form:label path="middlename">
		<spring:message code="actor.middlename "/>:  
	</form:label>
	<form:input path="middlename" />
	<form:errors cssClass="error" path="middlename" />
	<br></br>

	<form:label path="email">
		<spring:message code="actor.email" />:  
	</form:label>
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br></br>

	<form:label path="phoneNumber">
		<spring:message code="actor.phoneNumber" />:  
	</form:label>
	<form:input path="phoneNumber" />
	<form:errors cssClass="error" path="phoneNumber" />
	<br></br>

	<form:label path="address">
		<spring:message code="actor.address" />:  
	</form:label>
	<form:input path="address" />
	<form:errors cssClass="error" path="address" />
	<br></br>

		<form:label path="photo">
			<spring:message code="actor.photo" />:  
	</form:label>
		<form:input path="photo" />
		<form:errors cssClass="error" path="photo" />
		<br></br>

		<form:select path="role">
	
		<form:options
			items="${ roles }"
			itemLabel="role"
			itemValue="role"/>
	
	</form:select>



	<input type="submit" name="save"
		value="<spring:message code="actor.save"/>" />
	&nbsp;
	<input type="button" name="cancel"
		value="<spring:message code="actor.cancel" />"
		onclick="javascript: window.location.replace('welcome/index.do');" />
		
	</fieldset>
</form:form>
