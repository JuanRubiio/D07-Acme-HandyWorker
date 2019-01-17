<<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<display:table name="tutorials" id="row" pagesize="5" requestURI="${requestUri}" class="displaytag">
	
	<spring:message code="tutorial.title" var="title" />
	<display:column property="title" title="${title}" />
	
	<spring:message code="tutorial.momentUpdate" var="momentUpdate" />
	<display:column property="momentUpdate" title="${momentUpdate}" /> 
	
	<spring:message code="tutorial.summary" var="summary" />
	<display:column property="summary" title="${summary}"  />
	
	<spring:message code="tutorial.pictures" var="pictures" />
	<display:column property="pictures" title="${pictures}" />
		
	
	<security:authorize access="hasRole('HANDYWORKER')">
		<display:column titleKey="tutorial.show">
			<input type="submit" name="show" value="<spring:message code="tutorial.show" />"
			onclick="javascript: relativeRedir('tutorial/handyworker/show.do?tutorialId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('HANDYWORKER')">
		<display:column titleKey="tutorial.edit">
		<input type="submit" name="edit" value="<spring:message code="tutorial.edit" />"
		onclick="javascript: relativeRedir('tutorial/handyworker/edit.do?tutorialId=${row.id}');" /> 
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('HANDYWORKER')">
		<display:column titleKey="tutorial.delete">
			<input type="submit" name="delete" value="<spring:message code="tutorial.delete" />"
				onclick="javascript: relativeRedir('tutorial/handyworker/delete.do?tutorialId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	
</display:table>

<br/>

<security:authorize access="hasRole('HANDYWORKER')">
	<input type="submit" name="create"
		value="<spring:message code="tutorial.create" />"
		onclick="javascript: relativeRedir('tutorial/handyworker/create.do');" />
</security:authorize>