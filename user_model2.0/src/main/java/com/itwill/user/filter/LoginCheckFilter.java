package com.itwill.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//System.out.println("LoginCheckFilter-->");
		
		String sUserId = (String)req.getSession().getAttribute("sUserId");
		if(sUserId==null) {
			resp.sendRedirect("user_main.do");
			return;
		}
		chain.doFilter(request, response);
		
	}

}
