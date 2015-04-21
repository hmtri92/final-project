

function isEmpty(id) {
	var x = document.getElementById(id).value;
	if (x == "" || x == null) {
		document.getElementById(id).setAttribute("aria-describedby","inputError2Status");
		return false;
	}
	return true;
}

function compare(value1, value2) {
	if (document.getElementById(value1).value == document.getElementById(value2).value) {
		return true;
	}
	return false;
}

function checkMyRegister() {
//	alert("1");
	var result = true;
	result = result && isEmpty("firstName");
	result = result && isEmpty("lastName");
	result = result && isEmpty("userName");
	result = result && isEmpty("email");
	result = result && isEmpty("password");
	result = result && isEmpty("confirmpassword");
	result = result && isEmpty("cellPhone");
	result = result && compare("password", "confirmpassword");
	
	
	if (result == false) {
		document.getElementById("message").style.visibility = "visible";
	}
	return result;
	
}

function submitUpdateProfile() {
	$.ajax({
		url: "UpdateProfile",
		type: "POST",
		data: $("#frmUpdate").serialize(),
		success: function(result) {
			var json = JSON.parse(result);
		}
	})
}

$("#registerSubmit").click(function(event){
	aler(2222);
	$.ajax({
		url: "Register",
		type: "POST",
		data: $("#frmRegister").serialize(),
		success:function() {
			},
		error:function(){
			}
		});
	});

function checkAccount() {
	$.ajax({
		type : "POST",
		url : "getAccountById",
		datatype:"json",
		data : {"accountNumber" : $("#accountNumber").val()},
		success : function(result) {
			console.log(result);
			$("#firstname").val(result.firstName);
			$("#midname").val(result.midName);
			$("#lastname").val(result.lastName);
			$("#address1").val(result.address1);
			$("#address2").val(result.address2);
			$("#phoneNum1").val(result.phoneNum1);
			$("#phoneNum2").val(result.phoneNum2);
		},
		error : function(result){
			console.log(result);
			alert("Error while request..");
		}
	});
}

function checkTargetAccount() {
	$.ajax({
		type : "POST",
		url : "getAccountById",
		data : {"accountNumber" : $("#targetaccountNumber").val()},
		success : function(result) {
			$("#targetfirstname").val(result.firstName);
			$("#targetmidname").val(result.midName);
			$("#targetlastname").val(result.lastName);
			$("#targetaddress1").val(result.address1);
			$("#targetaddress2").val(result.address2);
			$("#targetphoneNum1").val(result.phoneNum1);
			$("#targetphoneNum2").val(result.phoneNum2);
		},
		error : function(){
			alert("Error while request..");
		}
	});
}

function goHome() {
	location.href = "home";
}

function changeCheckBox() {
	if ($("#checkBox").prop("checked")) {
		$("#recentAccount").removeAttr('disabled');
		$("#accountNumber").attr('disabled','disabled');
		$("#banklist").attr('disabled','disabled');
		$("#branchlist").attr('disabled','disabled');
		
	} else {
		$("#accountNumber").removeAttr('disabled');
		$("#banklist").removeAttr('disabled');
		$("#branchlist").removeAttr('disabled');
		$("#recentAccount").attr('disabled','disabled');
	}
}


function addFund() {
	$.ajax ({
		type : "POST",
		url : "addFund",
		data : {"accountNumber" : $("#accountNumber").val(),
			"amount" : $("#amount").val()},
		success : function(result) {
			$("#message").html(result);
		},
		error : function(){
			alert("Error while request..");
		}
	});
}

function tranferBySupport() {
	$.ajax ({
		type : "POST",
		url : "transferBySupport",
		data : {"sendAccount" : $("#accountNumber").val(),
			"targetAccount" : $("#targetaccountNumber").val(),
			"amount" : $("#amount").val()},
		success : function (result) {
			$("#message").html(result);
		},
		error : function(){
			alert("Error while request..");
		}
	});
}

function transferByUser() {
	$.ajax ({
		type : "POST",
		url : "user/transferByUser",
		data : {"targetAccount" : $("#targetAccount").val(),
			"amount" : $("#amount").val()},
		success : function (result) {
			$("#message").html(result);
		},
		error : function() {
			alert("Error while request..");
		}
	});
}
function transferTargetID() {
	$.ajax ({
		type : "POST",
		url : "user/transferTargetID",
		data : {"targetAccount" : $("#targetAccount").val(),
			"amount" : $("#amount").val()},
			success : function (result) {
				$("#message").html(result);
			},
			error : function() {
				alert("Error while request..");
			}
	});
}

function withdraw() {
	$.ajax ({
		type : "POST",
		url : "withdraw",
		data : {"accountNumber" : $("#accountNumber").val(),
			"amount" : $("#amount").val()},
		success : function(result) {
			$("#message").html(result);
		},
		error : function(){
			alert("Error while request..");
		}
	});
}



