<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<p>
	<fieldset>
	<b><spring:message code="warranty.title"></spring:message>:</b> <jstl:out value="${warranty.title}"></jstl:out>
	<br />
	
	<b><spring:message code="warranty.terms"></spring:message>:</b> <jstl:out value="${warranty.terms}"></jstl:out>
	<br />
	
	<b><spring:message code="warranty.laws"></spring:message>:</b> <jstl:out value="${warranty.laws}"></jstl:out>
	<br />
	
	</fieldset>
	


<security:authorize access="hasRole('ADMIN')">	
		<input type="submit" name="cancel" value="<spring:message code="warranty.cancel" />"
		onclick="javascript: relativeRedir('warranty/administrator/list.do');" />
			</security:authorize>
