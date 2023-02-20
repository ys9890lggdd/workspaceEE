package com.itwill.product;

public class Product {
	private int p_no;
	private String p_name;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int p_no, String p_name) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + "]";
	}
	
}
