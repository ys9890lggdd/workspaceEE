package com.itwill.product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductServiceImpl() {
		//productDao=new ProductDaoImpl();
	}
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao=productDao;
	}
	@Override
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	public List<Product> productList(){
		return productDao.productList();
	}
	@Override
	public Product productDetail(int p_no) {
		return productDao.productDetail(p_no);
	}
}
