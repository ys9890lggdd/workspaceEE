<%@page import="com.itwill.shop.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductService productService=new ProductService();
	List<Product> productList =  productService.getProductList();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>product_list.jsp</h1><hr>
<ol>
<%for(Product product:productList){ %>
	<li><a href='product_detail.jsp?p_no=<%=product.getP_no()%>'><%=product%></a></li>
<%} %>
</ol>
</body>
</html>