<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
</head>

<body>
	

					<div class="wrapper" align="center">
						<div>
							<fieldset style="width: 300; font-size: 18px; font-weight: bold;">
								<br> 조회 날짜 : <input id="datepicker1"style="border-style: groove;" type="date" min="1987-07-01" max="2020-08-01" name="date1" step="1"> 
									~ <input id="datepicker2" style="border-style: groove;" type="date" min="1987-07-01" max="2020-08-01" name="date2" step="1">

								<input id="termList" type="submit" onclick="termList()" value="검색" /> <input type="reset" value="리셋" />
							</fieldset>
						</div>

						<div style="margin-top: 20px; text-align: right; width: 900px;">
							
						</div>

						<table id="acrylic" style="width: 900px">
							<thead>
								<tr>
									<th style="width: 100px">사번</th>
									<th style="width: 100px">장비번호</th>
									<th style="width: 100px">부서그룹</th>
									<th style="width: 100px">사용자</th>
									<th style="width: 100px">직책명</th>
									<th style="width: 100px">지역</th>
									<th style="width: 100px">장비구분</th>
									<th style="width: 100px">장비모델</th>
									<th style="width: 100px">시리얼</th>
									<th style="width: 100px">구입일</th>
									<th style="width: 100px">설치일</th>
									<th style="width: 100px">사용구분</th>
									<th style="width: 100px">주소</th>
									<th style="width: 100px">비고</th>
								</tr>
							</thead>
							<tbody id="orderTbody">
								<!-- jQuery로 채워지는 리스트 내용 -->
							</tbody>
						</table>
						
						
					</div>
				
</body>
</html>