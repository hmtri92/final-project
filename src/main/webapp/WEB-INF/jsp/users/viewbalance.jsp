<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSC Banking System</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/logo-nav.css'/>">
<link rel="stylesheet" href="<c:url value='/css/components.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">
<link rel="stylesheet" href="<c:url value='/css/screen.css'/>">
<link rel="stylesheet" href="<c:url value='/css/jquery.dataTables.css'/>">
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>">


<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-ui.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.dataTables.js'/>"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#mytable").dataTable();
	$( "#datepickerFrom" ).datepicker();
	$( "#datepickerTo" ).datepicker();
	var dt = new Date();		
	var time = (dt.getMonth() + 1) + "/" + dt.getDate() + "/" + dt.getFullYear();		
	$( "#datepickerFrom" ).val(time);
	$( "#datepickerTo" ).val( time);		
});

function changeDateRange(myDatePicker){
	var dateFrom = new Date($("#datepickerFrom").val());
	var dateTo = new Date($("#datepickerTo").val());
	
	if (dateFrom > dateTo) {
		if(myDatePicker.id == "datepickerFrom"){
			$("#datepickerTo").val($("#datepickerFrom").val());				
		}else{
			$("#datepickerFrom").val($("#datepickerTo").val());
		}			
	}
}

function showResult(){
	$.ajax ({
		type : "POST",
		url : "getBalanceLog",
		data : {
			"chosenaccount": ${accountNumber},
			"dateFrom": $("#datepickerFrom").val(),
			"dateTo" : $("#datepickerTo").val()},					
			success : function (result) {
				$("#tablesection").html(result);
				$("#mytable").dataTable();
			},
			error : function() {
				alert("Error while processing request..");
			}
	});	
}
</script>

</head>
<body>
<body style="padding-top: 100px !important">
	<div class="page-content">
		<%
			String role = (String)request.getSession().getAttribute("role");
		%>
		<c:choose>
			<c:when test="${role == 'admin'}">
				<%@ include file="../models/navbarAdmin.jsp"%>
			</c:when>
			<c:when test="${role == 'account_support'}">
				<%@ include file="../models/navbar.jsp"%>
			</c:when>
			<c:when test="${role == 'customer'}">
				<%@ include file="../models/navbarCustomer.jsp"%>
			</c:when>
		</c:choose>

	
		<div class="container">			
			<div class="portlet light">
				<div class="row">
					<div class="col">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="caption">
									<i class="fa fa-cogs"></i>Account Balance History - Account Number '${accountNumber}'</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label class="control-label"><strong>Date Range</strong></label>											
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-1">
										<div class="form-group">
																		
										</div>
									</div>
									<div class="col-md-1">
										<div class="form-group">
											<label class="control-label">From</label>											
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<input type="text" id="datepickerFrom" readonly="readonly" onchange="changeDateRange(this)">											
										</div>
									</div>
									<div class="col-md-1">
										<div class="form-group">
											<label class="control-label">To</label>											
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<input type="text" id="datepickerTo" readonly="readonly" onchange="changeDateRange(this)">												
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
																		
										</div>
									</div>
									<div class="col-md-2">
										<button id="submit" type="button" class="btn blue" onclick="showResult()">
												<i class="fa fa-check"></i>Show Result
											</button>	
									</div>
								</div>
								<br/>
								<div class="row" id="tablesection">
									<div class="col-md-12">
										<div class="Metronic-alerts alert fade in alert-success" id="message"><i class="fa fa-cogs"></i>${RESULT}</div>
									</div>							
							
									<div class="col-md-12">
										<table id="mytable">
										<thead>
											<tr>
												<th><center>ID</center></th>
												<th><center>Period</center></th>
												<th><center>Balance</center></th>	
											</tr>
										</thead>
										<tbody>
											<c:forEach var="balanceInfo" items="${listBalance}">
												<tr>
													<td><center>${balanceInfo.idBalanceAmount}</center></td>
													<td><center>${balanceInfo.period}</center></td>
													<td><center>${balanceInfo.balance}</center></td>										
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
		</div>
	</div>
	

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>