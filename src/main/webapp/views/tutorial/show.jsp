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

<p>

	<fieldset>
	<b><spring:message code="tutorial.title"></spring:message>:</b> <jstl:out value="${tutorial.title}"></jstl:out>
	<br />
	
	<b><spring:message code="tutorial.momentUpdate"></spring:message>:</b> <jstl:out value="${tutorial.momentUpdate}"></jstl:out>
	<br />
	
	<b><spring:message code="tutorial.momentCreate"></spring:message>:</b> <jstl:out value="${tutorial.momentCreate}"></jstl:out>
	<br />
	
	<b><spring:message code="tutorial.summary"></spring:message>:</b> <jstl:out value="${tutorial.summary}"></jstl:out>
	<br />
	
	<b><spring:message code="tutorial.pictures"></spring:message>:</b> <jstl:out value="${tutorial.pictures}"></jstl:out>
	<br />
	
	<b><spring:message code="tutorial.handyWorker"></spring:message>:</b> <jstl:out value="${tutorial.handyWorker.name}"></jstl:out>
	<br />
	
	<b><spring:message code="tutorial.sections"></spring:message>:</b> <input type="submit" name="listsections" value="<spring:message code="tutorial.listsections"/>" 
	onclick="javascript:relativeRedir('section/handyworker/list.do?tutorialId=${tutorial.id}')" />			
	<br />
				
	</fieldset>

		<br />
			

	<security:authorize access="hasRole('HANDYWORKER')">	
		<input type="submit" name="cancel" value="<spring:message code="tutorial.cancel" />"
		onclick="javascript: relativeRedir('tutorial/handyworker/list.do');" />
			</security:authorize>