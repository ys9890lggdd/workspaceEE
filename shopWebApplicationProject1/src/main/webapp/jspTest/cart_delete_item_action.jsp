<%@page import="com.itwill.shop.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	CartService cartService=new CartService();
	int result=cartService.deleteCartItem(22);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>cart_delete_item_action.jsp</h1><hr>
<p>result:<%=result %></p>
</body>
</html>