package com.itwill.shop.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.common.DataSourceFactory;

/*
쇼핑몰에서 상품테이블과의 데이타베이스와의 작업을 전담하는 클래스
PRODUCT 테이블에 제품 검색 등의 작업을한다.
*/
public class ProductDao {
	private DataSource dataSource;
	public ProductDao() throws Exception {
		dataSource=DataSourceFactory.getDataSource();
	}
	
	
	
	
	/*
	 * selelctByPK : 상품번호로 검색
	 */
	public Product findByPrimaryKey(int p_no) throws Exception {
		Product product = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_BY_NO);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"),
						rs.getString("p_image"), rs.getString("p_desc"), rs.getInt("p_click_count"));
			}

		} finally {
			if (con != null) {
				con.close();
			}
		}
		return product;
	}

	/*
	 * selectAll : 상품전체검색
	 */
	public List<Product> findAll() throws Exception {
		List<Product> productList = new ArrayList<Product>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.PRODUCT_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getInt("p_price"),
						rs.getString("p_image"), rs.getString("p_desc"), rs.getInt("p_click_count"));
				productList.add(product);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return productList;
	}
}
