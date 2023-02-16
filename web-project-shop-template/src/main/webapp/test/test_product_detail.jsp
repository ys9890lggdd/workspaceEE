<%@page import="com.itwill.shop.product.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ProductService productService=new ProductService();
	List<Product> productList = productService.productList();
%>
<ul>
<%for(Product product:productList){%>
	<li><a href='test_product_detail.jsp?p_no=<%=product.getP_no()%>'><%=product %></a></li>
<%}%>
</ul>