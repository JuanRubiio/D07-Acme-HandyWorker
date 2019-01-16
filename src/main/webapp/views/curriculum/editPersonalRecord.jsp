<%--
 * edit.jsp
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- 
	Recibe: PersonalRecord - personalRecord
 -->

<form:form action="curriculum/handyworker/editPersonalRecord.do" modelAttribute="personalRecord">

	<form:hidden path="id" />
	<form:hidden path="version" />
	
	<security:authorize access="hasRole('HANDYWORKER')">
	
	
	
	<form:label path="name">
		<spring:message code="curriculum.personalRecord.name" />
	</form:label>
	
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />
	
	<!--  -->
	<form:label path="photo">
		<spring:message code="curriculum.personalRecord.photo" />
	</form:label>
	
	<form:input path="photo" />
	<form:errors cssClass="error" path="photo" />
	<br />
	
	<!--  -->
	<form:label path="email">
		<spring:message code="curriculum.personalRecord.email" />
	</form:label>
	
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br />
	
	<!--  -->
	<form:label path="phone">
		<spring:message code="curriculum.personalRecord.phone" />
	</form:label>
	
	<form:input path="phone" />
	<form:errors cssClass="error" path="phone" />
	<br />
	
	<!--  -->
	<form:label path="linkedinIdProfile">
		<spring:message code="curriculum.personalRecord.linkedinIdProfile" />
	</form:label>
	
	<form:input path="linkedinIdProfile" />
	<form:errors cssClass="error" path="linkedinIdProfile" />
	<br />
		
	
	<input type="submit" name="save" value="<spring:message code="curriculum.save" />" />
				
	<input type="button" name="cancel"
		value="<spring:message code="curriculum.cancel" />"
		onclick="javascript: window.location.replace('')" />
	<br />
	
	</security:authorize>

</form:form>