package com.itwill.model2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;

public class UpdateFormController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) {
		// TODO Auto-generated method stub
		return "forward:/WEB-INF/views/update_form.jsp";
	}

}