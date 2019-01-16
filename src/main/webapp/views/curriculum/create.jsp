<%--
 * list.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action= "${saveURL}" modelAttribute="curriculum">

<form:hidden path="id"/>
<form:hidden path="version"/>
<form:hidden path="handyWorker"/>
<form:hidden path="educationalRecord"/>
<form:hidden path="professionalRecords"/>
<form:hidden path="endoserRecords"/>
<form:hidden path="miscellaneousRecords"/>
<form:hidden path="ticker"/>
<form:hidden path="personalRecord.curriculum"/>
<form:hidden path="personalRecord.id"/>
<form:hidden path="personalRecord.version"/>
<form:hidden path="educationalRecord.curriculum"/>
<form:hidden path="educationalRecord.id"/>
<form:hidden path="educationalRecord.version"/>
<form:hidden path="endorserRecord.curriculum"/>
<form:hidden path="endorserRecord.id"/>
<form:hidden path="endorserRecord.version"/>
<form:hidden path="miscellaneousRecord.curriculum"/>
<form:hidden path="miscellaneousRecord.id"/>
<form:hidden path="miscellaneousRecord.version"/>
<form:hidden path="professionalRecord.curriculum"/>
<form:hidden path="professionalRecord.id"/>
<form:hidden path="professionalRecord.version"/>


<acme:textbox path="personalRecord.name" code="curriculum.name"/>
<acme:textbox path="personalRecord.photo" code="curriculum.photo"/>
<acme:textbox path="personalRecord.email" code="curriculum.email"/>
<acme:textbox path="personalRecord.linkedinIdProfile" code="curriculum.linkedinIdProfile"/>
<acme:textbox path="personalRecord.phoneNumber" code="curriculum.phoneNumber"/>

<acme:textbox path="educationalRecord.title" code="curriculum.title"/>
<acme:textbox path="educationalRecord.institution" code="curriculum.institution"/>
<acme:textbox path="educationalRecord.attachment" code="curriculum.attachment"/>
<acme:textbox path="educationalRecord.comments" code="curriculum.comments"/>
<acme:textbox path="educationalRecord.begin" code="curriculum.begin"/>
<acme:textbox path="educationalRecord.end" code="curriculum.end"/>

<acme:textbox path="professionalRecord.companyName" code="curriculum.companyName"/>
<acme:textbox path="professionalRecord.role" code="curriculum.role"/>
<acme:textbox path="professionalRecord.attachment" code="curriculum.attachment"/>
<acme:textbox path="professionalRecord.comments" code="curriculum.comments"/>
<acme:textbox path="professionalRecord.begin" code="curriculum.begin"/>
<acme:textbox path="professionalRecord.end" code="curriculum.end"/>


<acme:textbox path="endorserRecord.name" code="curriculum.name"/>
<acme:textbox path="endorserRecord.email" code="curriculum.email"/>
<acme:textbox path="endorserRecord.phone" code="curriculum.phone"/>
<acme:textbox path="endorserRecord.attachment" code="curriculum.attachment"/>
<acme:textbox path="endorserRecord.comments" code="curriculum.comments"/>

<acme:textbox path="miscellaneousRecord.title" code="curriculum.title"/>
<acme:textbox path="miscellaneous.attachment" code="curriculum.attachment"/>
<acme:textbox path="miscellaneous.comments" code="curriculum.comments"/>

<tr>
			<td colspan="3">
				<acme:submit code="curriculum.save" name="save"/>
				<acme:cancel code="curriculum.cancel" url="curriculum/handyWorker/list.do" />
			</td>
		</tr>
		<input type="submit" name="save"
		value="<spring:message code="curriculum.save"/>" />


</form:form>




