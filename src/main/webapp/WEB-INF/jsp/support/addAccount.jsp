<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/screen.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/myScript.js"></script>
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" />
<link rel="stylesheet" href="css/template.css" type="text/css" />
<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js" type="text/javascript"></script>
		<script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
		<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script>
	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine
		jQuery("#createAccount").validationEngine();
	});
</script>
</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">



			<!-- <div class="portlet light"> -->
			<div class="tab-pane" id="tab_1">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>createAccount
						</div>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->

						<form id="createAccount" class="horizontal-form"
							action="docreateAccount" method="POST">
							<div class="form-body">

								<h3 class="form-section">Account Info</h3>

								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">IdAccount:</label> <input
											type="text" name="id" id="id"
											class=" validate[required,length[12,12]]"
											placeholder="12 Number" />
									</div>
									<div class="form-group">
										<label class="control-label">ID-Card : </label> <input
											type="text" name="idCardNumber" id="idCardNumber"
											class=" validate[required,length[9,9]]"
											placeholder="9 Number" />
									</div>
								</div>
								<!--/span-->
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">TypeAccount :</label> <select
											name="typeAccount" id="typeAccount"
											class="validate[required]" id="typeAccount">
											<option value="">Choose Type Account</option>
											<option value="1">DEPOSIT</option>
											<option value="2">SAVING</option>
											<option value="3">OTHER</option>

										</select>
									</div>
								</div>
								<!--/span-->
								<!--/span-->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Role :</label> <select
											name="role" id="role" class="validate[required]" id="role">
											<option value="">Choose role</option>
											<option value="1">Customer</option>
											<option value="2">Admin</option>
											<option value="3">ACCOUNT_SUPPORT</option>
											<option value="4">CUSTOMER_SUPPORT</option>
											<option value="5">ACCOUNT_SUPPORT</option>
										</select>
									</div>
								</div>




							
							<h3 class="form-section">Customer Info</h3>
					
							
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">FirstName :</label> <input
										type="text" name="firstName" id="firstName"
										class="validate[optional,funcCall[validate2fields],custom[onlyLetter],length[0,100]] text-input"
										placeholder="Only input letter" />
								</div>
								<div class="form-group">
									<label class="control-label">LastName :</label> <input
										type="text" name="lastName" id="lastName"
										class="validate[optional,funcCall[validate2fields],custom[onlyLetter],length[0,100]] text-input"
										placeholder="Only input letter" />
								</div>
								<div class="form-group">
									<label class="control-label">Mid-Name :</label> <input
										type="text" name="midName" id="midName"
										class="validate[optional,funcCall[validate2fields],custom[onlyLetter],length[0,100]] text-input"
										placeholder="Only input letter" />
								</div>
								<div class="form-group">
									<label class="control-label">Address-1 : </label> <input
										type="text" name="address1" id="address1"
										class="validate[required] text-input"
										placeholder="input Address" />
								</div>
								<div class="form-group">
									<label class="control-label">Address-2 :</label> <input
										type="text" name="address2" id="address2"
										class="validate[required] text-input"
										placeholder="input Address" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->

							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">PhoneNum1 : </label> <input
										type="text" name="phoneNum1" id="phoneNum1"
										class="validate[required,custom[telephone]] text-input"
										type="text" placeholder="only input number" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">PhoneNum2 :</label> <input
										type="text" name="phoneNum2" id="phoneNum2"
										class="validate[required,custom[telephone]] text-input"
										type="text" placeholder="only input number" />
								</div>
							</div>


							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label"> Email1 : </label> <input
										type="text" name="email1" id="email1"
										class="validate[groupRequired[payments],custom[email]] text-input"
										placeholder="abc@gmail.com" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label"> Email2 : </label> <input
										type="text" name="email2" id="email2"
										class="validate[groupRequired[payments],custom[email]] text-input"
										placeholder="abc@gmail.com" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6"></div>
							<!--/span-->
							<div class="form-actions right">

								<center>
									<button id="submit" type="submit" class="submit"
										value="Add Account">
										<i class="fa fa-check"></i> Add Account
									</button>
								</center>

							</div>
						</form>
						<div class="form-actions right">

							<center>
								<font color="red">${message }</font>
							</center>

						</div>
					</div>
				</div>
			</div>
			<!-- </div> -->
		</div>
	</div>
	

	<%@ include file="../models/footer.jsp"%>
</body>
</html>