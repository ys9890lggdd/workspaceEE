package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet1
 */
@WebServlet("/join1.do")
public class JoinServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * GET방식으로 요청이 들어오면 05-03.form1.html로 방향재지정(redirection)
		 */
		response.sendRedirect("05-03.form1.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		/*
		 * 0.요청객체인코딩설정
		 */
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * 1.파라메타받기
		 */
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2;
		String gender = request.getParameter("gender");
		String[] favorites = request.getParameterValues("favorite");
		String message = request.getParameter("message");

		/*
		 * 2.업무실행(Service객체 메쏘드호출)
		 */

		/*
		 * 3.클라이언트로 응답출력
		 */
		out.println("<h1>가입정보</h1>");

		out.println("<ul>");
		out.println("<li>아이디:"+id+"</li>");
		out.println("<li>패쓰워드:"+password+"</li>");
		out.println("<li>이메일:"+email+"</li>");
		out.println("<li>성별:"+gender+"</li>");
		out.println("<li>가입인사:"+message+"</li>");
		out.println("<li>관심사");
		out.println("<ul>");
		if(favorites!=null) {
			for(String favorite:favorites) {
				out.println("<li>"+favorite+"</li>");
			}	
		}
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");

	}

}
