<%@page import="com.itwill.shop.service.CartService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int cart_item_count=0;
	String sUserId=(String)session.getAttribute("sUserId");
	if(sUserId!=null){
		CartService cartService=new CartService();
		cart_item_count = cartService.getCartList(sUserId).size();
	}
%>		
<div id="menu">
	<ul>
		<li id="m_login"><a href="javascript:;">로그인</a></li>
		<li id="m_join"><a href="javascript:;" >회원가입</a></li>
		<li id="m_order"><a href="">주문/배송</a></li>
		
		<li id="m_customer"><a href="">고객센터</a></li>
		<li id="m_mypage"><a href="">My한샘</a></li>
		<li id="logo"><a href="shop_main.jsp"></a></li>
		<%-- 
		<%if(sUserId==null){  %>
			<li id="mypage" title="나의페이지" ><a href="user_login_form.jsp" ></a></li>
			<li id="cart" title="장바구니"><span class="w3-badge-no-login w3-green-no-login w3-margin-right">0 </span><a href="user_login_form.jsp" title="장바구니"></a></li>
		<%}else{ %>
			<li id="mypage" title="나의페이지" ><a href="user_view.jsp"></a></li>
			<li id="cart" title="장바구니"><span class="w3-badge w3-green w3-margin-right"><%=cart_item_count%></span><a href="cart_view_select_update_qyt_all_check_delete_image.jsp"></a></li>
		<%} %>
		--%>
		
		
		
	</ul>
<ul id="sub_menu">
	<li id="search_form">
			<form style="margin: 10px">
				<select>
					<option>카테고리</option>
					<option>카테고리1</option>
					<option>카테고리2</option>
					<option>카테고리3</option>
				</select>
				<input type="search" >&nbsp;&nbsp;&nbsp;<input type="submit" value="검색">
			</form>
	</li>
		
	</ul>
		
	
</div>