<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.product.Product"%>
<%@page import="com.itwill.shop.product.ProductService"%>
<%@page import="com.itwill.shop.user.UserService"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@page import="com.itwill.shop.cart.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("order_list.jsp");
	return;
}
String buyType = request.getParameter("buyType");
String p_noStr = request.getParameter("p_no");
String p_qtyStr = request.getParameter("p_qty");
String[] cart_item_noStr_array = request.getParameterValues("cart_item_no");

if(buyType==null)buyType="";
if(p_noStr==null)p_noStr="";
if(p_qtyStr==null)p_qtyStr="";
if(cart_item_noStr_array==null)cart_item_noStr_array=new String[]{};

CartService cartService = new CartService();
UserService userService = new UserService();
ProductService productService = new ProductService();

ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
User user = userService.findUser(sUserId);

if (buyType.equals("cart")) {
	cartItemList = cartService.getCartList(sUserId);
} else if (buyType.equals("cart_select")) {
	for (String cart_item_noStr : cart_item_noStr_array) {
		cartItemList.add(cartService.getCartItemByCartNo(Integer.parseInt(cart_item_noStr)));
	}
} else if (buyType.equals("direct")) {
	Product product = productService.selectByNo(Integer.parseInt(p_noStr));
	cartItemList.add(new CartItem(0, user, product, Integer.parseInt(p_qtyStr)));
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
 
<style type="text/css" media="screen">
/*
form > table tr td{
	border: 0.1px solid black;
}
*/
</style>
<script type="text/javascript">
	function order_create_form_submit() {
		document.order_create_form.method = 'POST';
		document.order_create_form.action = 'order_create_action.jsp';
		document.order_create_form.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
		<form name="order_create_form" method="post">
		<input type="hidden" name="buyType" value="<%=buyType%>"> <input
			type="hidden" name="p_no" value="<%=p_noStr%>"> <input
			type="hidden" name="p_qty" value="<%=p_qtyStr%>">
		<%
		for (String cart_item_noStr : cart_item_noStr_array) {
		%>
		<input type="hidden" name="cart_item_no" value="<%=cart_item_noStr%>">
		<%
		}
		%>
	</form>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											주문/결제폼</b></td>
								</tr>
							</table> <!--form-->
							<form>
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;주문할상품</caption>
									<tr style="border: 0.1px solid">
										<td width=30 height=25 bgcolor="E6ECDE" align=center class=t1></td>
										<td width=260 height=25 bgcolor="E6ECDE" align=center class=t1>구입상품명</td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1>수
											량</td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1>가
											격</td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1>적립</td>
									</tr>
									<%
									int tot_price = 0;
									for (CartItem cart : cartItemList) {
										tot_price += cart.getCart_qty() * cart.getProduct().getP_price();
									%>
									<!-- cart item start -->
									<tr>
										<td width=30 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=1'><img width="30"  height="26" src="image/bigle.gif"></a>
										</td>
										<td width=260 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=1'>비글</a>
										</td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1>2</td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
											1,100,000
										</td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
									</tr>
									<!-- cart item end -->
									<%}%>
									
									
									<tr>
										<td width=640 colspan=5 height=26 bgcolor="ffffff" class=t1>
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###").format(tot_price)%>
												</font>
											</p>
										</td>
									</tr>
								</table>
								<br/>
								<table align=center width=80% border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;주문자정보</caption>
									<tr>
										<td width="86px" bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>이름</td>
										<td height=26 align="left"  bgcolor="ffffff" class=t1 colspan="3" >&nbsp;&nbsp;최혜정</td>
									</tr>	
									<tr>
										<td width="86px" bgcolor="E6ECDE"  height=26 align=center bgcolor="ffffff" class=t1>이메일</td>
										<td  height=26 align=left bgcolor="ffffff" class=t1>
											&nbsp;&nbsp;<input style="width:70px" type="text" name="email1">@<input style="width:70px" type="text" name="email1" />
											<select>
											<option>naver.com</option>
											<option>gmail.com</option>
											<option>daum.net</option>
											</select>
										</td>
										<td bgcolor="E6ECDE"  width="10%"  height=26 align=center bgcolor="ffffff" class=t1>연락처</td>
										<td  height=26 align=left bgcolor="ffffff" class=t1>
										&nbsp;&nbsp;
										<select>
											<option>010</option>
											<option>011</option>
											<option>012</option>
										</select>
										<input style="width:50px"  type="text">-<input style="width:70px" type="text"></td>
									</tr>
									
								</table>

								<br />
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;배송지정보</caption>

									<tr>
										<td bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>이름</td>
										<td height=26 align="center"  bgcolor="ffffff" class=t1 >
											<input type="text" style="width:50px"/>
										</td>
										<td bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>연락처1</td>
										<td height=26 align="center"  bgcolor="ffffff" class=t1 >
											<select>
												<option>선택</option>
												<option>010</option>
												<option>011</option>
												<option>012</option>
											</select>
											<input type="text" style="width:50px"/>-<input type="text" style="width:50px"/>
										</td>
										<td bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>연락처2</td>
										<td height=26 align="center"  bgcolor="ffffff" class=t1 >
											<select>
													<option>선택</option>
													<option>010</option>
													<option>011</option>
													<option>012</option>
												</select>
											<input type="text" style="width:50px" >-<input type="text" style="width:50px">
										</td>
									</tr>	
									<tr>
										<td bgcolor="E6ECDE"  height=26 align=center bgcolor="ffffff" class=t1 rowspan="4">주소</td>
										<td height=26 align=left bgcolor="ffffff" class=t1  colspan="5">
											&nbsp;&nbsp;
											<input type="button" value="배송지목록">
											<input type="radio">회사
											<input type="radio">자택
											<input type="radio">신규배송지
										</td>
									</tr>
									<tr>
										
										<td height=26 align=left bgcolor="ffffff" class=t1  colspan="5">
											&nbsp;&nbsp;<input type="text" style="width:50px" value="02832">
											&nbsp;&nbsp;<input type="button" value="우편번호찾기">
										</td>
									</tr>
									<tr>
										
										<td height=26 align=left bgcolor="ffffff" class=t1  colspan="5">
											&nbsp;&nbsp;<input type="text" style="width:180px" >&nbsp;&nbsp;[기본주소]<br>
										</td>
									</tr>
									<tr>
										
										<td height=26 align=left bgcolor="ffffff" class=t1  colspan="5">
											
											&nbsp;&nbsp;<input type="text" style="width:180px">&nbsp;&nbsp;[나머지주소]<br>
										</td>
									</tr>
									<tr>
										<td bgcolor="E6ECDE"   height=26 align=center bgcolor="ffffff" class=t1>주문메세지<br>(100자내외)</td>
										<td height=26 align=left bgcolor="ffffff" class=t1 colspan="5" style="padding-top: 5px">
											&nbsp;&nbsp;<textarea rows="3" cols="80" ></textarea>
										</td>
									</tr>
									
								</table>
								<br>
								<table align=center width=80% border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;적립금사용</caption>
									<tr>
										<td height=26 align="left"  bgcolor="ffffff" class=t1 colspan="3" >&nbsp;&nbsp;<input type="text" value="0">원<font color="red"> ←</font><input type="text" value="1440">원(사용가능 적립금)</td>
									</tr>	
									
									
								</table>
							</form>
							<br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp; <a
										href="javascript:order_create_form_submit();" class=m1>구매/결재하기</a>
										&nbsp;&nbsp;<a href=product_list.jsp class=m1>계속 쇼핑하기</a>

									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>