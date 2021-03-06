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

<form:form action="messagebox/edit.do" modelAttribute="messagebox">
	<form:hidden path="id"/>
	<form:hidden path="version" />
	<form:hidden path="actor" />
	<form:hidden path="messages" />
	<form:hidden path="system" />
	
	<form:label path="name" >
		<spring:message code="messagebox.name" />
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name"/>
	<br>
	
	<input type="submit" name="save" value="<spring:message code="messagebox.save" />" />
	
	<jstl:if test="${!messageBox.system && messageBox.id != 0}">
		<input type="submit" name="delete" value="<spring:message code="messagebox.delete"/>" onclick="return confirm('<spring:message code="messagebox.confirm.delete" />')"/>
	</jstl:if>
	
	<input type="button" name="cancel" value="<spring:message code="messagebox.cancel" />" onclick="javascript: window.history.back()" />
	
</form:form>
