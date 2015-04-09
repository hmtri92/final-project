<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>


</head>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbarNonLogin.jsp"%>

	<div class="container">

		<div id="login-overlay" class="panel panel-success"
			style="width: 40%; margin: 0 auto;">
			<div id="message" name="message"></div>
			<div class="panel-heading">
				<h4 class="modal-title">Login</h4>
			</div>
			<div class="panel-body">
				<form id="loginform" action="checkLogin"
					html="{:multipart=>true}" class="form-horizontal" method="post" role="form">
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input id="login-username" type="text" class="form-control"
							name="username" placeholder="username">
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input id="login-password" type="password" class="form-control"
							name="password" placeholder="password">
					</div>
					<div class="input-group">
						<div class="checkbox">
							<label> ${message}
							</label>
						</div>
					</div>
					<input id="btn-login" type="button" class="btn btn-success pull-right" value="Register"
						style="margin-left: 10px;" onclick="goRegister();" />
					<input id="btn-login" type="submit" class="btn btn-success pull-right" value="Login" 
						style="padding-left: 20px; padding-right: 20px;"/>
				</form>
			</div>
		</div>

		<!-- start footer -->
		<%@ include file="models/footer.jsp"%>
	</div>

	<script type="text/javascript">
		function goRegister() {
			location.href = "register";
		}
	</script>
	

</body>
</html>