package com.zhangyongcun.adapter;

 import com.zhangyongcun.unil.MyData;

import net.tsz.afinal.FinalBitmap;
import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MealList extends ArrayAdapter<String> {
	
	private final Activity context;
	private final String[] m_names;
	private final String[] imagePaths;
	
	private FinalBitmap mFinalBitmp ;
	
	
	public MealList(Activity context,String[] m_names, String[] imagePaths) {
		super(context, R.layout.list_meal, m_names);
		this.context = context;
		this.m_names = m_names;
		this.imagePaths = imagePaths;
		
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_meal, null,true);
		
		TextView m_name = (TextView)rowView.findViewById(R.id.m_name);
		ImageView m_img = (ImageView)rowView.findViewById(R.id.m_img);
		
		//设置图片
		this.mFinalBitmp = FinalBitmap.create(context);//初始化FinalBitmap组件 
		mFinalBitmp.display(m_img , MyData.Path+ imagePaths[position]);//url为定义好的地址
		//设置m_name
		m_name.setText(m_names[position]);
		
		
		
		return rowView;
	}
	
	

}
