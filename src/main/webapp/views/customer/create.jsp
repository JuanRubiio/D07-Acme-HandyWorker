<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="customer/create.do" modelAttribute="customer">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="photo"/>
	<form:hidden path="suspicious"/>
	<form:hidden path="ban"/>
	<form:hidden path="sentMessages"/>
	<form:hidden path="receivedMessages"/>
	<form:hidden path="messageFolders"/>
	<form:hidden path="profiles"/>
	<form:hidden path="score"/>
	<form:hidden path="complaints"/>
	<form:hidden path="fixUpTasks"/>
	<form:hidden path="userAccount.authorities"/>
	<jstl:if test="${customer.id!=0 }">
	<form:hidden path="userAccount.username"/>
	<form:hidden path="userAccount.password"/>
	</jstl:if>

	<form:label path="name">
		<spring:message code="customer.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />

	<form:label path="surname">
		<spring:message code="customer.surname" />:
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br />
	
	<form:label path="middleName">
		<spring:message code="customer.middleName" />:
	</form:label>
	<form:input path="middleName" />
	<form:errors cssClass="error" path="middleName" />
	<br />
	
	<form:label path="email">
		<spring:message code="customer.email" />:
	</form:label>
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br />
	
	<form:label path="phone">
		<spring:message code="customer.phone" />:
	</form:label>
	<form:input path="phone" />
	<form:errors cssClass="error" path="phone" />
	<br />
	
	<form:label path="address">
		<spring:message code="customer.address" />:
	</form:label>
	<form:input path="address" />
	<form:errors cssClass="error" path="address" />
	<br />
	<br/>
	
	<jstl:if test="${customer.id==0 }">
		<form:label path="userAccount.username">
			<spring:message code="customer.username" />:
		</form:label>
		<form:input path="userAccount.username" />
		<form:errors cssClass="error" path="userAccount.username" />
		<br />
		
		<form:label path="userAccount.password">
			<spring:message code="customer.password" />:
		</form:label>
		<form:password path="userAccount.password" />
		<form:errors cssClass="error" path="userAccount.password" />
		<br />
	</jstl:if>

	<input type="submit" name="save"
	value="<spring:message code="customer.save" />" />&nbsp; 
	
	<jstl:if test="${customer.id!=0 }">
	<input type="button" name="profiles"
	value="<spring:message code="customer.profiles" />"
	onclick="javascript: relativeRedir('customer/show.do');" /> 
	</jstl:if>
	
</form:form>