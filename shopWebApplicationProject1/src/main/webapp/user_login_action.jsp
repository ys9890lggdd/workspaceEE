<%@page import="com.itwill.shop.service.UserService"%>
<%@page import="java.net.URLEncoder"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
	UserService userService=new UserService();
	int result=userService.login(userId, password);
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	if(result==0){
		/*****************case1 redirect************/
		String msg1=URLEncoder.encode(userId+" 는 존재하지않는 아이디입니다","UTF-8");
		userId=URLEncoder.encode(userId,"UTF-8");
		password=URLEncoder.encode(password,"UTF-8");
		response.sendRedirect("user_login_form.jsp?msg1="+msg1+"&userId="+userId+"&password="+password);
		
		/************case2 script*********************
		out.println("<script>");
		out.println("alert('"+userId+" 는 존재하지않는 아이디입니다');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		**************************************/
		/*****************case3 forward************
		******************************************/
	}else if(result==1){
		/*****************case1 redirect************/
		String msg2=URLEncoder.encode("패쓰워드가 일치하지않습니다.","UTF-8");
		userId=URLEncoder.encode(userId,"UTF-8");
		password=URLEncoder.encode(password,"UTF-8");
		response.sendRedirect("user_login_form.jsp?msg2="+msg2+"&userId="+userId+"&password="+password);
		/************case2 script********************
		out.println("<script>");
		out.println("alert('패쓰워드가 일치하지않습니다.');");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		**************************************/
		
		/*****************case3 forward************
		******************************************/
	
	}else if(result==2){
		
		session.setAttribute("sUserId", userId);
		response.sendRedirect("shop_main.jsp");
	}
%>