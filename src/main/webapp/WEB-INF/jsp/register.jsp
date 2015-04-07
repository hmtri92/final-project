<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<title>Register</title>
</head>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbarNonLogin.jsp"%>
	
	<div class="container">
		<div class="tab-pane" id="tab_1">
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i>Register
					</div>
				</div>
				<div class="portlet-body form">
					<!-- BEGIN FORM-->
					<%-- <div class="alert alert-warning" role="alert">${message}</div> --%>
					
					<div class="alert alert-warning alert-dismissible" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  	${message}
					</div>
					
					<form:form id="frmRegister" class="horizontal-form" modelAttribute="customer" action="doRegister" method="POST">
						<div class="form-body">
							<h3 class="form-section">Person Info</h3>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">First Name</label>
										<form:input type="text" name="firstName" path="firstName" class="form-control"/>
									</div>
								</div>
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Last Name</label>
										<form:input type="text" name="lastName" path="lastName" class="form-control"/>
									</div>
								</div>
								<!--/span-->
							</div>
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Address</label>
										<form:input type="text" name="address" path="address" class="form-control"/>
									</div>
								</div>
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">CellPhone</label>
										<form:input type="text" name="phone" path="phone" class="form-control"/>
									</div>
								</div>
								<!--/span-->
							</div>
							
							<h3 class="form-section">Login Info</h3>
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Login Id</label>
										<form:input type="text" name="loginId" path="loginId" class="form-control"/>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Password</label>
										<form:input type="password" name="password" path="password" class="form-control"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Confirm password</label>
										<form:input type="password" name="confirmPassword" path="confirmPassword" class="form-control"/>
										<span id="messagePassword" class="help-block font-red-flamingo"></span>
									</div>
								</div>
							</div>
							
						</div>
						<div class="form-actions right">
							<button type="button" class="btn default" onclick="goHome();">Cancel</button>
							<button id="registerSubmit" type="submit" class="btn blue"><i class="fa fa-check"></i> Save</button>
						</div>
					</form:form>
					<!-- END FORM-->
				</div>
			</div>
		</div>
	
		<!-- start footer -->
		<%@ include file="models/footer.jsp"%>
	</div>
	
	<script type="text/javascript">
		function goHome() {
			location.href = "login";
		}

		$( "#confirmPassword" ).keyup(function() {				
			if ($("#password").val() != this.value) {
				$("#messagePassword").text("Password is fail");
				$("#registerSubmit").attr('disabled','disabled');
			} else {
				$("#messagePassword").text("");
				$("#registerSubmit").removeAttr('disabled');
			}
		});

		
	</script>
	
</body>
</html>