package com.itwill.shop.service;



import java.util.ArrayList;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.dao.OrderDao;
import com.itwill.shop.dao.ProductDao;
import com.itwill.shop.domain.CartItem;
import com.itwill.shop.domain.Order;
import com.itwill.shop.domain.OrderItem;
import com.itwill.shop.domain.Product;


public class OrderService {
	private OrderDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao;
	public OrderService() throws Exception{
		orderDao=new OrderDao();
		productDao=new ProductDao();
		cartDao=new CartDao();
	}
	/*
	 * 주문1개삭제
	 */
	public int deleteByOrderNo(int o_no)throws Exception{
		return orderDao.deleteByOrderNo(o_no);
	}
	/*
	 * 주문전체삭제
	 */
	public int delete(String sUserId)throws Exception{
		return orderDao.delete(sUserId);
	}
	/*
	 * 주문목록
	 */
	public ArrayList<Order> list(String sUserId) throws Exception{
		return orderDao.list(sUserId);
	}
	/*
	 * 주문상세보기
	 */
	public Order detail(String sUserId,int o_no)throws Exception{
		return orderDao.detail(sUserId,o_no);
	}
	/*
	 * 상품에서 직접주문
	 */
	public int create(String sUserId,int p_no,int oi_qty) throws Exception{
		Product product=productDao.getProduct(p_no);
		OrderItem orderItem=new OrderItem(0, oi_qty, p_no, product);
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		orderItemList.add(orderItem);
		Order newOrder=
				new Order(0,
						orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_qty-1)+" 개", 
						null,
						orderItemList.get(0).getOi_qty()*orderItemList.get(0).getProduct().getP_price(),
						sUserId,
						orderItemList);
		return orderDao.create(newOrder);
	}
	
	/*
	 * cart에서 주문
	 * cart에있는모든상품을 주문
	 */
	public int create(String sUserId) throws Exception{
		ArrayList<CartItem> cartItemList=cartDao.getCartList(sUserId);
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		int o_tot_price=0;
		int oi_tot_count=0;
		for (CartItem cartItem : cartItemList) {
			OrderItem orderItem=new OrderItem(0,cartItem.getCart_qty(),0, cartItem.getProduct());
			orderItemList.add(orderItem);
			o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			oi_tot_count+=orderItem.getOi_qty();
		}
		String o_desc = orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+" 개";
		Order newOrder=new Order(0,o_desc, null, o_tot_price, sUserId,orderItemList);
		orderDao.create(newOrder);
		cartDao.deleteCart(sUserId);
		return 0;
	}
	/*
	 * cart에서 선택주문
	 */
	public int create(String sUserId,String[] cart_item_noStr_array) throws Exception{
		
		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		int o_tot_price=0;
		int oi_tot_count=0;
		for(int i =0;i<cart_item_noStr_array.length;i++) {
			CartItem  cartItem = cartDao.getCartItemByCartNo(Integer.parseInt(cart_item_noStr_array[i]));
			OrderItem orderItem=new OrderItem(0, cartItem.getCart_qty(),0,cartItem.getProduct());
			orderItemList.add(orderItem);
			o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			oi_tot_count+=orderItem.getOi_qty();
		}
		String o_desc = orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+" 개";
		Order newOrder=new Order(0,o_desc, null, o_tot_price, sUserId,orderItemList);
		orderDao.create(newOrder);
		for(int i =0;i<cart_item_noStr_array.length;i++) {
			cartDao.deleteCartByNo(Integer.parseInt(cart_item_noStr_array[i]));
		}
		return 0;
	}
}













