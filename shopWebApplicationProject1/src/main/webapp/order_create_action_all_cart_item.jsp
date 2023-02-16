<%@page import="com.itwill.shop.service.CartService"%>
<%@page import="com.itwill.shop.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
/*
	 주문생성
*/
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("order_list.jsp");
	return;
}
OrderService orderService = new OrderService();
orderService.create(sUserId);
response.sendRedirect("order_list.jsp");
%>