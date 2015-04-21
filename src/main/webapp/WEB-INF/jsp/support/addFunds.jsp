<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>
	
	<div class="page-content">
		<div class="container">
		
			<div class="alert alert-warning" role="alert" id="message">
				<a href="#" class="close" data-dismiss="alert">&times;</a>					
			</div>
			<!-- <div class="portlet light"> -->
				<div class="tab-pane" id="tab_1">
					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i>Add Funds
							</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
		
							<form class="horizontal-form">
								<div class="form-body">
									
									<h3 class="form-section">Account Info</h3>
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
												<input type="text" name="address1" id="address1"
													class="form-control" disabled="disabled" />
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label">Address 2</label>
												<input type="text" name="address2" id="address2"
													class="form-control" disabled="disabled" />
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
									
									
									<h3 class="form-section">Available Amount Info</h3>
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label">Available Amount (number)</label>
												<input type="text" name="amount" id="amount"
													class="form-control" />
											</div>
										</div>
										<!--/span-->
										<div class="col-md-6">
											<div class="form-group">
												<label class="control-label">Available Amount (alphabet)</label>
												<textarea rows="4" cols="50" name="amountAlPha" id="amountAlPha"
													class="form-control" >
												</textarea>
											</div>
										</div>
										<!--/span-->
									</div>
								</div>
								<div class="form-actions right">
									<button type="button" class="btn default" onclick="goHome();">Cancel</button>
									<button id="submit" type="button" class="btn blue" onclick="addFund();">
										<i class="fa fa-check"></i> Add
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