<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 /*
	  5.List<Guest> 리스트 출력
	  */
	List<Guest> guestList=(List<Guest>)request.getAttribute("guestList");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/guest.css">
<script type="text/javascript" src="js/guest.js"></script>

</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp"/>

			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>


			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper content start -->
		<div id="wrapper">
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리
											- 리스트</b></td>
								</tr>
							</table>
							<form name="f" method="post">

								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=50 align=center bgcolor="E6ECDE" height="22">번호</td>
										<td width=300 align=center bgcolor="E6ECDE">제목</td>
										<td width=120 align=center bgcolor="E6ECDE">이름</td>
										<td width=120 align=center bgcolor="E6ECDE">날짜</td>
									</tr>
									<%for(Guest guest:guestList){ %>
									<!-- guest start -->
									<tr>
										<td width=50 align=center bgcolor="ffffff" height="20"><%=guest.getGuest_no()%></td>
										<td width=300 bgcolor="ffffff" style="padding-left: 10">
										<a href="guest_view.do?guest_no=<%=guest.getGuest_no()%>" class="user"><%=guest.getGuest_title()%> </a></td>
										<td width=120 align=center bgcolor="ffffff"><%=guest.getGuest_name() %></td>
										<td width=120 align=center bgcolor="ffffff"><%=guest.getGuest_date().substring(0,10) %></td>
									</tr>
									<!-- guest end -->	
									<% }%>
								</table>
							</form>  <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="right"><input type="button"
										onclick="guestCreateForm();" value="방명록 쓰기" /></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
		</div>
		<!-- wrapper content end-->
		<!-- footer start-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>

			<!-- include_common_bottom.jsp end-->
		</div>
		<!-- footer end -->
	</div>
	<!--container end-->
</body>
</html>
