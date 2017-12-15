<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>

<body>
	<fieldset><legend>로그인</legend> </fieldset>

	<div id="loginForm" class="container">

		<div class="row" style="margin-top: 20px">
			<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form>
					<fieldset>
					
						<h2>로그인 해주세요</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="text" id="ist_userid" name="ist_userid" class="form-control input-lg" placeholder="아이디">
						</div>
						<div class="form-group">
							<input type="password" id="ist_password" name="ist_password" class="form-control input-lg" placeholder="비밀번호">
						</div>
						
						
						<span class="button-checkbox">
							<button type="button" class="btn" data-color="info">아이디 저장</button> 
							<input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden"> 
							<a id="rememberPw" class="btn btn-link pull-right">비밀번호가 생각이 안나세요?</a>
						</span>
						
						
						<hr class="colorgraph">
						
						
					</fieldset>
				</form>
						<div class="row" >
							<div class="col-xs-6 col-sm-6 col-md-6" style="float: left;">
								<button id="btnLogin" class="btn btn-lg btn-primary btn-block" >로그인</button>
							</div>
							<!-- 회원가입 버튼 부분 -->
							<div class="col-xs-6 col-sm-6 col-md-6" >
								<button id="btnSign" class="btn btn-lg btn-success btn-block" >회원가입</button>
							</div>
						</div>
							
							
			</div>
		</div>

	</div>
	
	<%-- <%@ include file="SignForm.jsp" %>
	<%@ include file="IdAlertForm.jsp" %> --%>
</body>
</html>