<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="css/dataTables.bootstrap.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/myScript.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
	    var TransactionTable = $('#mytable').dataTable({
	    });

		$('.click_verify').click(function (){
			var id = $(this).parent().parent().parent().attr('id');
			$.ajax({
		        type : "POST",
		       	url : "admin/verifyTransaction",
		       	data : {"idTransaction" : id},
		       	success : function (result){
			       	if (!result.localeCompare("success")) {
				       	$('#'+ id + ' button').removeClass("btn-primary");
				       	$('#'+ id + ' button').addClass("btn-success");
				       	$(this).attr('disabled','disabled');
			       	} else {
			       		$('#'+ id + ' button').removeClass("btn-primary");
				       	$('#'+ id + ' button').addClass("btn-danger");				       	
			       	}
		       	},
		        error : function() {
		        	alert("Error while request..");
		        }
	        });
			$(this).attr('disabled','disabled');
		});
	    
	} );

</script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbarAdmin.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert alert-danger fade in" id="message">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
			</div>
			<div class="portlet light">
				<div >
					<table id="mytable" class="table table-striped table-bordered" cellspacing="0" width="100%"
						data-click-to-select="true" data-single-select="true" data-pagination="true" data-search="true">
						<thead>
				            <tr>
				                <th >ID</th>
				                <th >Date</th>
				                <th >Type</th>
				                <th >Send Account</th>
				                <th >Receive Account</th>
				                <th >Amount</th>
				                <th >Content</th>
				                <th >Verify</th>
				            </tr>
				        </thead>
				        <tbody>
							<c:forEach var="transaction" items="${transactions}">
								<tr id = "${transaction.idTransaction}">
									<td>${transaction.idTransaction}</td>
									<td>${transaction.date}</td>
									<td>
									    <c:choose>
									        <c:when test="${transaction.typeTransaction == 1}">Add</c:when>
									        <c:when test="${transaction.typeTransaction == 2}">Transfer</c:when>
									        <c:when test="${transaction.typeTransaction == 3}">Withdraw</c:when>
									        <c:otherwise>undefined</c:otherwise>
									    </c:choose>
									</td>
									<td>${transaction.sendAccount.id}</td>
									<td>${transaction.receiveAccount.id}</td>
									<td>${transaction.amount}</td>												
									<td>${transaction.content}</td>												
									<td>
										<p data-placement="top" data-toggle="tooltip" title="Verify">
											<button class="btn btn-primary btn-xs click_verify" action="">
												Verify
											</button>
										</p>
									</td>												
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>
