<%--
 * action-1.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
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


	<spring:message code="section.title"></spring:message> <jstl:out value="${section.title}"></jstl:out>
	<br />
	
	<spring:message code="section.text"></spring:message> <jstl:out value="${section.text}"></jstl:out>
	<br />
	
	<spring:message code="section.pictures"></spring:message> <jstl:out value="${section.pictures}"></jstl:out>
	<br />
	
	<spring:message code="section.orden"></spring:message> <jstl:out value="${section.orden}"></jstl:out>
	<br />
		

<!-- Cancel -->

	<security:authorize access="hasRole('HANDYWORKER')">	
				<button type="button" onclick="javascript: relativeRedir('section/handyworker/list.do')">
				<spring:message code="section.return" />
				</button>
			</security:authorize>