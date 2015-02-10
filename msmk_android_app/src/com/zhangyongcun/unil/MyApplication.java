package com.zhangyongcun.unil;

import java.util.List;

import net.tsz.afinal.FinalDb;

import android.app.Activity;
import android.app.Application;

import com.zhangyongcun.myclass.Business;
import com.zhangyongcun.myclass.Meal;
import com.zhangyongcun.myclass.News;
import com.zhangyongcun.myclass.User;

public class MyApplication extends Application {
	
	private List<News> newsList;//存放服务器news列表
	private List<Meal> mealsList;//存放服务器的meal列表
	private User user;//当前登录的用户名，该用户对应的订单
	private FinalDb db;//数据库全局变量
	private List<Business> busList;
	
	
	
	
	
	

	public List<Business> getBusList() {
		return busList;
	}

	public void setBusList(List<Business> busList) {
		this.busList = busList;
	}

	public FinalDb getDb() {
		return db;
	}

	public void setDb(Activity activity) {
		this.db = FinalDb.create(activity);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Meal> getMealsList() {
		return mealsList;
	}

	public void setMealsList(List<Meal> mealsList) {
		this.mealsList = mealsList;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	
	
}
