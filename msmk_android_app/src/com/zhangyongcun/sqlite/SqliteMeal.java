package com.zhangyongcun.sqlite;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalDb;

import com.zhangyongcun.myclass.Meal;
import com.zhangyongcun.unil.MyApplication;

import android.app.Activity;

public class SqliteMeal {
	
	Activity activity;
	
	/**
	 * 构造方法
	 * @param activity 传递上下文对象
	 */
	public SqliteMeal(Activity activity) {
		this.activity = activity;
	}
	
	
	/**
	 * 将meal存入数据库中
	 */
	public void savaData(){
		
		
		
		
		MyApplication myApplication = (MyApplication)activity.getApplicationContext();
		List<Meal> mealList = myApplication.getMealsList();
		FinalDb db = myApplication.getDb();
		
		if (!(mealList.size() == db.findAll(Meal.class).size())) {
			for (int i= 0; i < mealList.size(); i++) {
				db.save(mealList.get(i));
			}
		}
		
		return ;
		
	}
	/**
	 * 根据用户订单的b_id list从sqlite中获取Meal的详情
	 * @param o_bidlist   order表中的b_id的list组合
	 * @return   返回该用户订单的Meal组合
	 */
	
	
	
	public List<Meal> getUserMealList(List<String> o_midList) {
		MyApplication myApplication = (MyApplication)activity.getApplicationContext();
		FinalDb db = myApplication.getDb();
		List<Meal> mealList = new ArrayList<Meal>(0);
		for (int i = 0; i < o_midList.size(); i++) {
			String strWhere = "m_id = \"" + o_midList.get(i).toString() + "\"";
			Meal meal = db.findAllByWhere(Meal.class, strWhere).get(0);
			mealList.add(meal);
		}
			
		
		return mealList;
	}
	
}
