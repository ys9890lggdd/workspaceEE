package com.itwill.shop.dao.test;
import com.itwill.shop.dao.UserDao;
public class UserDaoTestMain {
	public static void main(String[] args)throws Exception{
		UserDao userDao=new UserDao();
		System.out.println("userList:"+userDao.findUserList());
	}
}
