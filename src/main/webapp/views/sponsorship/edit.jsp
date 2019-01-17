<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="sponsorship/sponsor/save.do" modelAttribute="sponsorship" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="sponsor" />
	
	
	
	<form:label path="link">
		<spring:message code="sponsorship.link" />:
	</form:label>
	<form:input path="link"/>
	<form:errors cssClass="error" path="link" />
	<br />
	
	<form:label path="banner">
		<spring:message code="sponsorship.banner" />:
	</form:label>
	<form:input path="banner"/>
	<form:errors cssClass="error" path="banner" />
	<br />



	<form:label path="creditCard">
		<spring:message code="sponsorship.creditCard" />:
	</form:label>
		<form:select path="creditCard" >
			<form:options
				items="${card}" 
				itemLabel="number"
				/>
	</form:select>	
	<br />
	
	
	
	<jstl:if test='${sponsorship.id == 0}'>
	
	<form:label path="tutorial">
		<spring:message code="sponsorship.tutorial" />:
	</form:label>
	<form:select path="tutorial" >
			<form:options
				items="${tutorials}" 
				itemLabel="title"
				/>
	</form:select>	
	<br />	
	<br />	
	
	</jstl:if>

	<input type="submit" name="save"
		value="<spring:message code="sponsorship.save"/>" />

	<input type="button" name="cancel"
		value="<spring:message code="sponsorship.cancel" />"
		onclick="javascript: relativeRedir('sponsorship/sponsor/list.do');" />


</form:form>