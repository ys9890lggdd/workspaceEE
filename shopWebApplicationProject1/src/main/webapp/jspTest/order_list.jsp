<%@page import="com.itwill.shop.domain.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId="guard1";
	OrderService orderService=new OrderService();
	List<Order> orderList = orderService.list(sUserId);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>order_list.jsp</h1><hr>
<ol>
<%for(Order order:orderList){ %>
	<li><a href='order_detail.jsp?o_no=<%=order.getO_no()%>'><%=order %></a></li>
<%} %>
</ol>
</body>
</html>