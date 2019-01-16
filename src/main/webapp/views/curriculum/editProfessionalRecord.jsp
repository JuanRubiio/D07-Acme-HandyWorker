<%--
 * edit.jsp
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- 
	Recibe: ProfessionalRecord : professionalRecord
 -->

<form:form action="curriculum/handyworker/editProfessionalRecord.do" modelAttribute="professionalRecord">
	
	<form:hidden path="id" />
	<form:hidden path="version" />
	
	<security:authorize access="hasRole('HANDYWORKER')">
	
	<form:label path="companyName">
		<spring:message code="curriculum.professionalRecord.companyName" />
	</form:label>
	
	<form:input path="companyName" />
	<form:errors cssClass="error" path="companyName" />
	<br />
	
	<!--  -->
	<form:label path="begin">
		<spring:message code="curriculum.professionalRecord.begin" />
	</form:label>
	
	<form:input path="begin" />
	<form:errors cssClass="error" path="begin" />
	<br />
	
	<!--  -->
	<form:label path="end">
		<spring:message code="curriculum.professionalRecord.end" />
	</form:label>
	
	<form:input path="end" />
	<form:errors cssClass="error" path="end" />
	<br />
	
	<!--  -->
	<form:label path="role">
		<spring:message code="curriculum.professionalRecord.role" />
	</form:label>
	
	<form:input path="role" />
	<form:errors cssClass="error" path="role" />
	<br />
	
	<!--  -->
	<form:label path="attachment">
		<spring:message code="curriculum.professionalRecord.attachment" />
	</form:label>
	
	<form:input path="attachment" />
	<form:errors cssClass="error" path="attachment" />
	<br />
	
	<!--  -->
	<form:label path="comments">
		<spring:message code="curriculum.professionalRecord.comments" />
	</form:label>
	
	<form:textarea path="comments" />
	<form:errors cssClass="error" path="comments" />
	<br />
	
	<input type="submit" name="save" value="<spring:message code="curriculum.save" />" />
				
	<input type="button" name="cancel"
		value="<spring:message code="curriculum.cancel" />"
		onclick="javascript: window.location.replace('')" />
	<br />
	
	</security:authorize>

</form:form>