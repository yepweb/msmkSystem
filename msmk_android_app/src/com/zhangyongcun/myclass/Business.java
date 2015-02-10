package com.zhangyongcun.myclass;

public class Business {
	
	private String b_id;
	private String b_bo;
	private String b_name;
	private String b_address;
	private String b_phone;
	private String b_other;
	
	
	
	public Business() {
		super();
	}
	public Business(String b_id, String b_bo, String b_name, String b_address,
			String b_phone, String b_other) {
		super();
		this.b_id = b_id;
		this.b_bo = b_bo;
		this.b_name = b_name;
		this.b_address = b_address;
		this.b_phone = b_phone;
		this.b_other = b_other;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_bo() {
		return b_bo;
	}
	public void setB_bo(String b_bo) {
		this.b_bo = b_bo;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_address() {
		return b_address;
	}
	public void setB_address(String b_address) {
		this.b_address = b_address;
	}
	public String getB_phone() {
		return b_phone;
	}
	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}
	public String getB_other() {
		return b_other;
	}
	public void setB_other(String b_other) {
		this.b_other = b_other;
	}
	
	
	
}
