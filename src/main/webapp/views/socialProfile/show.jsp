<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="socialProfile/actor/show.do" modelAttribute="socialProfile" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="actor"/>

	<form:label path="nick">
		<spring:message code="socialProfile.nick" />: ${socialProfile.nick}
	</form:label>

	<form:label path="social name">
		<spring:message code="socialProfile.socialName" />: ${socialProfile.socialName}
	</form:label>
	
	<form:label path="link">
		<spring:message code="socialProfile.link" />: ${socialProfile.link}
	</form:label>
	
	<input type="button" name="edit"
		value="<spring:message code="socialProfile.edit" />"
		onclick="javascript: relativeRedir('socialProfile/actor/edit.do');" />
	

	<input type="button" name="Cancel"
		value="<spring:message code="socialProfile.cancel" />"
		onclick="javascript: relativeRedir('welcome/index.do');" />

</form:form>