package com.itwill.exercises;
@Service(value = "orderService")
public class OrderServiceImpl {
	@AutoWire
	@Qualifier("orderDao")
	private OrderDaoIml orderDaoIml;
	
	public OrderServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@AutoWire
	public OrderServiceImpl(@Qualifier(value = "orderDao") OrderDaoIml orderDaoIml) {
		super();
		this.orderDaoIml = orderDaoIml;
	}

	public OrderDaoIml getOrderDaoIml() {
		return orderDaoIml;
	}
	@AutoWire(value = "orderDao")
	public void setOrderDaoIml(OrderDaoIml orderDaoIml) {
		this.orderDaoIml = orderDaoIml;
	}
	
	
}
