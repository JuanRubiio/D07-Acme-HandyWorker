<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form:form action="configuration/administrator/edit.do"
	modelAttribute="configuration" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="banner">
		<spring:message code="configuration.banner" />:
	</form:label>
	<form:input path="banner" />
	<form:errors cssClass="error" path="banner" />
	<br />

	<form:label path="welcomMessage">
		<spring:message code="configuration.welcomMessage" />:
	</form:label>
	<form:input path="welcomMessage" />
	<form:errors cssClass="error" path="welcomMessage" />
	<br />

	<form:label path="welcomMessageEs">
		<spring:message code="configuration.welcomMessageEs" />:
	</form:label>
	<form:input path="welcomMessageEs" />
	<form:errors cssClass="error" path="welcomMessageEs" />
	<br />

	<form:label path="vat">
		<spring:message code="configuration.vat" />:
	</form:label>
	<form:input path="vat" />
	<form:errors cssClass="error" path="vat" />
	<br />

	<form:label path="countryCode">
		<spring:message code="configuration.countryCode" />:
	</form:label>
	<form:input path="countryCode" />
	<form:errors cssClass="error" path="countryCode" />
	<br />

	<form:label path="finderDuration">
		<spring:message code="configuration.finderDuration" />:
	</form:label>
	<form:input path="finderDuration" />
	<form:errors cssClass="error" path="finderDuration" />
	<br />

	<form:label path="maxFiders">
		<spring:message code="configuration.maxFiders" />:
	</form:label>
	<form:input path="maxFiders" />
	<form:errors cssClass="error" path="maxFiders" />
	<br />


	<form:label path="absolutMaxFinders">
		<spring:message code="configuration.absolutMaxFinders" />:
	</form:label>
	<form:input path="absolutMaxFinders" />
	<form:errors cssClass="error" path="absolutMaxFinders" />
	<br />

	<form:label path="cards">
		<spring:message code="configuration.cards" />:
	</form:label>
	<form:input path="cards" />
	<form:errors cssClass="error" path="cards" />
	<br />

	<form:label path="positiveSpanishWords">
		<spring:message code="configuration.positiveSpanishWords" />:
	</form:label>
	<form:input path="positiveSpanishWords" />
	<form:errors cssClass="error" path="positiveSpanishWords" />
	<br />

	<form:label path="negativeSpanishWords">
		<spring:message code="configuration.negativeSpanishWords" />:
	</form:label>
	<form:input path="negativeSpanishWords" />
	<form:errors cssClass="error" path="negativeSpanishWords" />
	<br />

	<form:label path="positiveEnglishWords">
		<spring:message code="configuration.positiveEnglishWords" />:
	</form:label>
	<form:input path="positiveEnglishWords" />
	<form:errors cssClass="error" path="positiveEnglishWords" />
	<br />

	<form:label path="negativeEnglishWords">
		<spring:message code="configuration.negativeEnglishWords" />:
	</form:label>
	<form:input path="negativeEnglishWords" />
	<form:errors cssClass="error" path="negativeEnglishWords" />
	<br />


	<input type="submit" name="save"
		value="<spring:message code="configuration.save"/>" />

	<input type="button" name="cancel"
		value="<spring:message code="configuration.cancel" />"
		onclick="javascript: relativeRedir('configuration/administrator/show.do');" />
	<br />

</form:form>
