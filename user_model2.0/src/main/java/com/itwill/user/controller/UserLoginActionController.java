package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserLoginActionController implements Controller {
	private UserService userService;

	public UserLoginActionController() throws Exception {
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*
		0  . GET방식요청일때 redirect:user_login_form.do forwardPath반환
		2  . 파라메타 받기
		3  . UserService객체생성
		4  . UserService.login() 메쏘드실행
		  0 : 아이디존재안함  	-> forward:/WEB-INF/views/user_login_form.jsp  forwardPath반환
		  1 : 패쓰워드 불일치	-> forward:/WEB-INF/views/user_login_form.jsp  forwardPath반환
		  2 : 로그인성공(세션)	-> redirect:user_main.do  forwardPath반환
		*/
		//HttpSession session=request.getSession();
		String forwardPath = "";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:user_login_form.do";
			}else {
				String userId = request.getParameter("userId");
				String password = request.getParameter("password");
				User fuser = new User(userId, password, "", "");
				int loginResult = userService.login(userId, password);
				if(loginResult == 0) {
					/*
					 * 아이디 존재하지 않으면~
					 */
					String msg1 = userId + "는 존재하지 않는 아이디입니다.";
					request.setAttribute("msg1", msg1);
					request.setAttribute("fuser", fuser);
					forwardPath = "forward:WEB-INF/views/user_login_form.jsp";
                                        
				}else if(loginResult == 1) {
					/*
					 * 비밀번호 일치하지 않으면~
					 */
					String msg2 = password + "비밀번호가 일치하지 않습니다.";
					request.setAttribute("msg2", msg2);
					request.setAttribute("fuser", fuser);
					forwardPath = "forward:WEB-INF/views/user_login_form.jsp"; 
				}else if(loginResult == 2) {
					/*
					 * 로그인 성공이면~			
					 */
					request.setAttribute("sUserId", userId);
					forwardPath="redirect:user_main.do";
				}
			}
	
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/user_error.jsp";
			}	
		return forwardPath;
	}
}