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

<!-- 
	Recieves: 
	
	Curricula curricula, si tiene una / null si no la tiene (se le ofrece la posibilidad de crearla).
	
-->

<security:authorize access="hasRole('HANDYWORKER')">
	<jstl:if test="${curricula == null}">
		<spring:message code="curriculum.notCreated"/>
		<h4><a href="curriculum/handyworker/createPersonalRecord.do"><spring:message code="curriculum.create" /></a></h4>
	</jstl:if>
	<jstl:if test="${curricula != null}">
		<h2>Ticker:${curricula.ticker}</h2>
		<h4><a href="curriculum/handyworker/deleteCurriculum.do?curriculaId=${curricula.id}"><spring:message code="curriculum.deleteCurriculum"/></a></h4>
		<h3><spring:message code="curriculum.personalRecord"/></h3>
		<h4><a href="curriculum/handyworker/editPersonalRecord.do?personalRecordId=${curriculum.personalRecord.id}"><spring:message code="curriculum.editPersonalRecord"/></a></h4>
		<spring:message code="curriculum.fullName"/>: <jstl:out value="${curriculum.personalRecord.fullName }"/><br>
		<spring:message code="curriculum.photo"/>: <jstl:out value="${curriculum.personalRecord.photo }"/><br>
		<spring:message code="curriculum.email"/>: <jstl:out value="${curriculum.personalRecord.email }"/><br>
		<spring:message code="curriculum.phone"/>: <jstl:out value="${curriculum.personalRecord.phone }"/><br>
		<spring:message code="curriculum.linkedInProfile"/>: <jstl:out value="${curriculum.personalRecord.linkedInUrl}"/><br>
		<hr>
		
		<h3><spring:message code="curriculum.endorserRecords"/></h3>
		<h4><a href="curriculum/handyworker/createEndorserRecord.do"><spring:message code="curriculum.createEndorserRecord"/></a></h4><hr>
		<jstl:forEach var="i" items="${curricula.endorserRecords }">
		<h4><a href="curriculum/handyworker/editEndorserRecord.do?endorserRecordId=${i.id}"><spring:message code="curriculum.editEndorserRecord"/></a></h4>
		<h4><a href="curriculum/handyworker/deleteEndorserRecord.do?endorserRecordId=${i.id}"><spring:message code="curriculum.deleteEndorserRecord"/></a></h4>
		<spring:message code="curriculum.endorserName"/>: <jstl:out value="${i.endorserName }"/><br>
		<spring:message code="curriculum.email"/>: <jstl:out value="${i.email }"/><br>
		<spring:message code="curriculum.phone"/>: <jstl:out value="${i.phone }"/><br>
		<spring:message code="curriculum.linkedInProfile"/>: <jstl:out value="${i.linkedInProfile }"/><br>
		<spring:message code="curriculum.comments"/>: <jstl:out value="${i.comments }"/><br>
		<hr>
		</jstl:forEach>
		
		
		<h3><spring:message code="curriculum.educationRecords"/></h3>
		<h4><a href="curriculum/handyworker/createEducationRecord.do"><spring:message code="curricula.createEducationRecord"/></a></h4><hr>
		<jstl:forEach var="i" items="${curricula.educationRecords }">
		<h4><a href="curriculum/handyworker/editEducationRecord.do?educationRecordId=${i.id}"><spring:message code="curriculum.editEducationRecord"/></a></h4>
		<h4><a href="curriculum/handyworker/deleteEducationRecord.do?educationRecordId=${i.id}"><spring:message code="curriculum.deleteEducationRecord"/></a></h4>
		<spring:message code="curriculum.diplomaTitle"/>: <jstl:out value="${i.diplomaTitle }"/><br>
		<spring:message code="curriculum.startDate"/>: <jstl:out value="${i.startDate }"/><br>
		<spring:message code="curriculum.endDate"/>: <jstl:out value="${i.endDate }"/><br>
		<spring:message code="curriculum.institution"/>: <jstl:out value="${i.institution }"/><br>
		<spring:message code="curriculum.attachment"/>: <jstl:out value="${i.attachment }"/><br>
		<spring:message code="curriculum.comments"/>: <jstl:out value="${i.comments }"/><br>
		<hr>
		</jstl:forEach>
		
		<h3><spring:message code="curriculum.professionalRecords"/></h3>
		<h4><a href="curriculum/handyworker/createProfessionalRecord.do"><spring:message code="curriculum.createProfessionalRecord"/></a></h4><hr>
		<jstl:forEach var="i" items="${curricula.professionalRecords }">
		<h4><a href="curriculum/handyworker/editProfessionalRecord.do?professionalRecordId=${i.id}"><spring:message code="curriculum.editProfessionalRecord"/></a></h4>
		<h4><a href="curriculum/handyworker/deleteProfessionalRecord.do?prosfessionalRecordId=${i.id}"><spring:message code="curriculum.deleteProfessionalRecord"/></a></h4>
		<spring:message code="curriculum.companyName"/>: <jstl:out value="${i.companyName}"/><br>
		<spring:message code="curriculum.startDate"/>: <jstl:out value="${i.startDate}"/><br>
		<spring:message code="curriculum.endDate"/>: <jstl:out value="${i.endDate }"/><br>
		<spring:message code="curriculum.role"/>: <jstl:out value="${i.role }"/><br>
		<spring:message code="curriculum.attachment"/>: <jstl:out value="${i.attachment }"/><br>
		<spring:message code="curriculum.comments"/>: <jstl:out value="${i.comments }"/><br>
		<hr>
		</jstl:forEach>
		
		<h3><spring:message code="curriculum.miscellaneousRecords"/></h3>
		<h4><a href="curriculum/handyworker/createMiscellaneousRecord.do"><spring:message code="curriculum.createMiscellaneousRecord"/></a></h4>
		<jstl:forEach var="i" items="${curricula.miscellaneousRecords }">
		<h4><a href="curriculum/handyworker/editMiscellaneousRecord.do?miscellaneousRecordId=${i.id}"><spring:message code="curriculum.editMiscellaneousRecord"/></a></h4>
		<h4><a href="curriculum/handyworker/deleteMiscellaneousRecord.do?miscellaneousRecordId=${i.id}"><spring:message code="curriculum.deleteMiscellaneousRecord"/></a></h4>
		<spring:message code="curriculum.title"/>: <jstl:out value="${i.title }"/><br>
		<spring:message code="curriculum.attachment"/>: <jstl:out value="${i.attachment }"/><br>
		<spring:message code="curriculum.comments"/>: <jstl:out value="${i.comments }"/><br>
		<hr>
		</jstl:forEach>
		
	</jstl:if>
	
</security:authorize>