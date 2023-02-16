package com.itwill.product;

import java.util.List;

public interface ProductService {

	void setProductDao(ProductDao productDao);

	List<Product> productList();

	Product productDetail(int p_no);

}