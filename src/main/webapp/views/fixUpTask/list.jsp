<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<display:table name="fixUpTasks"
	requestURI="fixUpTask/customer,handyWorker/list.do" class="displaytag">
	<display:column>
		<security:authorize access="hasRole('CUSTOMER')">
			<spring:url
				value="fixUpTask/customer/show.do?fixUpTaskId=${fixUpTask.id}"
				var="show">
				<i class="far fa-eye"></i>
			</spring:url>

			<spring:url
				value="fixUpTask/customer/edit.do?fixUpTaskId=${fixUpTask.id}"
				var="edit">
				<i class="fas fa-pencil-alt"></i>
			</spring:url>

			<spring:url
				value="fixUpTask/customer/delete.do?fixUpTaskId=${fixUpTask.id}"
				var="delete">
				<i class="fas fa-trash-alt"></i>
			</spring:url>
		</security:authorize>
		<security:authorize access="hasRole('HANDYWORKER')">
			<spring:url
				value="customer/handyWorker/list.do?customer=${customer.id}"
				var="list">
				<i class="fas fa-user"></i>
			</spring:url>
		</security:authorize>
	</display:column>
	<display:column property="id" titleKey="fixUpTask.id" />
	<display:column property="ticker" titleKey="fixUpTask.ticker" />
	<display:column property="moment" titleKey="fixUpTask.moment" />
</display:table>
<br />

<security:authorize access="hasRole('CUSTOMER')">
	<spring:url value="fixUpTask/customer/create.do" var="add">
		<i class="fas fa-plus"></i>
	</spring:url>
</security:authorize>
<br />
