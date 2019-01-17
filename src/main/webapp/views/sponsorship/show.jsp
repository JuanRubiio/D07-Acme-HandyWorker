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


	<fieldset>

	<b><spring:message code="sponsorship.link"></spring:message>:</b><jstl:out value="${sponsorship.link}"></jstl:out>
	<br />
	
	<b><spring:message code="sponsorship.banner"></spring:message>:</b><jstl:out value="${sponsorship.banner}"></jstl:out>
	<br />
	
	<b><spring:message code="sponsorship.creditCard"></spring:message>:</b><jstl:out value="${sponsorship.creditCard.number}"></jstl:out>
	<br />
	
	<b><spring:message code="sponsorship.tutorial"></spring:message>:</b><jstl:out value="${sponsorship.tutorial.title}"></jstl:out>
	<br />
	
	<b><spring:message code="sponsorship.sponsor"></spring:message>:</b><jstl:out value="${sponsorship.sponsor.name}"></jstl:out>
	<br />
		
	</fieldset>

	<br />
	
<!-- Cancel -->

<security:authorize access="hasRole('SPONSOR')">	
				<button type="button" onclick="javascript: relativeRedir('sponsorship/sponsor/list.do')">
				<spring:message code="sponsorship.cancel" />
				</button>
		</security:authorize>