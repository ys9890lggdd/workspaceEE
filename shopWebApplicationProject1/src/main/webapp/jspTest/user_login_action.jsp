<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	UserService userService=new UserService();
	int result=userService.login(userId, password);	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>user_login_action.jsp</h1><hr>
로그인결과<%=result%>
</body>
</html>