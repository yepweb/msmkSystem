package com.zhangyongcun.myclass;

import net.tsz.afinal.annotation.sqlite.Id;

public class Meal {
	@Id private String  m_id;
	private String m_name;
	private String b_id;
	private String m_price;
	private String m_other;
	private String m_img;
	
	
	//构造方法
	
	
	
	
	//get和set方法
	public String getM_id() {
		return m_id;
	}
	public Meal(String m_id, String m_name, String b_id, String m_price,
			String m_other, String m_img) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.b_id = b_id;
		this.m_price = m_price;
		this.m_other = m_other;
		this.m_img = m_img;
	}
	
	public Meal () {
		
	}
	
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getM_price() {
		return m_price;
	}
	public void setM_price(String m_price) {
		this.m_price = m_price;
	}
	public String getM_other() {
		return m_other;
	}
	public void setM_other(String m_other) {
		this.m_other = m_other;
	}
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	
	
	

	
}
