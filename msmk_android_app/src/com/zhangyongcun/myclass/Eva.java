package com.zhangyongcun.myclass;

public class Eva {

	
	private String e_id;
	private String m_id;
	private String e_comment;
	
	
	
	
	public Eva(String e_id, String m_id, String e_comment) {
		this.e_id = e_id;
		this.m_id = m_id;
		this.e_comment = e_comment;
	}
	
	
	public Eva() {
		super();
	}


	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getE_comment() {
		return e_comment;
	}
	public void setE_comment(String e_comment) {
		this.e_comment = e_comment;
	}
	
	
	
}
