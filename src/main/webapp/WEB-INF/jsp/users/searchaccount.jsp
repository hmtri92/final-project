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
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.dataTables.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-ui.js'/>"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#mytable").dataTable();		
		var listkey = ${listKey}; 
		alert(listkey);	
		$( "#keyInput" ).autocomplete({
		      source: ${listKey}
		    });
	});
	
	
	
	function changeType(mySelect){
		$(".hiddable").css("display","none");
		if (mySelect.value == 5) {
			$("#stateInput").css("display","block");
		} else if(mySelect.value == 4) {
			$("#typeInput").css("display","block");
		} else
			$("#textInput").css("display","block");
		
	}
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
									<i class="fa fa-cogs"></i>Exchange History
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Search Type</label>
											<select id="searchType" name="searchType" onchange="changeType(this)"
														class="form-control">
													<option value="1">Account Number</option>
													<option value="2">ID Card Number</option>
													<option value="3">Owner Name</option>
													<option value="4">Account Type</option>
													<option value="5">Account State</option>
													<option value="6">Phone Number</option>
													<option value="7">Address</option>
													<option value="8">Email</option>															
											</select>											
										</div>
									</div>									
								</div>
								<div class="row">
									<div class="col-md-4 hiddable" id="textInput">
										<div class="form-group">
											<label class="control-label">Key Words</label>
											<input type="text" name="keyInput"
												id="keyInput" class="form-control"/>
										</div>
									</div>									
								</div>
								<div class="row">
									<div class="col-md-4 hiddable"  id="stateInput" style="display:none");>
										<div class="form-group">
											<label class="control-label">Account State</label>
											<select id="stateAccount" name="stateAccount"
														class="form-control">
													<option value="1">NEW</option>
													<option value="2">ACTIVE</option>
													<option value="3">DISABLE</option>
													<option value="4">REMOVABLE</option>
													<option value="5">REMOVED</option>																											
											</select>
										</div>
									</div>									
								</div>
								<div class="row">
									<div class="col-md-4 hiddable"  id="typeInput"  style="display:none">
										<div class="form-group">
											<label class="control-label">Account Type</label>
											<select id="typeAccount" name="typeAccount"
														class="form-control">
													<option value="1">DEPOSIT</option>
													<option value="2">SAVING</option>
													<option value="3">OTHER</option>														
											</select>
										</div>
									</div>									
								</div>
								<div class="row">
									<div class="col-md-4" >
										<div class="form-group" style="float:right" >
											<button id="buttonSubmitEdit" type="button" 
										class="btn blue" onclick="">Search</button>
										</div>
									</div>									
								</div>
								
							
								<div class="row">
									<div class="col-md-12">
									<table id="mytable">
										<thead>
											<tr>
												<th><center>Account Number</center></th>
												<th><center>Owner Name</center></th>										
												<th><center>Money Amount</center></th>							
												<th><center>State</center></th>								
												<th><center>Actions</center></th>								
											</tr>
										</thead>
										<tbody>
											<c:forEach var="account" items="${listAccount}">
												<tr>
													<td><center>${account.id}</center></td>
													<td><center>${account.firstName} ${account.midName} ${account.lastName}</center></td>
													<td><center>${account.availableAmount}</center></td>	
													<td><center>${account.state.name}</center></td>
													<td></td>
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
	<%@ include file=../models/footer.jsp"%>
</body>
</html>