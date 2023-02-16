
<%@page import="com.itwill.shop.service.UserService"%>
<%@page import="com.itwill.shop.domain.User"%>
<%@page import="java.net.URLEncoder"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_write_form.jsp");
		return;
	}
	
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	User newUser=new User(userId,password,name,email);
	UserService userService=new UserService();
	int result = userService.create(newUser);
	if(result == -1){
		//아이디중복
		/*************case1 redirection*****************
		String msg=URLEncoder.encode(userId+" 는 이미존재하는 아이디입니다.","UTF-8");
		userId=URLEncoder.encode(userId, "UTF-8");
		password=URLEncoder.encode(password, "UTF-8");
		name=URLEncoder.encode(name, "UTF-8");
		email=URLEncoder.encode(email, "UTF-8");
		response.sendRedirect("user_write_form.jsp?msg="+msg+"&userId="+userId+"&password="+password+"&name="+name+"&email="+email);
		****************************************/
		/************case2 script*********************
		out.println("<script>");
		out.println("alert('"+userId+"는 이미존재하는 아이디입니다');");
		out.println("location.href='user_write_form.jsp';");
		out.println("</script>");
		**************************************/
		/************case3 forward****************/
		String msg = userId+" 는 이미존재하는 아이디입니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("fuser",newUser);
		/***************************************/
%>
	 <jsp:forward page="user_write_form.jsp"/>
<%
		
		
	}else if(result==1){
		//회원가입성공
		response.sendRedirect("user_login_form.jsp");
	}
%>
		














