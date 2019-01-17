<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2><spring:message	code="administrator.query1" />:</h2> <jslt:out value="${query1[0]}"/> - <jslt:out value="${query1[1]}"/> - <jslt:out value="${query1[2]}"/> - <jslt:out value="${query1[3]}"/><br>
<h2><spring:message	code="administrator.query2" />:</h2> <jslt:out value="${query2[0]}"/> - <jslt:out value="${query2[1]}"/> - <jslt:out value="${query2[2]}"/> - <jslt:out value="${query2[3]}"/><br>
<h2><spring:message	code="administrator.query3" />:</h2> <jslt:out value="String.toString(${query3[0]})"/> - <jslt:out value="${query3[1]}"/> - <jslt:out value="${query3[2]}"/> - <jslt:out value="${query3[3]}"/><br>
<h2><spring:message	code="administrator.query4" />:</h2> <jslt:out value="${query4[0]}"/> - <jslt:out value="${query4[1]}"/> - <jslt:out value="${query4[2]}"/> - <jslt:out value="${query4[3]}"/><br>
<h2><spring:message	code="administrator.query5" />:</h2> <jslt:out value="${query5}"/><br>
<h2><spring:message	code="administrator.query6" />:</h2> <jslt:out value="${query6}"/><br>
<h2><spring:message	code="administrator.query7" />:</h2> <jslt:out value="${query7}"/><br>
<h2><spring:message	code="administrator.query8" />:</h2> <jslt:out value="${query8}"/><br>
<h2><spring:message	code="administrator.query9" />:</h2> <jslt:out value="${query9}"/><br>
<h2><spring:message	code="administrator.query10" />:</h2> <jslt:out value="${query10}"/><br>
<br>
