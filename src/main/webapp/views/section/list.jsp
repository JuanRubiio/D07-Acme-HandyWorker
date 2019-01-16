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

<display:table name="sections" id="row" pagesize="5" requestURI="${requestUri}" class="displaytag">
	
	<spring:message code="section.title" var="title" />
	<display:column property="title" title="${title}" />
	
	<spring:message code="section.text" var="text" />
	<display:column property="text" title="${text}"  />
	
	<spring:message code="section.pictures" var="pictures" />
	<display:column property="pictures" title="${pictures}" />

	<spring:message code="section.orden" var="orden" />
	<display:column property="orden" title="${orden}" />


	<security:authorize access="hasRole('HANDYWORKER')">
		<display:column titleKey="section.show">
			<input type="submit" name="show"
				value="<spring:message code="section.show" />"
				onclick="javascript: relativeRedir('section/handyworker/show.do?sectionId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('HANDYWORKER')">
		<display:column>
		<input type="submit" name="edit"
				value="<spring:message code="section.edit" />"
				onclick="javascript: relativeRedir('section/handyworker/edit.do?sectionId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('HANDYWORKER')">
		<display:column titleKey="section.delete">
			<input type="submit" name="delete"
				value="<spring:message code="section.delete" />"
				onclick="javascript: relativeRedir('section/handyworker/delete.do?sectionId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	
</display:table>

<br/>

<security:authorize access="hasRole('HANDYWORKER')">
	<input type="submit" name="create"
		value="<spring:message code="section.create" />"
		onclick="javascript: relativeRedir('section/handyworker/create.do');" />
</security:authorize>