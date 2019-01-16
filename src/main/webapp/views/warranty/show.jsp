<<<<<<< HEAD
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<p>
	<spring:message code="warranty.title" />
	:
	<jstl:out value="${warranty.title }"></jstl:out>
</p>
<!-- <p> -->
<%-- 	<spring:message code="warranty.finalMode" /> --%>
<!-- 	: -->
<%-- 	<jstl:out value="${warranty.finalMode }"></jstl:out> --%>
<!-- </p> -->
<p>
	<spring:message code="warranty.terms" />
	:
	<jstl:out value="${warranty.terms }"></jstl:out>
</p>
<p>
	<spring:message code="warranty.laws" />
	:
	<jstl:out value="${warranty.laws }"></jstl:out>
</p>
=======
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
<form:form action="warranty/administrator/show.do" modelAttribute="warranty"
	method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	

	<form:label path="title">
		<spring:message code="warranty.title" />: ${warranty.title}
	</form:label>

	<form:label path="terms">
		<spring:message code="warranty.terms" />: ${warranty.terms}
	</form:label>
	
	<form:label path="laws">
		<spring:message code="warranty.laws" />: ${warranty.laws}
	</form:label>


	<input type="button" name="cancel"
		value="<spring:message code="warranty.cancel" />"
		onclick="javascript: relativeRedir('warranty/administrator/list.do');" />


</form:form>
>>>>>>> dev_regina
