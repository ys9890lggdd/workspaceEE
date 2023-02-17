package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller {
	UserService userService;
	public UserRemoveActionController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		HttpSession session = request.getSession();
		/**************** login_check *******************/
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:login_form.do";
		}
		/*********************************************/
		/*
		0.login 여부체크
		1.GET방식이면 redirect:user_main.do  forwardPath반환
		2.요청객체인코딩설정
		3.세션에있는 sUserId를 사용해서 UserService.remove(sUserId) 메쏘드호출
		4.성공: redirect:user_main.do  forwardPath반환
		  실패: forward:/WEB-INF/views/user_error.jsp  forwardPath반환
		*/
		if(request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:user_main.do";
		}else {
			try {
				request.setCharacterEncoding("UTF-8");
				userService.remove(sUserId);
				session.invalidate();
				forwardPath="redirect:user_main.do";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/user_error.jsp";
			}
		}	
		return forwardPath;
	}

}