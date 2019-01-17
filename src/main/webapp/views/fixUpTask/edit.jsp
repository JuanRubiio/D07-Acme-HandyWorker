<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<%
String languageValue;
try{
Cookie[] cookies = request.getCookies();
Cookie languageCookie = null;
for(Cookie c : cookies) {
	if(c.getName().equals("language")) {
		languageCookie = c;
	}
}
languageValue = languageCookie.getValue();}
catch(NullPointerException e){
	languageValue = "en";	
}
%>

<form:form action="fixUpTask/customer/save.do" modelAttribute="fixUpTask" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="ticker" />
	<form:hidden path="moment" />
	<form:hidden path="customer" />
	<form:hidden path="complaints" />	
	<form:hidden path="applications" />
	
	
	<jstl:if test='${fixUpTask.id != 0}'>
	<form:hidden path="warranty" />
	<form:hidden path="category" />
	</jstl:if>

	<form:label path="description">
		<spring:message code="fixUpTask.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />
	<br />
	

	<form:label path="address">
		<spring:message code="fixUpTask.address" />:
	</form:label>
	<form:input path="address"  />
	<form:errors cssClass="error" path="address" />
	<br />
<br />
	<form:label path="minPrice">
		<spring:message code="fixUpTask.minPrice" />:
	</form:label>
	<form:input path="minPrice" />
	<form:errors cssClass="error" path="minPrice" />
	<br />
<br />
	<form:label path="maxPrice">
		<spring:message code="fixUpTask.maxPrice" />:
	</form:label>
	<form:input path="maxPrice" />
	<form:errors cssClass="error" path="maxPrice" />
	<br />
<br />
	<form:label path="minDate">
		<spring:message code="fixUpTask.minDate" />:
	</form:label>
	<form:input path="minDate" />
	<form:errors cssClass="error" path="minDate" />
	<br />
<br />
	<form:label path="maxDate">
		<spring:message code="fixUpTask.maxDate" />:
	</form:label>
	<form:input path="maxDate" />
	<form:errors cssClass="error" path="maxDate" />
	<br />
	<br />
	<jstl:if test='${fixUpTask.id == 0}'>
	
	<form:label path="warranty">
	<spring:message code="fixUpTask.warranty"></spring:message>
	</form:label>
	<form:select id="warranty" path="warranty">
	<form:option value="${warranties}" label="------"></form:option>

	<form:options items="${warranties}" itemLabel="title" itemValue="id" />
	
	</form:select>
	<form:errors cssClass="error" path="warranty" />
	<br />
	<br />
	<form:label path="category">
	<spring:message code="fixUpTask.category"></spring:message>
	</form:label>
	<form:select id="category" path="category">
	<form:option value="${categories}" label="------"></form:option>

					<%
						if (languageValue.equals("en")) {
					%>
					<form:options items="${categories}" itemLabel="engName"
						itemValue="id" />
					<%
						} else if (languageValue.equals("es")) {
					%>
					<form:options items="${categories}" itemLabel="espName"
						itemValue="id" />
					<%
						}
					%>

	</form:select>
	<form:errors cssClass="error" path="category" />
	<br />
<br />
	</jstl:if>

	<input type="submit" name="save"
		value="<spring:message code="fixUpTask.save"/>" />

	<input type="button" name="cancel"
		value="<spring:message code="fixUpTask.cancel" />"
		onclick="javascript: relativeRedir('fixUpTask/customer/list.do');" />


</form:form>