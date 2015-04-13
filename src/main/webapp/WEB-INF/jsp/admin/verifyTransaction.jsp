<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/myScript.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert alert-danger fade in" id="message">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
			</div>
			<div class="portlet light">
				
			</div>
		</div>
	</div>
	
	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>
