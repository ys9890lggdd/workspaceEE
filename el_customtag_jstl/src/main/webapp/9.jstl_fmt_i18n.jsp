<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%
 	/*
 	1.Locale객체얻기,생성
 	2.ResourceBundle 의 properties파일지정
 	*/
 %>
 <%--1.Locale객체설정(JSTL)  
<fmt:setLocale value="${pageContext.request.locale}"/>
--%>
<fmt:setLocale value="${param.lang}"/>
<%--2.ResourceBunble의 properties파일지정(JSTL) --%>
<fmt:setBundle basename="com/itwill/i18n/guest"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL I18N[Internationalization] 국제화</h1><hr>
<a href="9.jstl_fmt_i18n.jsp?lang=en">영어</a>
<a href="9.jstl_fmt_i18n.jsp?lang=ja">일어</a>
<a href="9.jstl_fmt_i18n.jsp?lang=zh">중국어</a>
<a href="9.jstl_fmt_i18n.jsp?lang=ko">한국어</a>
<ol>
	<li><fmt:message key="title.main"/></li>
	<li><fmt:message key="title.list"/></li>
	<li><fmt:message key="title.view"/></li>
	<li><fmt:message key="title.write"/></li>
	<fmt:bundle basename="com/itwill/i18n/user">
	    <li><fmt:message key="page.title"/></li>
	    <li><fmt:message key="page.login.header"/></li>
	    <li><fmt:message key="page.view.header"/></li>
	    <li><fmt:message key="page.modify.header"/></li>
	    </fmt:bundle>	
</ol>
</body>
</html>