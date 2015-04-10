<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<title>Register</title>
</head>
<body style="padding-top: 100px !important">
	<%@ include file="models/navbarNonLogin.jsp"%>


	<h1 align="center">Register</h1>
	<form action="createAccount" method="post" style="margin-top: 10px;">
		<table width="1063" border="0" cellpadding="0" cellspacing="0" id="id-form">
			<tr>
				<th width="112" valign="top">Account Number</th>
				<td width="144"><input type="text" class="inp-form" name="accountNumber" /></td>
			</tr>
			<tr>
				<th valign="top">TypeAccount:</th>
				<td><input type="text" class="inp-form" name="typeAccount" /></td>
				<td width="98"></td>
			</tr>
		
			<tr>
				<th valign="top">idCardNumberr</th>
				<td><input type="text" class="inp-form" name="idCardNumber" /></td>
			</tr>
			<tr>
				<th valign="top">firstName</th>
				<td><input type="text" class="inp-form" name="firstName" /></td>
			</tr>
			<tr>
				<th valign="top">lastName</th>
				<td><input type="text" class="inp-form" name="lastName" /></td>
			</tr>
			<tr>
				<th valign="top">midName</th>
				<td><input type="text" class="inp-form" name="midName" /></td>
			</tr>
			<tr>
				<th height="27" valign="top">phoneNum1</th>
			  <td><input type="text" class="inp-form" name="phoneNum1" /></td>
			</tr>
			<tr>
				<th valign="top">phoneNum2</th>
				<td><input type="text" class="inp-form" name="phoneNum2" /></td>
			</tr>
			<tr>
				<th valign="top">address1</th>
				<td><input type="text" class="inp-form" name="address1" /></td>
			</tr>
			<tr>
				<th valign="top">address2</th>
				<td><input type="text" class="inp-form" name="address2" /></td>
			</tr>
			<tr>
				<th valign="top">email1</th>
				<td><input type="text" class="inp-form" name="email1" /></td>
			</tr>
			<tr>
				<th valign="top">email2</th>
				<td><input type="text" class="inp-form" name="email2" /></td>
			</tr>
			<tr>
				<th valign="top">availableAmount</th>
				<td><input type="text" class="inp-form" name="availableAmount" /></td>
			</tr>
			<tr>
				<th valign="top">state</th>
				<td><input type="text" class="inp-form" name="state" /></td>
			</tr>
			<tr>
				<th valign="top">role</th>
				<td><input type="text" class="inp-form" name="role" /></td>
			</tr>
			<tr>
				<th colspan="3"><center>
						<font color="red">${addError }</font>
					</center></th>
			</tr>
				<tr>
				<td></td>
				<td><input type="submit" class="btnAdd" value="Add Account"
					id="addAccount" /></td>
				<td></td>
			</tr>
		</table>
	</form>


	
</body>
</html>