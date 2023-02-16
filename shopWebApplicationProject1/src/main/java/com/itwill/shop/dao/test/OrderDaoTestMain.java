package com.itwill.shop.dao.test;

import com.itwill.shop.dao.OrderDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception{
		OrderDao orderDao=new OrderDao();
		//System.out.println(orderDao.list("guard1"));
		System.out.println(orderDao.detail("guard1", 6));
		//System.out.println(orderDao.detail("guard1", 7));
		
	}

}
