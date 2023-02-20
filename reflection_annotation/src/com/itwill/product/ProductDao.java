package com.itwill.product;

import java.util.List;

public interface ProductDao {

	List<Product> productList();

	Product productDetail(int p_no);

}