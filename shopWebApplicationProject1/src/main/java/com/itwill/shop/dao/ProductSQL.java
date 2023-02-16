package com.itwill.shop.dao;

public class ProductSQL {
	
	
	public static final String PRODUCT_SELECT_LIST=
			"select * from product_furniture";
	public static final String PRODUCT_SELECT_BY_P_NO=
			"select * from cart c join product_furniture p on c.p_no=p.p_no where cart_no=?";
	
	
	
	
	

}
