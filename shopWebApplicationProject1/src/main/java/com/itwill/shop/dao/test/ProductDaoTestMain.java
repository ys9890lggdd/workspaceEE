package com.itwill.shop.dao.test;

import com.itwill.shop.dao.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args)throws Exception  {
		ProductDao productDao=new ProductDao();
		System.out.println(productDao.getProductList());

	}

}
