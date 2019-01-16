<%--
 * edit.jsp
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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<security:authorize access="hasRole('HANDYWORKER')">

	<form:form action="application/save.do" modelAttribute="application"  method="post">
		
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		<form:hidden path="moment"/>
		<form:hidden path="status"/>
		<form:hidden path="customerComment"/>
		<form:hidden path="creditCard"/>
		<form:hidden path="handyWorker"/>
		<form:hidden path="workplan"/>
		<form:hidden path="fixUpTask"/>

		<form:label path="price">
			<spring:message code="application.price" />
		</form:label>
		<form:input path="price" placeholder=""/>
		<form:errors ccClass="error" path="price"/>
		<br />
		
		<form:label path="handyWorkerComments">
			<spring:message code="application.handyWorkerComments" />
		</form:label>
		<form:input path="handyWorkerComments" placeholder=""/>
		<form:errors ccClass="error" path="handyWorkerComments"/>
		<br />
		
		
		<input type="submit" name="save" value="<spring:message code="application.save"/>"/>
		<input type="button" name="cancel" value="<spring:message code="application.edit.cancel"/>"
				onclick="javascript: relativeRedir('application/handyWorker/list.do');"/>
	</form:form>

</security:authorize>


<security:authorize access="hasRole('CUSTOMER')">

	<form:form action="application/save.do" modelAttribute="application"  method="post">
		
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		<form:hidden path="moment"/>
		<form:hidden path="handyWorker"/>
		<form:hidden path="workplan"/>
		<form:hidden path="fixUpTask"/>

		<form:label path="price">
			<spring:message code="application.price" />: 
		</form:label>
		<form:input readonly="true" path="price" value="${application.price}"/>
		<br />
		
		<form:label path="handyWorkerComments">
			<spring:message code="application.handyWorkerComments" />: 
		</form:label>
		<form:input readonly="true" path="handyWorkerComments" value="${application.handyWorkerComments}"/>
		<br />
		
		<form:label path="customerComment">
			<spring:message code="application.customerComment" />
		</form:label>
		<form:input path="customerComment" placeholder=""/>
		<form:errors ccClass="error" path="customerComment"/>
		<br />
		
		<form:select id="status" path="status">
			<form:options
				items="${status}" 
				itemLabel="status"
				itemValue="status"/>
		</form:select>		
		
		<%-- Form status --%>
		<jstl:if test="${application.status=='ACCEPTED'}">
			<form:label path="creditCard">
				<spring:message code="application.creditCard.holderName" />
			</form:label>
			<form:input path="creditCard" placeholder="${application.creditCard.holderName}"/>
			<form:errors ccClass="error" path="creditCard"/>
			<br />
		</jstl:if>
	
		<input type="submit" name="save" value="<spring:message code="application.save"/>"/>
		<input type="button" name="cancel" value="<spring:message code="application.edit.cancel"/>"
				onclick="javascript: relativeRedir('application/customer/list.do');"/>
	</form:form>

</security:authorize>
