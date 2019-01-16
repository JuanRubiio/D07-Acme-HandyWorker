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


	<spring:message code="sponsorship.link"></spring:message> <jstl:out value="${sponsorship.link}"></jstl:out>
	<br />
	
	<spring:message code="sponsorship.banner"></spring:message> <jstl:out value="${sponsorship.banner}"></jstl:out>
	<br />
	
	<spring:message code="sponsorship.creditCard"></spring:message> <jstl:out value="${sponsorship.creditCard}"></jstl:out>
	<br />
	
	<spring:message code="sponsorship.tutorial"></spring:message> <jstl:out value="${sponsorship.tutorial}"></jstl:out>
	<br />
	
	<spring:message code="sponsorship.sponsor"></spring:message> <jstl:out value="${sponsorship.sponsor}"></jstl:out>
	<br />
		

<!-- Cancel -->

	<security:authorize access="hasRole('sponsor')">	
				<button type="button" onclick="javascript: relativeRedir('sponsorship/sponsor/list.do')">
				<spring:message code="sponsorship.return" />
				</button>
			</security:authorize>