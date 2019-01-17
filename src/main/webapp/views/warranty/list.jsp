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

<security:authorize access="hasRole('ADMIN')">
	<display:table name="${warranties}" id="warranty" pagesize="5"
		requestURI="${requestURI}" class="displaytag">
		<display:column>

			<security:authorize access="hasRole('ADMIN')">
				<input type="submit" name="show"
					value="<spring:message code="warranty.show" />"
					onclick="javascript: relativeRedir('warranty/administrator/show.do?warrantyId=${warranty.id}');" />
			</security:authorize>
			<jstl:if test="${warranty.draft }">
				<security:authorize access="hasRole('ADMIN')">
					<input type="submit" name="show"
						value="<spring:message code="warranty.edit" />"
						onclick="javascript: relativeRedir('warranty/administrator/edit.do?warrantyId=${warranty.id}');" />
				</security:authorize>
			</jstl:if>
			<jstl:if test="${warranty.draft }">
				<security:authorize access="hasRole('ADMIN')">
						<input type="submit" name="delete"
							value="<spring:message code="warranty.delete" />"
							onclick="javascript: relativeRedir('warranty/administrator/delete.do?warrantyId=${warranty.id}');" />
				</security:authorize>
			</jstl:if>
		</display:column>
		<display:column property="title" titleKey="warranty.title" />
		<display:column property="terms" titleKey="warranty.terms" />
		<display:column property="laws" titleKey="warranty.laws" />
		<display:column property="draft" titleKey="warranty.draft" />
	</display:table>
	<br />


	<security:authorize access="hasRole('ADMIN')">
	<input type="submit" name="create"
		value="<spring:message code="warranty.create" />"
		onclick="javascript: relativeRedir('warranty/administrator/create.do');" />
</security:authorize>
</security:authorize>
<br />
