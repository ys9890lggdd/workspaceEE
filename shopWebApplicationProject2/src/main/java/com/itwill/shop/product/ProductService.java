package com.itwill.shop.product;


import java.util.List;

public class ProductService {
	private ProductDao productDao;

	public ProductService() throws Exception {
		productDao = new ProductDao();
	}

	/*
	 * DogProduct 리스트반환
	 */
	public List<Product> selectAll() throws Exception {
		List<Product> productList = productDao.selectAll();
	
		return productList;
	}

	/*
	 * DogProduct 1개반환
	 */
	public Product selectByNo(int p_no) throws Exception {
		Product product = productDao.selectByNo(p_no);
		return product;
	}
	
}
