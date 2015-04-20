/**
 * 
 */


function changePassword(){
	$("#buttonChange").css("visibility","hidden");
	$("#buttonSubmit").css("display","block");
	$("#changePassSection").css("display","block");
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
				$("#message").css("display","block");	
				$("#message").html('<i class="fa fa-cogs"></i>' + result);
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

var oldFirstName;
var oldLastName;
var oldMidName;
var oldPhone2;
var oldAddress2;
var oldEmail2;

function changeInfo(){
	if ($("#buttonSubmitEdit").html() == "Edit") {		
		$(".editable").removeAttr("disabled");
		$("#buttonCancelEdit").css("visibility","visible");
		$("#buttonSubmitEdit").html("Submit");
		oldFirstName = $("#firstName").val();
		oldMidName = $("#midName").val();
		oldLastName = $("#lastName").val();
		oldPhone2 = $("#phoneNume2").val();
		oldAddress2 = $("#address2").val();
		oldEmail2 = $("#email2").val();
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
			"email2" : $("#email2").val(),
			"phone2" : $("#phoneNum2").val()},					
			success : function (result) {
				var success = result.substring(0,result.indexOf(':'));
				result = result.substring(result.indexOf(':')+1);
				
				$("#message").css("display","block");	
				$("#message").html('<i class="fa fa-cogs"></i>' + result);
				if (success != "SUCCESS") {					
					$("#message").attr("class","Metronic-alerts alert fade in alert-alert");
					cancelEditInfo(true);
					return;
				}	
				else{			
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
	$(".editable").attr("disabled","disabled");
	$("#buttonCancelEdit").css("visibility","hidden");
	$("#buttonSubmitEdit").html("Edit");
	if (isReload) {		
		$("#firstName").val(oldFirstName);
		$("#midName").val(oldMidName);
		$("#lastName").val(oldLastName);
		$("#phoneNume2").val(oldPhone2);
		$("#address2").val(oldAddress2);
		$("#email2").val(oldEmail2);
	}
}

