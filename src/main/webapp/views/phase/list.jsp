<%--
 * list.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<display:table name="${phases}" id="phase" pagesize="5"
	requestURI="${requestURI}" class="displaytag">

<security:authorize access="hasRole('HANDYWORKER')">

	<display:column property="id" title="phase.id"/>
	<display:column property="title" title="phase.title"/>
	<display:column property="startMoment" title="phase.startMoment"/>
	<display:column property="endMoment" title="phase.endMoment"/>
	<display:column>
		<spring:url value="phase/show.do?phaseId=${phase.id}" var="eye"/>
		<img src="main/webapp/images/eye.png"/>
		
		<spring:url value="phase/edit.do?phaseId=${phase.id}" var="pencil"/>
		<img src="main/webapp/images/pencil.png"/>
			
		<spring:url value="phase/edit.do?[POST:delete]">
		<img src="main/webapp/images/trash.png"/>
		</spring:url>
	</display:column>

</security:authorize>
</display:table>