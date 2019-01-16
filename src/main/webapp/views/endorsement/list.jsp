
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<display:table name="endorsements" id="row" pagesize="5" requestURI="${requestUri}" class="displaytag">
	
	<spring:message code="endorsement.writeFor" var="writeFor" />
	<display:column title="${writeFor}" property="writeFor.name" />
	
	<spring:message code="endorsement.moment" var="moment" />
	<display:column title="${moment}" >
		<fmt:formatDate value="${row.getMoment()}" pattern="dd/MM/yyyy HH:mm" />
	</display:column>	
	
	<spring:message code="endorsement.comments" var="comments" />
	<display:column title="${comments}" property="comments" />
	
	<security:authorize access="hasRole('CUSTOMER'||'HANDYWORKER')">
		<display:column>
		<input type="submit" name="edit"
				value="<spring:message code="endorsement.edit" />"
				onclick="javascript: relativeRedir('endorsement/endorser/edit.do?endorsementId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('CUSTOMER'||'HANDYWORKER')">
		<display:column titleKey="endorsement.delete">
			<input type="submit" name="delete"
				value="<spring:message code="endorsement.delete" />"
				onclick="javascript: relativeRedir('endorsement/endorser/delete.do?endorsementId={row.id}');" />
		</display:column>
	</security:authorize>
	
	
	<security:authorize access="hasRole('CUSTOMER'||'HANDYWORKER')">
		<display:column titleKey="endorsement.show">
			<input type="submit" name="show"
				value="<spring:message code="endorsement.show" />"
				onclick="javascript: relativeRedir('endorsement/endorser/show.do?endorsementId={row.id}');" />
		</display:column>
	</security:authorize>
	
</display:table>

<br/>

<security:authorize access="hasRole('CUSTOMER'||'HANDYWORKER')">
	<input type="submit" name="create"
		value="<spring:message code="endorsement.create" />"
		onclick="javascript: relativeRedir('endorsement/endorser/create.do');" />
</security:authorize>