<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
System.out.println("[failBridge]");

RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp");
rd.forward(request, response);
	
%>