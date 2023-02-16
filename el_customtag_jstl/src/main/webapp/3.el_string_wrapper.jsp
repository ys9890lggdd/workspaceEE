<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("sUserId", "page_guard");
	request.setAttribute("sUserId", "request_guard");
	session.setAttribute("sUserId", "session_guard");
	application.setAttribute("sUserId", "application_guard");
	
	
	request.setAttribute("name","제임스딘");
	request.setAttribute("age",new Integer(34));
	request.setAttribute("age",29);
	request.setAttribute("weight",69.23);
	request.setAttribute("married",true);
	double height=182.1;
	String address="서울시민";
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String,Wrapper객체(기본형객체) 출력</h1>
<ol>
	<li>${sUserId}</li>
	<li>${name}</li>
	<li>${age}</li>
	<li>${weight}</li>
	<li>${married}</li>
	<li>EL출력불가능[속성객체가아니므로]</li>
	<li>null--> "" ${height}</li>
	<li><%=request.getAttribute("height")%></li>
	<li>null--> "" ${address}</li>
	<li><%=request.getAttribute("address")%></li>
	
</ol>
</body>
</html>










