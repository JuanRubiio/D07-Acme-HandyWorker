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

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<security:authorize access="hasRole('ADMIN')">  
<display:table name="${warranties}" id="warranty" pagesize="5"
	requestURI="${requestURI}" class="displaytag">
	<display:column>
		
    
			<a href="warranty/administrator/show.do?warrantyId=${warranty.id}"/>	<i class="far fa-eye"></i>
			
			
			<jstl:if test="${warranty.draft }">
			<a href="warranty/administrator/edit.do?warrantyId=${warranty.id}"/>	<i class="fas fa-pencil-alt"></i>
			<a href="warranty/administrator/delete.do?warrantyId=${warranty.id}"/>		<i class="fas fa-trash-alt"></i>
			</jstl:if>
	</display:column>
	<display:column property="title" titleKey="warranty.title" />
	<display:column property="terms" titleKey="warranty.terms" />
	<display:column property="laws" titleKey="warranty.laws" />
	<display:column property="draft" titleKey="warranty.draft" />
</display:table>
<br />


<spring:url
	value="fixUpTask/customer/create.do"
	var="add">
	<i class="fas fa-plus"></i>
</spring:url>
</security:authorize>
<br />
