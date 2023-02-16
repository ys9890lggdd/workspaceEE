package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressUpdateFormServlet
 */
@WebServlet("/address_update_form.do")
public class AddressUpdateFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 요청라인 POST /addressSite/address_update_form.do HTTP/1.1 요청헤더 요청바디 no=1
			 */

			/*
			 * 0.요청객체인코딩설정 1.파라메타받기(no) 2.AddressService객체생성 3.받은파라메타로
			 * AddressService.selectByNo()메쏘드실행 4.반환받은 Address객체를 사용해서 클라이언트로 응답(수정폼 보여주기)
			 */
			request.setCharacterEncoding("UTF-8");
			String noStr = request.getParameter("no");

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>[김경호님 주소록 수정폼]</h1><hr>");
			out.println("<hr>");
			out.println("	<div>");
			out.println("		<a href='address_main.do'>[메인]</a>");
			out.println("		<a href='address_insert_form.do'>[주소록쓰기폼]</a>");
			out.println("		<a href='address_list.do'>[주소록리스트]</a>");
			out.println("	</div>");
			out.println("	<form method='post' action='address_update_action.do'>");
			out.println("		번호----<input type='hidden' name='no' value='" + noStr + "'><br>");
			out.println("		이름----<input type='text' name='name' value='김경호'><br>");
			out.println("		전화번호<input type='text' name='phone' value='123-4568'><br>");
			out.println("		주소----<input type='text' name='address' value='경기도 성남시'><br> ");
			out.println("		<input type='submit' value='주소록수정'>");
			out.println("		<input type='reset' value='주소록수정폼지우기'>");
			out.println("	</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
