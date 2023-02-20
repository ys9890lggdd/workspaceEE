package com.itwill.product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
	
	@Override
	public List<Product> productList(){
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1,"새우깡"));
		productList.add(new Product(2,"감자깡"));
		productList.add(new Product(3,"양파링"));
		productList.add(new Product(4,"옥수수깡"));
		return productList;
	}
	
	@Override
	public Product productDetail(int p_no) {
		return new Product(p_no, "허니버터칩");
	}
}
