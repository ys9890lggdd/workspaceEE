package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestWriteFormSevlet
 */
@WebServlet("/guest_write_form.do")
public class GuestWriteFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		forwardPath = "/WEB-INF/views/guest_write_form.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
		
	}

}
