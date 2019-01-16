<%--
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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="category/administrator/edit.do"  modelAttribute="category" method="post">

	<form:hidden path="id"/>
	<form:hidden path="version" />
	<form:hidden path="father" />
	
	<acme:textbox path="engName" code="category.engName"/>
	<acme:textbox path="espName" code="category.espName"/>
	
	<br>
	
	<input type="submit" name="save"
		value="<spring:message code="category.save"/>" />

	<input type="button" name="cancel"
		value="<spring:message code="category.cancel" />"
		onclick="javascript: relativeRedir('category/administrator/list.do');" />

	
</form:form>
