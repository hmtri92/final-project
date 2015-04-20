<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<%@ include file="../models/navbarCustomer.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="portlet light">
				<div class="Metronic-alerts alert alert-danger fade in" id="message">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
			</div>
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Account Number</label>
							<select id="targetAccount" name="targetAccount" class="form-control input-medium">
								<option value="-1">--Choose Target Account--</option>
								<c:forEach var="item" items="${targetAccounts}">
									<option value="${item.idTarget}">${item.name}</option>
								</c:forEach>
							</select>
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
							<button id="submit" type="button" class="btn blue" onclick="transferTargetID();">
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