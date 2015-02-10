package com.zhangyongcun.myclass;

import java.util.List;

public class User {
	
	private String u_name;
	private List<Order> orderList;
	
	
	
	
	
	
	public User() {
	}
	public User(String u_name, List<Order> orderList) {
		super();
		this.u_name = u_name;
		this.orderList = orderList;
	}
	
	
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
	
	
	
	
	
	
	
}
