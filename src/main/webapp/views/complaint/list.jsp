<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="complaints" requestURI="${requestURI}" id="row">
	
	<spring:message code="complaint.ticker" var="tickerHeader" />
	<display:column property="ticker" title="${tickerHeader}" />
	
	<security:authorize access="hasRole('REFEREE')"></security:authorize>
	
	<display:column>
	<security:authorize access="hasRole('CUSTOMER')">
		<a href="complaint/customer/show.do?complaintId=${row.id}">
			<spring:message code="complaint.show"/>
		</a>
	</security:authorize>
	
	<security:authorize access="hasRole('REFEREE')">
		<a href="report/referee/create.do?complaintId=${row.id}">
			<spring:message code="report.create"/>
		</a>
	</security:authorize>
	
	</display:column>	
</display:table>