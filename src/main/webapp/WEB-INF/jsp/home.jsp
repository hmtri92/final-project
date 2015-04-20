<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSC Banking System</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%
		String role = (String)request.getSession().getAttribute("role");
	%>
	<c:choose>
		<c:when test="${role == 'admin'}">
			<%@ include file="models/navbarAdmin.jsp"%>
		</c:when>
		<c:when test="${role == 'account_support'}">
			<%@ include file="models/navbar.jsp"%>
		</c:when>
		<c:when test="${role == 'customer'}">
			<%@ include file="models/navbarCustomer.jsp"%>
		</c:when>
	</c:choose>

	<div class="container">
		<div id="content-outer">
			<!-- start content -->
			<div id="content">

				Home
				
			</div>
		</div>
	</div>


	<div class="clear">&nbsp;</div>

	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>
</body>
</html>