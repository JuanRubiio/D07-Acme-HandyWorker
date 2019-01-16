
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


<display:table name="configuration" requestURI="configuration/administrator/show.do" id ="row" class="displaytag">
	<display:column property="banner" titleKey="configuration.banner"/>
	<display:column property="welcomMessage" titleKey="configuration.welcomMessage"/>
	<display:column property="welcomMessageEs" titleKey="configuration.welcomMessageEs"/>
	<display:column property="vat" titleKey="configuration.vat"/>
	<display:column property="countryCode" titleKey="configuration.countryCode"/>
	<display:column property="finderDuration" titleKey="configuration.finderDuration"/>
	<display:column property="maxFiders" titleKey="configuration.maxFiders"/>
	<display:column property="absolutMaxFinders" titleKey="configuration.absolutMaxFinders"/>
	<display:column property="cards" titleKey="configuration.cards"/>
	<display:column property="positiveSpanishWords" titleKey="configuration.positiveSpanishWords"/>
	<display:column property="negativeSpanishWords" titleKey="configuration.negativeSpanishWords"/>
	<display:column property="positiveEnglishWords" titleKey="configuration.positiveEnglishWords"/>
	<display:column property="negativeEnglishWords" titleKey="configuration.negativeEnglishWords"/>



</display:table>
<br />
<input type="button" name="edit"
		value="<spring:message code="configuration.edit" />"
		onclick="javascript: relativeRedir('configuration/administrator/edit.do');" />
	<br />
