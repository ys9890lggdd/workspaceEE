package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.domain.Product;

public class ProductDao {
	private DataSource dataSource;

	
	public ProductDao() throws Exception {
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

	public ArrayList<Product> getProductList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from product_furniture";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			productList = new ArrayList<Product>();
			Product product = null;
			while (rs.next()) {
				product = new Product();
				product.setP_no(rs.getInt("p_no"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_desc(rs.getString("p_desc"));
				product.setP_image(rs.getString("p_image"));
				product.setP_click_count(rs.getInt("p_click_count"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return productList;
	}

	public Product getProduct(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from product_furniture where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setP_no(rs.getInt("p_no"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_desc(rs.getString("p_desc"));
				product.setP_image(rs.getString("p_image"));
				product.setP_click_count(rs.getInt("p_click_count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return product;
	}

	public boolean updateReadcount(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			con = dataSource.getConnection();
			String sql = "update product set p_click_count = p_click_count+1 where p_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			int count = pstmt.executeUpdate();

			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();

		}
		return result;
	}
}