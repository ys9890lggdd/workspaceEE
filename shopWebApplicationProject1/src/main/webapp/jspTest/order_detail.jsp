<%@page import="com.itwill.shop.domain.Order"%>
<%@page import="com.itwill.shop.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId=	"guard1";
	String o_noStr=request.getParameter("o_no");
	OrderService orderService=new OrderService();
	Order order=orderService.detail(sUserId, Integer.parseInt(o_noStr));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>order_detail.jsp</h1><hr>
<p>
<%=order %>
</p>
</body>
</html>