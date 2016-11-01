$().ready(function() {
	//判断用户是否已经登陆，如果登陆跳转到首页
	var username = window.localStorage.userName;

	if (!(username == null || username == "")) {
		alert("您必须先退出登录才能注册");
		window.location.href = "/";
	}

	$(".btn-register").on('click', 'button', function() {
		submitRegister();
	});

//	$(".getyzm").on('click', 'span', function() {
//		loadVerifyCode();
//	});
//
//	loadVerifyCode();
});

function submitRegister() {

	if ($("#username").attr("value") == "") {
		alert("请输入用户名");
		return;
	}
	
	if (!(checknm($("#username").attr("value")) || checkhz($("#username").attr("value")))) {
		alert("用户名包含非法字符");
		return;
	}

	if ($.trim($("#username").attr("value")).length < 2) {
		alert("用户名长度至少为2");
		return;
	}

	if ($("#password").attr("value") == "") {
		alert("请输入密码");
		return;
	}

	if ($("#repassword").attr("value") == "") {
		alert("请重复输入密码");
		return;
	}

	if (!checkhz($("#password").attr("value"))) {
		alert("密码中包含特殊字符");
		return;
	}
	
	if ($("#password").attr("value").length < 6 || $("#password").attr("value").length > 20) {
		alert("密码长度为6-20个字符");
		return;
	}

	if ($("#password").attr("value") != $("#repassword").attr("value")) {
		alert("两次密码输入不一致");
		return;
	}

//	if ($("#verifyvalue").attr("value") == "") {
//		alert("请输入验证码");
//		return;
//	}
//
//	var reg = new RegExp("^[0-9]*$");
//	if (!reg.test($("#verifyvalue").attr("value")) || $("#verifyvalue").attr("value").length != 4) {
//		alert("验证码输入有误");
//		return;
//	}

	$("#username").prop("disabled", true);
	$("#password").prop("disabled", true);
	$("#repassword").prop("disabled", true);
	$("#verifyvalue").prop("disabled", true);
	$(".btn-register").prop("disabled", true);
	$(".btn-register").html("注册中...");
	var data = {
		method : "register";
		username : $.trim($("#username").attr("value")),
		password : md5($.trim($("#password").attr("value"))),
		verifycode : $.trim($("#verifyvalue").attr("value")),
		token : $.trim($("#token").attr("value"))
	};
	if (window.localStorage.partnerId != null && window.localStorage.partnerId != "") {
		data["partnerId"] = window.localStorage.partnerId ;
	}
	//异步发送验证请求
	$.ajax({
		type : 'POST',
		url : 'http://www.homaer.com:8080/mapi/register.do',
		data : $.param(data),
		dataType : 'application/json',
		timeout : 10000,
		context : $('#tips'),
		success : function(data) {
			$("#username").removeAttr("disabled");
			$("#password").removeAttr("disabled");
			$("#repassword").removeAttr("disabled");
			$("#verifyvalue").removeAttr("disabled");
			$(".btn-register").removeAttr("disabled");
			$(".btn-register").html("立即注册");
			var jsonData = JSON.parse(data);
			if (jsonData['codeStatus'] == 100) {
				//存储localstorage
				window.localStorage.userName = jsonData["name"];
				window.localStorage.userId = jsonData["userId"];
				window.localStorage.account = jsonData["account"];
				window.location.href = "./profile.html";
			} else {
				alert(jsonData['errorMessage']);
				loadVerifyCode();
			}
		},
		error : function(xhr, type) {
			$("#username").removeAttr("disabled");
			$("#password").removeAttr("disabled");
			$("#repassword").removeAttr("disabled");
			$("#verifyvalue").removeAttr("disabled");
			$(".btn-register").removeAttr("disabled");
			$(".btn-register").html("立即注册");
			loadVerifyCode();
		}
	});
}

function checkhz(str) {
	var reg = /^[A-Za-z0-9]*$/;  
	if(reg.test(str)){ 
  		return true;
 	}
 	return false;
}

function checknm(str) {
	var reg = /^[\u4e00-\u9fa5]+$/i;  
	if(reg.test(str)){ 
  		return true;
 	}
 	return false;
}

function loadVerifyCode() {
	$("#verifycode").attr("src", null);
	//异步发送验证请求
	$.ajax({
		type : 'POST',
		url : '/api/verifycode.json',
		data : {
			foo : 'bar'
		},
		dataType : 'application/json',
		timeout : 20000,
		context : $('#tips'),
		success : function(data) {
			var jsonData = JSON.parse(data);
			$("#verifycode").prop("src", "../img/verify/" + jsonData["token"] + ".png");
			$("#token").prop("value", jsonData["token"]);
		},
		error : function(xhr, type) {

		}
	});
}
