<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<display:table name="fixUpTask" id="row" pagesize="5" requestURI="${requestUri}" class="displaytag">

	<spring:message code="fixUpTask.id" var="id" />
	<display:column property="id" title="${id}" />
	
	<spring:message code="fixUpTask.ticker" var="ticker" />
	<display:column property="ticker" title="${ticker}" />
	
	<spring:message code="fixUpTask.moment" var="momentt" />
	<display:column property="moment" titleKey="${momentt}" />
	
	<security:authorize access="hasRole('CUSTOMER')">
		<display:column titleKey="fixUpTask.show">
			<input type="submit" name="show" value="<spring:message code="fixUpTask.show" />"
			onclick="javascript: relativeRedir('fixUpTask/customer/show.do?fixUpTaskId=${row.id}');" />
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('CUSTOMER')">
		<display:column titleKey="fixUpTask.edit">
		<input type="submit" name="edit" value="<spring:message code="fixUpTask.edit" />"
		onclick="javascript: relativeRedir('fixUpTask/customer/edit.do?fixUpTaskId=${row.id}');" /> 
		</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('CUSTOMER')">
		<display:column titleKey="fixUpTask.delete">
			<input type="submit" name="delete" value="<spring:message code="fixUpTask.delete" />"
				onclick="javascript: relativeRedir('fixUpTask/customer/delete.do?fixUpTaskId=${row.id}');" />
		</display:column>
	</security:authorize>
	
</display:table>
<br />

<security:authorize access="hasRole('CUSTOMER')">
	<input type="submit" name="create" value="<spring:message code="fixUpTask.create" />"
		onclick="javascript: relativeRedir('fixUpTask/customer/create.do');" />
</security:authorize>