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

<div>

	<p>
		<spring:message code="customer.name" />
		:
		<jstl:out value="${customer.name }"></jstl:out>
		<jstl:out value="${customer.surname }"></jstl:out>
	</p>
	<p>
		<spring:message code="customer.email" />
		:
		<jstl:out value="${customer.email }"></jstl:out>
	</p>
	<p>
		<spring:message code="customer.phone" />
		:
		<jstl:out value="${customer.phone }"></jstl:out>
	</p>
	<p>
		<spring:message code="customer.address" />
		:
		<jstl:out value="${customer.address }"></jstl:out>
	</p>

</div>

<div>
	<security:authorize access="hasRole('CUSTOMER')">
		<input type="button" name="profiles"
			value="<spring:message code="customer.profiles" />"
			onclick="javascript: relativeRedir('profile/actor/list.do');" />
	</security:authorize>

	<security:authorize access="hasRole('CUSTOMER')">
		<input type="button" name="edit"
			value="<spring:message code="customer.edit" />"
			onclick="javascript: relativeRedir('customer/edit.do');" />
	</security:authorize>

	<security:authorize access="hasRole('HANDYWORKER')">
		<input type="button" name="profiles"
			value="<spring:message code="customer.profiles" />"
			onclick="javascript: relativeRedir('profile/actor/listprofilecustomer.do?customerId=${customer.id}');" />
	</security:authorize>
</div>