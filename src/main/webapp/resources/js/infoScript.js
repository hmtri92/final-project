/**
 * 
 */


function changePassword(){
	$("#buttonChange").css("visibility","hidden");
	$("#buttonSubmit").css("display","inline");
	$("#changePassSection").css("display","inline");
	$("#newPassword").val("");		
	$("#retypePassword").val("");	
	$("#password").val("");	
	$("#password").removeAttr("disabled");	
}

function submitChangePassword(currentPass){
	var password = $("#password").val();
	var newPassword = $("#newPassword").val();
	var retypePassword = $("#retypePassword").val();	
	
	if (password !=  currentPass) {
		alert("Please enter the correct password!");
		$("#password").select();	
		return;
	}
	
	
	if (8 > newPassword.length || newPassword.indexOf(' ') != -1) {
		alert("Please enter the new password! Password length must have more than 8 character and no space character.");
		$("#retypePassword").val("");
		$("#newPassword").select();	
		return;
	}
	
	
	if (retypePassword != newPassword) {
		alert("Please enter the same password!");
		$("#retypePassword").select();	
		return;
	}
	
	cancelChangePassword(doChangePassword(currentPass));
	
}

function doChangePassword(currentPass){
	$.ajax ({
		type : "POST",
		url : "changeUserPassword",
		data : {"id" : $("#accountNumber").val(),
			"password" : $("#password").val(),
			"newPassword" : $("#newPassword").val()},			
			success : function (result) {
				var success = result.substring(0,result.indexOf(':'));
				result = result.substring(result.indexOf(':')+1);
				$("#message").css("display","inline");	
				$("#message").html(result);
				if (success == "SUCCESS") {					
					$("#message").attr("class","Metronic-alerts alert fade in alert-success");									
					return $("#newPassword").val();	
				} else {					
					$("#message").attr("class","Metronic-alerts alert fade in alert-alert");	
					return currentPass;
				}				
			},
			error : function() {
				alert("Error while processing request..");
			}
	});
}

function cancelChangePassword(password){
	$("#buttonChange").css("visibility","visible");
	$("#buttonSubmit").css("display","none");
	$("#changePassSection").css("display","none");	
	$("#password").val(password);	
	$("#password").attr("disabled","disabled");	
}

function changeInfo(){
	if ($("#buttonSubmitEdit").html() == "Edit") {		
		$(".editable").removeAttr("disabled");
		$("#buttonCancelEdit").css("visibility","visible");
		$("#buttonSubmitEdit").html("Submit");
	}else{
		
		if ($("#firstName").val() == "") {
			alert("First name is incorrect!");
			$("#firstName").select();
			return;
		}
		if ($("#lastName").val() == "") {
			alert("Last name is incorrect!");
			$("#lastName").select();
			return;
		}
		
		doEditInfo();
	}	
}

function doEditInfo(){
	$.ajax ({
		type : "POST",
		url : "editUserInfo",
		data : {"id" : $("#accountNumber").val(),
			"firstName" : $("#firstName").val(),
			"midName" : $("#midName").val(),
			"lastName" : $("#lastName").val(),	
			"address2" : $("#address2").val(),
			"phone2" : $("#phoneNum2").val()},					
			success : function (result) {
				var success = result.substring(0,result.indexOf(':'));
				result = result.substring(result.indexOf(':')+1);
				
				$("#message").css("display","inline");	
				
				if (success != "SUCCESS") {
					$("#message").html(result);
					$("#message").attr("class","Metronic-alerts alert fade in alert-alert");
					cancelEditInfo(true);
					return;
				}	
				else{
					$("#message").html(result);
					$("#message").attr("class","Metronic-alerts alert fade in alert-success");
					cancelEditInfo(false);					
					return;
				}				
								
			},
			error : function() {
				alert("Error while processing request..");
				cancelEditInfo(true);
			}
	});
}

function cancelEditInfo(isReload){
	if (!isReload) {
		$(".editable").attr("disabled","disabled");
		$("#buttonCancelEdit").css("visibility","hidden");
		$("#buttonSubmitEdit").html("Edit");
	}
}

