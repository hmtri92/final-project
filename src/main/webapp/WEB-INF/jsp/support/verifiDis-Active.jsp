<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet"
	href="<c:url value='/css/dataTables.bootstrap.css'/>">

<script type="text/javascript"
	src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/dataTables.bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
	    var TransactionTable = $('#mytable').dataTable({
	    });

		$('.click_verify').click(function (){
			var id = $(this).parent().parent().parent().attr('id');
			$.ajax({
		        type : "POST",
		       	url : "doVerifyStateDis-Active",
		       	data : {"id" : id},
		       	success : function (result){
			       	if (result.state == true) {
				       	$('#'+ id + ' button').removeClass("btn-primary");
				       	$('#'+ id + ' button').addClass("btn-success");
				       	$('#'+ id + ' button').attr('disabled','disabled');
			       	} else {
			       		$('#'+ id + ' button').removeClass("btn-primary");
				       	$('#'+ id + ' button').addClass("btn-danger");
				       	
				       	$("#bodyMessage").html(("Verify State:Disable -> Active Success!");
						$("#message").modal('show');
			       	}
		       	},
		        error : function() {
		        	$('#'+ id + ' button').removeClass("btn-primary");
			       	$('#'+ id + ' button').addClass("btn-danger");
			       	
			       	$("#bodyMessage").html("Error while request..");
					$("#message").modal('show');
		        }
	        });
		});
	    
	} );

</script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">
			<div class="portlet light">
				<div>
					<table id="mytable" class="table table-striped table-bordered"
						cellspacing="0" width="100%" data-click-to-select="true"
						data-single-select="true" data-pagination="true"
						data-search="true">
						<thead>
							<tr>
								<th>ID</th>
								<th>State</th>
								<th>Verify</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listState" items="${listState}">
								<tr id="${listState.id}">
									<td>${listState.id}</td>
									<td>${listState.state.name}</td>
									<td>
										<p data-placement="top" data-toggle="tooltip" title="Verify">
											<button class="btn btn-primary btn-xs click_verify" action="">
												Verify</button>
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

	<!-- Message -->
	<%@ include file="../models/message.jsp"%>

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>
