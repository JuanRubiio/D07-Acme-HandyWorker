<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2><spring:message	code="dashboard.query1" />:</h2> <c:out value="${query1[0]}"/> - <c:out value="${query1[1]}"/> - <c:out value="${query1[2]}"/> - <c:out value="${query1[3]}"/><br>
<h2><spring:message	code="dashboard.query2" />:</h2> <c:out value="${query2[0]}"/> - <c:out value="${query2[1]}"/> - <c:out value="${query2[2]}"/> - <c:out value="${query2[3]}"/><br>
<h2><spring:message	code="dashboard.query3" />:</h2> <c:out value="${query3[0]}"/> - <c:out value="${query3[1]}"/> - <c:out value="${query3[2]}"/> - <c:out value="${query3[3]}"/><br>
<h2><spring:message	code="dashboard.query4" />:</h2> <c:out value="${query4[0]}"/> - <c:out value="${query4[1]}"/> - <c:out value="${query4[2]}"/> - <c:out value="${query4[3]}"/><br>
<h2><spring:message	code="dashboard.query5" />:</h2> <c:out value="${query5}"/><br>
<h2><spring:message	code="dashboard.query6" />:</h2> <c:out value="${query6}"/><br>
<h2><spring:message	code="dashboard.query7" />:</h2> <c:out value="${query7}"/><br>
<h2><spring:message	code="dashboard.query8" />:</h2> <c:out value="${query8}"/><br>
<h2><spring:message	code="dashboard.query9" />:</h2> <c:out value="${query9}"/><br>
<h2><spring:message	code="dashboard.query10" />:</h2> <c:out value="${query10}"/><br>
<h2><spring:message	code="dashboard.query11" />:</h2> <c:out value="${query11}"/><br>
<h2><spring:message	code="dashboard.query12" />:</h2> <c:out value="${query12}"/><br>
<h2><spring:message	code="dashboard.query13" />:</h2> <c:out value="${query13}"/><br>
<h2><spring:message	code="dashboard.query14" />:</h2> <c:out value="${query14}"/><br>
<h2><spring:message	code="dashboard.query15" />:</h2> <c:out value="${query15}"/><br>
<br>
