<%@page import="com.itwill.shop.domain.Product"%>
<%@page import="com.itwill.shop.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String p_noStr=request.getParameter("p_no");
	ProductService productService=new ProductService();
	Product product=productService.getProduct(Integer.parseInt(p_noStr));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>product_detail.jsp</h1><hr>
<p>
	<%=product %>
</p>
</body>
</html>