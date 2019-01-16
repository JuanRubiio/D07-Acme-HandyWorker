<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
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
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<display:table name="spam" id="row" requestURI="spam/administrator/list.do" class="displaytag">

	<display:column property="spamWords" titleKey="spam.spamWords"/>
		
	<security:authorize access="hasRole('ADMIN')">
	
	<display:column titleKey="spam.delete">
            <input type="button" name="delete"
		value="<spring:message code="spam.delete" />"
		onclick="javascript: relativeRedir('spam/administrator/delete.do?spamId={row.id}');" />

        </display:column>
	</security:authorize>
</display:table>

<input type="button" name="create"
		value="<spring:message code="spam.create" />"
		onclick="javascript: relativeRedir('spam/administrator/create.do');" />
	<br />