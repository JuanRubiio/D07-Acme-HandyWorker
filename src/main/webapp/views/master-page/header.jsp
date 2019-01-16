<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
 * header.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%-- <%
	String connectionURL = "jdbc:mysql://localhost:3306/acme-handyworker";
	Connection connection = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection = DriverManager.getConnection(connectionURL, "acme-manager", "ACME-M@n@ger-6874");
	Statement st = connection.createStatement();
	ResultSet rs = null;
	String QueryString = "SELECT * FROM configuration;";
	rs = st.executeQuery(QueryString);
	while (rs.next()) {
		String banner = (String) rs.getObject(3);
		application.setAttribute("banner", banner);
	}
%> --%>
 <div>
	<a href="#"><img src="${banner}"  width="500" height="200"/></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		
		
		<security:authorize access="isAnonymous()">
	
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
			<li><a href="customer/register.do"><spring:message code="master.page.customer.register" /></a></li>
			<li><a href="handyworker/register.do"><spring:message code="master.page.handyworker.register" /></a></li>
			<li><a href="sponsor/register.do"><spring:message code="master.page.sponsor.register" /></a></li>
			<li><a href="tutorial/list.do"><spring:message code="master.page.tutorial.list" /></a></li>
			

		</security:authorize>

		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/dashboard.do"><spring:message code="master.page.administrator.dashboard" /></a></li>
					<li><a href="message/administrator/broadcast.do"><spring:message code="master.page.administrator.broadcast" /></a></li>
				</ul>
			</li>
			<li><a class="fNiv"><spring:message	code="master.page.administrator.usermanager" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/administrator/register.do"><spring:message code="master.page.administrator.administrator.register" /></a></li>
					<li><a href="referee/administrator/register.do"><spring:message code="master.page.referee.administrator.register" /></a></li>
				</ul>
			</li>
			<li><a class="fNiv" href="warranty/administrator/list.do"><spring:message code="master.page.administrator.warranty" /></a></li>
			<li><a href="category/administrator/list.do"><spring:message code="master.page.administrator.category" /></a></li>
			<li><a href="actor/administrator/suspicious.do"><spring:message code="master.page.administrator.suspicious" /></a></li>
			<li><a href="administrator/score.do"><spring:message code="master.page.administrator.score" /></a></li>
			<li><a href="administrator/words.do"><spring:message code="master.page.administrator.words" /></a></li>
	
		</security:authorize>

		<security:authorize access="hasRole('HANDYWORKER')">
			<li><a class="fNiv" href="fixuptask/handyworker/list.do"><spring:message code="master.page.handyworker.fixuptasks" /></a></li>
			<li><a class="fNiv" href="finder/handyworker/finder.do"><spring:message code="master.page.handyworker.finder" /></a></li>
			<li><a href="application/handyworker/list.do"><spring:message code="master.page.handyworker.application" /></a></li>
			<li><a href="tutorial/handyworker/list.do"><spring:message code="master.page.handyworker.tutorial.list" /></a></li>
			<li><a href="endorsement/handyworker/list.do"><spring:message code="master.page.handyworker.endorsement" /></a></li>



		</security:authorize>

		<security:authorize access="hasRole('REFEREE')">
			<li><a class="fNiv" href="complaint/referee/listAll.do"><spring:message code="master.page.referee.complaint.all" /></a></li>
			<li><a href="complaint/referee/listOwn.do"><spring:message code="master.page.referee.complaint.own" /></a></li>

		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
			<li><a class="fNiv" href="fixuptask/customer/list.do"><spring:message code="master.page.customer.fixuptask" /></a></li>
			<li><a href="application/customer/list.do"><spring:message code="master.page.customer.application" /></a></li>
			<li><a href="complaint/customer/list.do"><spring:message code="master.page.customer.complaint" /></a></li>
			<li><a href="report/customer/list.do"><spring:message code="master.page.customer.report" /></a></li>
			<li><a href="endorsement/customer/list.do"><spring:message code="master.page.customer.endorsement" /></a></li>
			
		</security:authorize>
		


		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv">
					<spring:message code="master.page.profile" />
					(<security:authentication property="principal.username" />)
				</a>



				<ul>
					<li class="fNiv" class="arrow"></li>
					<li><a href="actor/edit.do"><spring:message code="master.page.profile" /></a></li>
					<li><a href="message/create.do"><spring:message code="master.page.newmessage" /></a></li>
					<li><a href="messagebox/list.do"><spring:message code="master.page.messageboxes" /></a></li>
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>


		</security:authorize>

  		

	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

