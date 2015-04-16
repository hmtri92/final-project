<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
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
<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
		<link rel="stylesheet" href="css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js" type="text/javascript"></script>
		<script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
		<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
		<script>
	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine
		jQuery("#update").validationEngine();
	});
</script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert alert-danger fade in" id="message">
				
			</div>
			<!-- <div class="portlet light"> -->
			<div class="tab-pane" id="tab_1">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>Modified-State
						</div>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->

						<form id="checkAccount" class="horizontal-form" action="checkAccount"
							method="POST">
							<div class="form-body">

								<h3 class="form-section">Check Account</h3>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Account Number: </label> <input
												type="text" name="accountNumber1" id="accountNumber1"
												class="form-control" />
										</div>
									</div>

								</div>
									<div class="form-actions right">
								<center><button id="Checkaccount" type="submit" class="btn blue" onclick="">
									<i class="fa fa-check"></i> Check Account
								</button></center>
							</div>

							
							</div>
					
						</form>
							<center>
								<font color="red">${message }</font>
							</center>
						<form id="update" class="horizontal-form" action="doupdateState"
							method="POST">
							<div class="form-body">

								<h3 class="form-section">Update State</h3>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Account Number</label> <input
												type="text" name="accountNumber" id="accountNumber"
												class=" validate[required,length[12,12]]" placeholder="12 Number"  />
										</div>
									</div>

								</div>
									<div class="form-actions right"></div>

								<div class="row">
									<div class="col-md-4">
										
										<label>
					<span>State :</span>
				<select name="state" id="state" multiple class="validate[required]"  id="state"  >
					<option value="">Choose a State</option>
					<option value="1">NEW</option>
					<option value="2">ACTIVE</option>
					<option value="3">DISABLE</option>
					<option value="4">REMOVEABLE</option>
					<option value="5">REMOVED</option>
				</select>
				</label>
									</div>
<center>
								<font color="red">${message1 }</font>
							</center>

								</div>
							</div>
							<div class="form-actions right">
								<button id="submit" type="submit" class="submit"
									>
									<i class="fa fa-check"></i> Submit
								</button>
							</div>
						</form>
						<!-- END FORM-->
					</div>
				</div>
			</div>
			<!-- </div> -->
		</div>
	</div>

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>
