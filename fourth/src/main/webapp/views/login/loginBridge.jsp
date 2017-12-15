<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
System.out.println("[loginBridge]");

RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ist/istList.jsp");
rd.forward(request, response);
	
%>