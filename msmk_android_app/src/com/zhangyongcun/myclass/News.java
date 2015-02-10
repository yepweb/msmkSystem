package com.zhangyongcun.myclass;




public class News {
	
	
	
	private String  n_id;
	private String n_title;
	private String n_content;
	private String n_time;
	
	
	
	
	
	
	
	
	
	public News() {
		super();
	}
	public News(String n_id, String n_title, String n_content,
			String n_time) {
		super();
		this.n_id = n_id;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_time = n_time;
	}
	@Override
	public String toString() {
		return "News [ n_id=" + n_id + ", n_title=" + n_title
				+ ", n_content=" + n_content + ", n_time=" + n_time + "]";
	}
	
	public String getN_id() {
		return n_id;
	}
	public void setN_id(String n_id) {
		this.n_id = n_id;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_time() {
		return n_time;
	}
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	
	

	

	
	

	
	
	
	
	
}
