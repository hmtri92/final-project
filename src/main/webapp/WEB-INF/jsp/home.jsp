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

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/logo-nav.css'/>">
<link rel="stylesheet" href="<c:url value='/css/components.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">
<link rel="stylesheet" href="<c:url value='/css/screen.css'/>">

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

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

	<div class="page-content">
		<div class="container">
			<div class="portlet light">
				<div class="row">
					<div class="col-md-12">
						<h3 class="form-section" style="color: rgb(210, 105, 30);">Account Info</h3>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Login Id</label>
							<input type="text" name="loginId"
								id="loginId" class="form-control" disabled="disabled"
								value="${user.loginID}"/>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Account Number</label>
							<input type="text" name="accountNumber"
								id="accountNumber" class="form-control" disabled="disabled"
								value="${user.id}"/>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
							<label class="control-label">ID Card Number</label>
							<input type="text" name="idCard"
								id="idCard" class="form-control" disabled="disabled"
								value="${user.idCardNumber}"/>
						</div>
					</div>										
				</div>
				
				<div class="row">
					<div class="col-md-12 ">
						<h3 class="form-section" style="color: rgb(210, 105, 30);">Personal Information</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">Firstname </label>
							<input type="text" name="firstName" id="firstName"
								class="form-control editable" disabled="disabled"
								value="${user.firstName}"/>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">Midname</label>
							<input type="text" name="midName" id="midName"
								class="form-control editable" disabled="disabled" 
								value="${user.midName}"/>
						</div>
					</div>
					<!--/span-->
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label">Lastname </label>
							<input type="text" name="lastName" id="lastName"
								class="form-control editable" disabled="disabled" 
								value="${user.lastName}"/>
						</div>
					</div>
					<!--/span-->
				</div>
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
							<label class="control-label">Address 1 </label>
							<textarea rows="2" name="address1" id="address1"
								class="form-control" disabled="disabled" >${user.address1}</textarea>
						</div>
					</div>
					<!--/span-->
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Address 2</label>
							<textarea rows="2" name="address2" id="address2"
								class="form-control editable" disabled="disabled" >${user.address2}</textarea>
						</div>
					</div>
					<!--/span-->
				</div>
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
							<label class="control-label">Phone Number 1 </label>
							<input type="text" name="phoneNum1" id="phoneNum1"
								class="form-control" disabled="disabled" 
								value="${user.phoneNum1}"/>
						</div>
					</div>
					<!--/span-->
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Phone Number 2</label>
							<input type="text" name="phoneNum2" id="phoneNum2"
								class="form-control editable" disabled="disabled" 
								value="${user.phoneNum2}"/>
						</div>
					</div>
					<!--/span-->
				</div>
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
							<label class="control-label">Email 1 </label>
							<input type="text" name="email1" id="email1"
								class="form-control" disabled="disabled" 
								value="${user.email1}"/>
						</div>
					</div>
					<!--/span-->
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Email 2</label>
							<input type="text" name="email2" id="email2"
								class="form-control editable" disabled="disabled" 
								value="${user.email2}"/>
						</div>
					</div>
					<!--/span-->
				</div>
			</div>
		</div>
	</div>
				
	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>
</body>
</html>