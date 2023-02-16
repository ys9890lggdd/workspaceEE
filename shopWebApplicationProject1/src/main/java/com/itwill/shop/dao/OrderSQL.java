package com.itwill.shop.dao;

public class OrderSQL {
	
	
	public static final String ORDER_SELECT_LIST_BY_USERID=
	"select * from orders where userid=?";
	public static final String ORDER_SELECT_BY_O_NO=
	"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product_furniture p on oi.p_no=p.p_no where o.userid=? and o.o_no = ?";
	
	public static final String ORDER_CREATE=
	"insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,?,sysdate,?,?)";
	public static final String ORDER_ITEM_CREATE=
	"insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,?,orders_o_no_SEQ.currval,?)";
	
	public static final String ORDER_DELETE_BY_USERID=
	"delete from orders where userid=?";
	public static final String ORDER_DELETE_BY_ORDER_NO=
	"delete from orders where o_no=?";

}
