package com.itwill.shop.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.domain.Order;
import com.itwill.shop.domain.OrderItem;
import com.itwill.shop.domain.Product;


public class OrderDao {
	
	private DataSource dataSource;
	public OrderDao() throws Exception {
		/******Apache BasicDataSource*****/
		BasicDataSource basicDataSource=new BasicDataSource();
		/*
		 * jdbc.properties 파일을 Properties객체로생성
		 */
		Properties properties=new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		this.dataSource = basicDataSource;
	}
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	public int delete(String sUserId)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			rowCount = pstmt.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
	}
	/*
	 * 주문1건삭제
	 */
	/*
	public int delete(int j_no)throws Exception{
		String deleteSql1="delete from order_item where o_no=?";
		String deleteSql2="delete from orders where o_no=?";
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(deleteSql1);
			pstmt2=con.prepareStatement(deleteSql2);
			pstmt1.setInt(1, j_no);
			pstmt2.setInt(1, j_no);
			int rowCount1 = pstmt1.executeUpdate();
			int rowCount2 = pstmt2.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}
	*/
	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	public int deleteByOrderNo(int o_no)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(OrderSQL.ORDER_DELETE_BY_ORDER_NO);
			pstmt.setInt(1, o_no);
			rowCount= pstmt.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
	}
	/*
	 * 주문생성
	 */
	public int create(Order order) throws Exception{
		/*
		insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'비글외1종',sysdate-2,1050000,'guard1');
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
		*/
		
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=dataSource.getConnection();
			/*
			 * transaction 시작
			 */
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(OrderSQL.ORDER_CREATE);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_price());
			pstmt1.setString(3, order.getUserId());
			pstmt1.executeUpdate();
			
			pstmt2=con.prepareStatement(OrderSQL.ORDER_ITEM_CREATE);
			for(OrderItem orderItem:order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			/*
			 * transaction 끝 성공 commit
			 */
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			/*
			 * transaction 끝 실패 rollback
			 */
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}
	
	
	/*
	 * 주문전체(특정사용자)
	 */
	public ArrayList<Order> list(String sUserId) throws Exception{
		ArrayList<Order> orderList=new ArrayList<Order>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(OrderSQL.ORDER_SELECT_LIST_BY_USERID);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("o_no"),
										rs.getString("o_desc"),
								       rs.getDate("o_date"),
								       rs.getInt("o_price"),
								       rs.getString("userid"),
								       null));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return orderList;
	}
	/*
	 * 주문1개보기(주문상세리스트)
	 */
	public Order detail(String sUserId,int o_no)throws Exception{
		/*
		select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.userid=? and o.o_no = ?
		
		6	비글외 6 개	2022/02/22	3400000	guard1	10	4	6	1	1	비글	550000	bigle.png	귀여워요...	0
		6	비글외 6 개	2022/02/22	3400000	guard1	11	3	6	3	3	퍼그	400000	pug.jpg	예뻐요	0
		
		 */
		Order order =null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(OrderSQL.ORDER_SELECT_BY_O_NO);
		pstmt.setString(1, sUserId);
		pstmt.setInt(2, o_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			order=new Order(rs.getInt("o_no"),
							rs.getString("o_desc"),
							rs.getDate("o_date"),
							rs.getInt("o_price"),
							rs.getString("userId"),
							null
						  );
			
			
			List<OrderItem> tempOrderItemList=new ArrayList<OrderItem>();
			do {
				tempOrderItemList.add(new OrderItem(rs.getInt("oi_no"),
													rs.getInt("oi_qty"),
													rs.getInt("o_no"),
													new Product(rs.getInt("p_no"),
															    rs.getString("p_name"),
															    rs.getInt("p_price"),
															    rs.getString("p_image"),
															    rs.getString("p_desc"),
															    rs.getInt("p_click_count"))));
				
			}while(rs.next());
			order.setOrderItemList(tempOrderItemList);
		}
		
		return order;
	}
	
	
}
