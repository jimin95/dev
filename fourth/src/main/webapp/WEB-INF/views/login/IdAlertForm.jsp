<%@page import="main.java.com.mycompany.mybatis.MyBatisConnectionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.List"%>

<%@ page contentType="text/html;charset=UTF-8" %>

<div id="idAlertModal" class="modal fade" tabindex="-1" role="dialog" style="height: 600px">
	<div class="modal-dialog" role="document" style="width: 600px;">
		<div class="modal-content" style="height: 700px">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">
					<b>Alert Form</b>
				</h4>
			</div>
			<div class="modal-body" style="width: 600px">
				<!-- 여기부터 내용 -->
				<div id="signForm" class="container" style="width: 600px; margin-left: -100px; height: 600px;">
					<div class="row" style="width: 600px">
						<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3" style="width: 600px">
							<form role="form">
								
								<div class="row" style="width: 600px; margin-left: -80px">
									<h2>Alert</h2>
									<hr id="alert" class="colorgraph">
										
									<!-- <h1 style="width: 400px">아이디  사용 가능</h1> -->
	
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- 내용 끝 -->
			<div class="modal-footer" style="text-align: center;"></div>
			</div>
		</div>
	</div>
</div>