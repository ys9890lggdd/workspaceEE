<%@page import="com.itwill.shop.domain.User"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	UserService userService=new UserService();
	int result=
			userService.create(new User(userId,password,name,email));
	out.println("가입결과:"+result);
%>