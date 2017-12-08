<%@page import="main.java.com.mycompany.mybatis.MyBatisConnectionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.List"%>

<%@ page contentType="text/html;charset=UTF-8" %>

<div id="signModal" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document" style="width: 1000px;">
		<div class="modal-content" style="height: 700px">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">
					<b>Sign Form</b>
				</h4>
			</div>
			<div class="modal-body">
				<!-- 여기부터 내용 -->
				<div id="signForm" class="container" style="margin-left: -100px">
					<div class="row">
						<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
							
								
								<div class="row">
									<h2>Sign Up</h2>
									<hr class="colorgraph">
										
										<!-- 아이디 -->
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
                        						<input type="text" id="user_id" name="first_name" class="form-control input-lg" placeholder="아이디" tabindex="1">
											</div>
										</div>
										
										<!-- 아이디 중복검사 확인 버튼 만들 곳 -->
										<div class="col-xs-6 col-sm-6 col-md-6">
											<button id="btnIdMatch" class="btn btn-lg btn-warning btn-block" >아이디 중복 검사</button>
										</div>
										
										<!-- 비밀번호 & 비밀번호 확인 -->
										<div class="form-group">
											<div class="form-group">
													<input type="password" id="user_pw" name="password" class="form-control input-lg" placeholder="비밀번호" tabindex="2">
											</div>
											<div class="form-group">

													<input type="password" id="user_pw_confirm" name="password_confirmation" class="form-control input-lg" placeholder="비밀번호 확인" tabindex="3">
											</div>
										</div>
										
										<!-- 이메일 -->
										<div class="form-group">
											<input type="email" id="email" name="display_name" class="form-control input-lg" placeholder="이메일" tabindex="4">
										</div>
										
										<!-- 전화번호 -->
										<div class="form-group">
											<input type="tel" id="tel" name="last_name" class="form-control input-lg" placeholder="전화번호" tabindex="5">
										</div>
	
									
									<hr class="colorgraph">
									<div class="row">
										
										<!-- 회원가입 -->
										<div class="col-xs-6 col-md-6">
											<button id="btnUserReg" class="btn btn-primary btn-block btn-lg" tabindex="6">회원가입</button>
										</div>
										
										<!-- 로그인 -->
										<div class="col-xs-6 col-md-6">
											<button id="btnLoginFormBack" class="btn btn-success btn-block btn-lg" tabindex="6">로그인</button>
										</div>
									
									</div>
									
								</div>
							
						</div>
					</div>
				</div>
				<!-- 내용 끝 -->
			<div class="modal-footer" style="text-align: center;"></div>
			</div>
		</div>
	</div>
</div>