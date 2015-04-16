<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSC Banking System</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/screen.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/infoScript.js"></script>
</head>
<body>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert fade in alert-success" id="message" style="display:none">
				
			</div>
			<div class="portlet light">
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="caption">
									<i class="fa fa-cogs"></i>User Information
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Login Id</label>
											<input type="text" name="loginId"
												id="loginId" class="form-control" disabled="disabled"
												value="${user.loginID}"/>
										</div>
									</div>
									
								</div>
								
								<div class="row">
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
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Password</label>
											<input type="password" name="password"
												id="password" class="form-control" disabled="disabled"
												value="${user.password}"/>
										</div>
									</div>
									<div class="col-md-6" >
										<div class="form-group" id="buttonChange" >
											<br>
											<button style="margin-top: 10px" onclick="changePassword()" 
												class="btn btn-primary" type="button" >
												<span class="glyphicon glyphicon-refresh"></span>
											</button>
										</div>
									</div>			
									
									
								</div>
								<div class="row" id="changePassSection"  style="display:none">
									<div class="col-md-6" >
										<div class="form-group" >
											<label class="control-label">New Password</label>
											<input type="password" name="newPassword"
												id="newPassword" class="form-control" 
												onchange="checkChange()"/>
										</div>
									</div>
									
									<div class="col-md-6">
										<div class="form-group" >
											<label class="control-label">Retype Password</label>
											<input type="password" name="retypePassword"
												id="retypePassword" class="form-control"/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6" id="buttonSubmit" style="display:none">
										<div class="form-group"  >	
											<button id="submit" type="button" class="btn blue" onclick="submitChangePassword(${user.password})">
												<i class="fa fa-check"></i> Submit
											</button>										
											<button type="button" class="btn red" onclick="cancelChangePassword(${user.password})">Cancel</button>
											
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">System Role</label>
											<input type="text" name="role" id="role"
												class="form-control" disabled="disabled"
												value="${user.role.nameRole}" >											
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Current State</label>
											<input type="text" name="state" id="state"
												class="form-control" disabled="disabled" 
												value="${user.state.name}">											
										</div>
									</div>
								</div>	
							</div>
						</div>
					</div>
					
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="caption">
									<i class="fa fa-cogs"></i>Personal Information
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label">ID Card Number</label>
												<input type="text" name="idCard"
													id="idCard" class="form-control" disabled="disabled"
													value="${user.idCardNumber}"/>
											</div>
										</div>										
								</div>
		
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Firstname *</label>
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
											<label class="control-label">Lastname *</label>
											<input type="text" name="lastName" id="lastName"
												class="form-control editable" disabled="disabled" 
												value="${user.lastName}"/>
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 1 *</label>
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
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 1 *</label>
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
								<div style="float: right">
									<button id="buttonCancelEdit" style="visibility:hidden"
										type="button" class="btn red" 
										onclick="cancelChangeInfo()">Cancel</button>
									<button id="buttonSubmitEdit" type="button" 
										class="btn blue" onclick="changeInfo()">Edit</button>
								</div>
							</div>
							
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>
</body>
</html>