<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="fixUpTask/customer/create.do" modelAttribute="fixUpTask"
	method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="ticker" />
	<form:hidden path="moment" />

	<form:label path="description">
		<spring:message code="fixUpTask.description" />:
	</form:label>
	<form:input path="description" placeholder="description"/>
	<form:errors cssClass="error" path="description" />
	<br />
	
	<form:label path="address">
		<spring:message code="fixUpTask.address" />:
	</form:label>
	<form:input path="address" placeholder="address"/>
	<form:errors cssClass="error" path="address" />
	<br />
	
	<form:label path="minPrice">
		<spring:message code="fixUpTask.minPrice" />:
	</form:label>
	<form:input path="minPrice" placeholder="minPrice"/>
	<form:errors cssClass="error" path="minPrice" />
	<br />
	
	<form:label path="maxPrice">
		<spring:message code="fixUpTask.maxPrice" />:
	</form:label>
	<form:input path="maxPrice" placeholder="maxPrice"/>
	<form:errors cssClass="error" path="maxPrice" />
	<br />
	
	<form:label path="minDate">
		<spring:message code="fixUpTask.minDate" />:
	</form:label>
	<form:input path="minDate" placeholder="minDate"/>
	<form:errors cssClass="error" path="minDate" />
	<br />
	
	<form:label path="maxDate">
		<spring:message code="fixUpTask.maxDate" />:
	</form:label>
	<form:input path="maxDate" placeholder="maxDate"/>
	<form:errors cssClass="error" path="maxDate" />
	<br />
	

	<input type="submit" name="save"
		value="<spring:message code="fixUpTask.save"/>" />

	<input type="button" name="cancel"
		value="<spring:message code="fixUpTask.cancel" />"
		onclick="javascript: relativeRedir('fixUpTask/customer/listcustomer.do');" />


</form:form>