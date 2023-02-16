package com.itwill.shop.cart;

public class CartSQL {
	
	
	public static final String CART_SELECT_LIST_BY_USERID=
			"select * from cart c join userinfo u on c.userid=u.userid join product_toy p on p.p_no=c.p_no where u.userid=?";
	public static final String CART_SELECT_BY_CART_NO=
			"select * from cart c join product_toy p on c.p_no=p.p_no where cart_no=?";
	
	
	public static final String CART_IS_PRODUCT_EXIST=
			"select count(*)  as p_count from cart c join userinfo u on c.userid=u.userid where u.userid=? and c.p_no=?";
	public static final String CART_ADD=
	"insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,?,?,?)";
	public static final String CART_ADD_UPDATE=
			"update cart set cart_qty=cart_qty + ? where userid=? and p_no=?";
	public static final String CART_UPDATE=
			"update cart set cart_qty=? where cart_no=?";
	
	public static final String CART_DELETE_BY_CART_NO=
			"delete from cart where cart_no=?";
	public static final String CART_DELETE_BY_USERID=
			"delete from cart where userid=?";
	
	

}
