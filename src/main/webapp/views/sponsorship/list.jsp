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

<display:table name="sponsorships" id="row" pagesize="5" requestURI="${requestUri}" class="displaytag">
	
	<spring:message code="sponsorship.link" var="link" />
	<display:column property="link" title="${link}" />
	
	<spring:message code="sponsorship.banner" var="banner" />
	<display:column property="banner" title="${banner}"  />
	
	<spring:message code="sponsorship.creditCard" var="creditCard" />
	<display:column property="creditCard.number" title="${creditCard}" />


	<security:authorize access="hasRole('SPONSOR')">
		<display:column titleKey="sponsorship.show">
			<input type="submit" name="show"
				value="<spring:message code="sponsorship.show" />"
				onclick="javascript: relativeRedir('sponsorship/sponsor/show.do?sponsorshipId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('SPONSOR')">
		<display:column titleKey="sponsorship.edit">
		<input type="submit" name="edit"
				value="<spring:message code="sponsorship.edit" />"
				onclick="javascript: relativeRedir('sponsorship/sponsor/edit.do?sponsorshipId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('SPONSOR')">
		<display:column titleKey="sponsorship.delete">
			<input type="submit" name="delete"
				value="<spring:message code="sponsorship.delete" />"
				onclick="javascript: relativeRedir('sponsorship/sponsor/delete.do?sponsorshipId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	
</display:table>

<br/>

<security:authorize access="hasRole('SPONSOR')">
	<input type="submit" name="create"
		value="<spring:message code="sponsorship.create" />"
		onclick="javascript: relativeRedir('sponsorship/sponsor/create.do');" />
</security:authorize>