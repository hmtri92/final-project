<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="css/jquery.dataTables.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#mytable").dataTable();
	});
</script>

</head>
<body>
<body style="padding-top: 100px !important">
	<%@ include file=../models/navbarCustomer.jsp"%>

	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert fade in alert-success" id="message"><i class="fa fa-cogs"></i>${RESULT}</div>
			<div class="portlet light">
				<div class="row">
					<div class="col">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="caption">
									<i class="fa fa-cogs"></i>Exchange History - Account Number: '${accountNumber}'</div>
							</div>
							<div class="panel-body">
								<table id="mytable">
								<thead>
									<tr>
										<th><center>Id</center></th>
										<th><center>Source Account</center></th>
										<th><center>Target Account</center></th>										
										<th><center>Money Amount</center></th>	
										<th><center>Transfered Date</center></th>								
									</tr>
								</thead>
								<tbody>
									<c:forEach var="transaction" items="${listTransaction}">
										<tr>
											<td><center>${transaction.idTransaction}</center></td>
											<td><center>${transaction.sendAccount.id}</center></td>
											<td><center>${transaction.receiveAccount.id}</center></td>										
											<td><center>${transaction.amount}</center></td>
											<td><center>${transaction.date}</center></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<!-- start footer -->
	<%@ include file=../models/footer.jsp"%>
</body>
</html>