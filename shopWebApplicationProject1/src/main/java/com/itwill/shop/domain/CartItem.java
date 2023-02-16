package com.itwill.shop.domain;
/*
이름       널?       유형           
-------- -------- ------------ 
CART_NO  NOT NULL NUMBER(10)   
CART_QTY          NUMBER(10)   
P_NO              NUMBER(10)   
USERID            VARCHAR2(50) 
 */
public class CartItem {
	private int cart_no;
	private int cart_qty;
	
	//private int p_no;//FK
	/****Product********/
	private Product product;
	
	//private String userId;//FK
	/*****User**********/
	private User user;
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(int cart_no, int cart_qty, Product product, User user) {
		super();
		this.cart_no = cart_no;
		this.cart_qty = cart_qty;
		this.product = product;
		this.user = user;
	}
	@Override
	public String toString() {
		return "CartItem [cart_no=" + cart_no + ", cart_qty=" + cart_qty + ", product=" + product + ", user=" + user
				+ "]";
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
