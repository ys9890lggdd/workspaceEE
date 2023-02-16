package com.itwill.shop.dao.test;

import com.itwill.shop.dao.CartDao;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception{
		CartDao cartDao=new CartDao();
		System.out.println(cartDao.getCartList("guard1"));

	}

}
