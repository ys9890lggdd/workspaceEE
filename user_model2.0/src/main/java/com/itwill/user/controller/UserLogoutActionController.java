package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.UserService;

public class UserLogoutActionController implements Controller{
	UserService userService;
	public UserLogoutActionController() throws Exception {
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		HttpSession session = request.getSession();
		/****************login_check*******************/
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:login_form.do";
		}
		/*********************************************/
		session.invalidate();
		forwardPath="redirect:user_main.do";
		return forwardPath;
	}

}