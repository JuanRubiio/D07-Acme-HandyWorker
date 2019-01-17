<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

	<fieldset>
	<b><spring:message code="fixUpTask.ticker"></spring:message>:</b> <jstl:out value="${fixUpTask.ticker}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.moment"></spring:message>:</b> <jstl:out value="${fixUpTask.moment}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.description"></spring:message>:</b> <jstl:out value="${fixUpTask.description}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.address"></spring:message>:</b> <jstl:out value="${fixUpTask.address}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.minPrice"></spring:message>:</b> <jstl:out value="${fixUpTask.minPrice}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.maxPrice"></spring:message>:</b> <jstl:out value="${fixUpTask.maxPrice}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.minDate"></spring:message>:</b> <jstl:out value="${fixUpTask.minDate}"></jstl:out>
	<br />
	
	<b><spring:message code="fixUpTask.maxDate"></spring:message>:</b> <jstl:out value="${fixUpTask.maxDate}"></jstl:out>
	<br />
	
	
				
	</fieldset>

		<br />
			

	<security:authorize access="hasRole('CUSTOMER')">	
		<input type="submit" name="cancel" value="<spring:message code="fixUpTask.cancel" />"
		onclick="javascript: relativeRedir('fixUpTask/customer/list.do');" />
			</security:authorize>