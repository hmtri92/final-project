<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


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
<body style="padding-top: 90px !important">
	<%@ include file="../models/navbar.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="alert alert-warning alert-dismissible" role="alert" id="message">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="portlet light">
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="caption">
									<i class="fa fa-cogs"></i>Send Account
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Account Number</label>
											<input type="text" name="accountNumber"
												id="accountNumber" class="form-control" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<br>
											<button style="margin-top: 10px" onclick="checkAccount();" 
												class="btn btn-primary" type="button">
												<span class="glyphicon glyphicon-refresh"></span>
											</button>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Amount</label>
											<input type="text" name="amount"
												id="amount" class="form-control" />
										</div>
									</div>
								</div>
		
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Firstname</label>
											<input type="text" name="firstname" id="firstname"
												class="form-control" disabled="disabled"/>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Midname</label>
											<input type="text" name="midname" id="midname"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Lastname</label>
											<input type="text" name="lastname" id="lastname"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 1</label>
											<textarea rows="2" name="address1" id="address1"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 2</label>
											<textarea rows="2" name="address2" id="address2"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 1</label>
											<input type="text" name="phoneNum1" id="phoneNum1"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 2</label>
											<input type="text" name="phoneNum2" id="phoneNum2"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="caption">
									<i class="fa fa-cogs"></i>Target Account
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Account Number</label>
											<input type="text" name="targetaccountNumber"
												id="targetaccountNumber" class="form-control" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<br>
											<button style="margin-top: 10px" onclick="checkTargetAccount();" 
												class="btn btn-primary" type="button">
												<span class="glyphicon glyphicon-refresh"></span>
											</button>
										</div>
									</div>
								</div>
		
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Firstname</label>
											<input type="text" name="targetfirstname" id="targetfirstname"
												class="form-control" disabled="disabled"/>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Midname</label>
											<input type="text" name="targetmidname" id="targetmidname"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Lastname</label>
											<input type="text" name="targetlastname" id="targetlastname"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 1</label>
											<textarea rows="2" name="targetaddress1" id="targetaddress1"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 2</label>
											<textarea rows="2" name="targetaddress2" id="targetaddress2"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 1</label>
											<input type="text" name="targetphoneNum1" id="targetphoneNum1"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 2</label>
											<input type="text" name="targetphoneNum2" id="targetphoneNum2"
												class="form-control" disabled="disabled" />
										</div>
									</div>
									<!--/span-->
								</div>
							</div>
						</div>
						<div style="float: right">
							<button type="button" class="btn default" onclick="goHome();">Cancel</button>
							<button id="submit" type="button" class="btn blue" onclick="tranferBySupport();">
								<i class="fa fa-check"></i> Send
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>
