<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

	<spring:message code="endorsement.moment"></spring:message> <jstl:out value="${endorsement.moment}"></jstl:out>
	<br />
	
	<spring:message code="endorsement.comments"></spring:message> <jstl:out value="${endorsement.comments}"></jstl:out>
	<br />
	
	<spring:message code="endorsement.writeFrom"></spring:message> <jstl:out value="${endorsement.writeFrom}"></jstl:out>
	<br />
	
	<spring:message code="endorsement.writeFor"></spring:message> <jstl:out value="${endorsement.writeFor}"></jstl:out>
	<br />
	
	
	<security:authorize access="hasAnyRole('HANDYWORKER','CUSTOMER')">
				<button type="button"
					onclick="javascript: relativeRedir('endorsement/endorser/list.do')">
					<spring:message code="endorsement.return" />
				</button>
			</security:authorize>