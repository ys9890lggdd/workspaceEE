<%@page import="com.itwill.shop.domain.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId="guard1";
	CartService cartService=new CartService();
	List<CartItem> cartItemList=cartService.getCartList(sUserId);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>cart_view.jsp</h1><hr>
<ol>
<%for(CartItem cartItem:cartItemList){ %>
	<li><a href='cart_delete_item_action.jsp?cart_no=<%=cartItem.getCart_no()%>'><%=cartItem%></a></li>	
<% }%>
</ol>
</body>
</html>