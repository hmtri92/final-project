<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbarCustomer.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert alert-danger fade in" id="message">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
			</div>
			<div class="portlet light">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Account Number</label>
							<input type="text" name="targetAccount"
								id="targetAccount" class="form-control" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Amount</label>
							<input type="text" name="amount"
								id="amount" class="form-control" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3 col-md-offset-6">
						<div style="float: right">
							<button type="button" class="btn default" onclick="goHome();">Cancel</button>
							<button id="submit" type="button" class="btn blue" onclick="transferByUser();">
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