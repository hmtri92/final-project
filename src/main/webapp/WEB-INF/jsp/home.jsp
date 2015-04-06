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
	<%@ include file="models/navbar.jsp"%>

	<div class="container">
		<div id="content-outer">
			<!-- start content -->
			<div id="content">

				<!-- BEGIN SAMPLE TABLE PORTLET-->
				<div class="portlet box blue-hoki">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-cogs"></i>Account Management
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Account Name</th>
									<th>Account Type</th>
									<th>Available Amount</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="item" items="${listAccount}" varStatus="count">
								<tr>
									<td>${count.count}</td>
									<td>${item.accountName}</td>
									<td>${item.accountType}</td>
									<td>${item.availableAmount}</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
					</div>
				</div>
				<!-- END SAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>


	<div class="clear">&nbsp;</div>

	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>
</body>
</html>