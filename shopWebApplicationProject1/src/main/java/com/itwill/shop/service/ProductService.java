package com.itwill.shop.service;



import java.util.ArrayList;

import com.itwill.shop.dao.ProductDao;
import com.itwill.shop.domain.Product;

public class ProductService {
	private ProductDao productDao;

	public ProductService() throws Exception {
		productDao = new ProductDao();
	}

	/*
	 * DogProduct 리스트반환
	 */
	public ArrayList<Product> getProductList() throws Exception {
		ArrayList<Product> productList = productDao.getProductList();
		return productList;
	}

	/*
	 * DogProduct 1개반환
	 */
	public Product getProduct(int p_no) throws Exception {
		Product product = productDao.getProduct(p_no);
		return product;
	}
	
	public boolean updateReadcount(int p_no) throws Exception {
		boolean result = false;
		result = productDao.updateReadcount(p_no);
		return result;
	}
	
}
