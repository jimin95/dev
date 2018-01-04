$(function() {
	$("#btnLogin").on("click", function() {
		console.log("[loginForm] 자바스크립트 플로우");
		
		var ist_userid = $("#loginForm #ist_userid").val();
		var ist_password = $("#loginForm #ist_password").val();
		
		console.log(ist_userid);
		console.log(ist_password);
		
		$.ajax({
			url:"loginForm/login",
			cache: false,
			type: "post",
			data: {
				"ist_userid" : ist_userid,
				"ist_password" : ist_password
				},
			success: function(data){
				console.log("[loginForm] 데이터 플로우");
				
				if(data.result == "LOGIN_SUCCESS"){
					console.log("[로그인 성공]");
					location.href = "views/ist/istList.jsp";
				}else{
					console.log("[로그인 실패]");
					location.href = "views/ist/istList.jsp";//이 부분 추구, 수정해야함
				}
			}
		});
		
	});
	//-------------------------------------
	$("#btnSign").on("click", function() {
		console.log("[signForm] 자바스크립트 플로우");
		
		//$("#signModal").modal("show"); <- 이거 때문에 모달 처리에 에러가 생김, 딱 밑에 코드로 모달이 띄워지도록, show는 한번 보여준다 개념
		$("#signModal").modal({
			backdrop:"static",
			show:true
		});
	});
	
	$("#btnUserReg").on("click", function() {
		console.log("[btnUserReg] 자바스크립트 플로우");
		
		var user_id = $("#signForm #user_id").val();
		var user_pw = $("#signForm #user_pw").val();
		var user_pw_confirm = $("#signForm #user_pw_confirm").val();
		var email = $("#signForm #email").val();
		var tel = $("#signForm #tel").val();
		
		console.log(user_id);
		console.log(user_pw);
		console.log(user_pw_confirm);
		console.log(email);
		console.log(tel);
		
		if(user_pw != user_pw_confirm){
			alert("비밀번호가 다릅니다.");
		}else{
			$.ajax({
				url:"Sign.jsp",
				cache: false,
				type: "post",
				data: {
					"user_id" : user_id,
					"user_pw" : user_pw,
					"email" : email,
					"tel" : tel
					},
				success: function(data){
					console.log("[btnUserReg] 데이터 플로우");					
					var result = jQuery.trim(data);
			
					if(result == "success"){
						console.log("[회원가입 성공]");
						$("#signForm #user_id").attr("placeholder","아이디").val("").focus().blur();
						$("#signForm #user_pw").attr("placeholder","비밀번호").val("").focus().blur();
						$("#signForm #user_pw_confirm").attr("placeholder","배밀번호").val("").focus().blur();
						$("#signForm #email").attr("placeholder","이메일").val("").focus().blur();
						$("#signForm #tel").attr("placeholder","전화번호").val("").focus().blur();
						
					}else{
						console.log("[회원가입 실패]");
						$("#signForm #user_id").attr("placeholder","아이디").val("").focus().blur();
						$("#signForm #user_pw").attr("placeholder","비밀번호").val("").focus().blur();
						$("#signForm #user_pw_confirm").attr("placeholder","배밀번호").val("").focus().blur();
						$("#signForm #email").attr("placeholder","이메일").val("").focus().blur();
						$("#signForm #tel").attr("placeholder","전화번호").val("").focus().blur();
					}
				}
					
			});
			
		}
	});
	
	$("#btnIdMatch").on("click", function() {
		console.log("[btnIdMatch] 자바스크립트 플로우");
		var user_id = $("#signForm #user_id").val();
		
		$.ajax({
			url:"Alert.jsp",
			cache: false,
			type: "post",
			data: {"user_id" : user_id},
			success: function(data){
				console.log("[btnIdMatch] 데이터 플로우");
				var result = jQuery.trim(data);
				
				$("#idAlertModal #alert").empty();
				if(result == "success"){
					console.log("[아이디 사용 가능]");
					$("#idAlertModal #alert").append("<h1 style='width: 300px'>아이디  사용 가능</h1>");
				}else{
					console.log("[아이디 사용 불가]");	
					$("#idAlertModal #alert").append("<h1 style='width: 300px'>아이디  사용 불가</h1>");
				}
				
			}
				
		});
		$("#signModal").css("opacity","0.5");
		$("#idAlertModal").modal({
			backdrop:"static",
			show:true
		});
		
		$("#idAlertModal").on("hidden.bs.modal", function() {
			$("#signModal").css("opacity","1");
		});
	});
	
	$("#rememberPw").on("click", function() {
		
	});
	
	
	$("#btnLoginFormBack").on("click", function() {
		$("#signModal").modal("hide");
	});
	/*$("#btnSign").on("click", function() {
	});*/
});



