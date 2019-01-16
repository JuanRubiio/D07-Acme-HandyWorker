<%--
 * search.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="hasRole('HANDYWORKER')">

	<form:form action="finder/save.do" modelAttribute="finder"  method="post">
		
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		<form:hidden path="handyWorker"/>
		<form:hidden path="fixUpTasks"/>
		
		<form:label path="keyWord">
			<spring:message code="finder.keyWord" />
		</form:label>
		<form:input path="keyWord" placeholder=""/>
		<form:errors ccClass="error" path="keyWord"/>
		<br />
	
		<form:label path="minPrice">
			<spring:message code="finder.minPrice" />
		</form:label>
		<form:input path="minPrice" placeholder=""/>
		<form:errors ccClass="error" path="minPrice"/>
		<br />
		
		<form:label path="maxPrice">
			<spring:message code="finder.maxPrice" />
		</form:label>
		<form:input path="maxPrice" placeholder=""/>
		<form:errors ccClass="error" path="maxPrice"/>
		<br />		
		
		<form:label path="minDate">
			<spring:message code="finder.minDate" />
		</form:label>
		<form:input path="minDate" placeholder="dd/MM/yyyy HH:mm"/>
		<form:errors ccClass="error" path="minDate"/>
		<br />	
	
		<form:label path="maxDate">
			<spring:message code="finder.maxDate" />
		</form:label>
		<form:input path="maxDate" placeholder="dd/MM/yyyy HH:mm"/>
		<form:errors ccClass="error" path="maxDate"/>
		<br />
		
		<form:label path="lastDate">
			<spring:message code="finder.lastDate" />
		</form:label>
		<form:input path="lastDate" placeholder="dd/MM/yyyy HH:mm"/>
		<form:errors ccClass="error" path="lastDate"/>
		<br />
	
		<%-- warranty --%>
		<form:select path="warranty">
			<form:options
				items="${warranty}" 
				itemLabel="warranty"
				itemValue="warranty"/>
		</form:select>	
	
		<%-- category --%>
		<form:select path="category">
			<form:options
				items="${category}" 
				itemLabel="category"
				itemValue="category"/>
		</form:select>	
	
		<input type="submit" name="save" value="<spring:message code="finder.save"/>"/>
		
	</form:form>

</security:authorize>