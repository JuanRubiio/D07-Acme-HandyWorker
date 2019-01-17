<%--
 * list.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<display:table name="categories" id="row" requestURI="${requestURI}"
	pagesize="10" class="displaytag">

<jstl:choose>
<jstl:when test="${language==es}">
	<display:column titleKey="category.name">
		<a>${row.espName}</a>
	</display:column>

	<display:column titleKey="category.father">
	
				<a>${row.father.espName}</a>
		
			
	</display:column>

</jstl:when>

<jstl:when test="${language==en}">
	<display:column titleKey="category.name">
		<a>${row.engName}</a>
	</display:column>

	<display:column titleKey="category.father">
	
	<a>${row.father.engName}</a>
	
	</display:column>

</jstl:when>

</jstl:choose>
	<security:authorize access="hasRole('ADMIN')">
		<display:column titleKey="category.edit">
			<c:if test="${not empty row.father}">
				<acme:cancel code="category.edit"
					url="/category/administrator/edit.do?categoryId=${row.id}" />
			</c:if>
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<display:column titleKey="category.delete">
			<input type="submit" name="delete" 
				value="<spring:message code="category.delete" />"
				onclick="javascript: relativeRedir('category/administrator/delete.do?categoryId=${row.id}');" />

		</display:column>

	</security:authorize>

</display:table>

<security:authorize access="hasRole('ADMIN')">
	<input type="submit" name="create"
		value="<spring:message code="category.create" />"
		onclick="javascript: relativeRedir('category/administrator/create.do');" />

</security:authorize>

<br>



