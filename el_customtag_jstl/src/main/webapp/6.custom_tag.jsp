<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="itwill" uri="http://www.itwill.co.kr/jsp/simpleTag"%>
<%
	session.setAttribute("sUserId", "guard");
	request.setAttribute("name", "현빈");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<h1>custom tag[사용자정의태그]</h1><hr/>
---------------hello tag----------------------<br>
<itwill:hello/>
<itwill:hello/>
---------------helloAttr tag----------------------<br>
<itwill:helloAttr irum="김경호" />
<itwill:helloAttr irum="공유" />
<itwill:helloAttr irum="${name}" />
<itwill:helloAttr irum="${sUserld}" />

---------------if tag[body]----------------------<br>













</body>
</html>