package com.zhangyongcun.msmk;


import java.util.List;


import com.zhangyongcun.myclass.News;
import com.zhangyongcun.unil.MyApplication;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewsActivity extends Activity {
	
	private TextView title;
	private TextView time;
	private TextView content;
	private List<News> newsList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_news_con);
		 
		this.title = (TextView) super.findViewById(R.id.title);
		this.time = (TextView) super.findViewById(R.id.time);
		this.content = (TextView) super.findViewById(R.id.con);
		
		Intent it = getIntent();
		int id = it.getIntExtra("pos",0);
		MyApplication myApplication =  (MyApplication)getApplication();
		newsList = myApplication.getNewsList();
		
		
		this.title.setText( newsList.get(id).getN_title().toString());
		this.time.setText(newsList.get(id).getN_time());
		this.content.setText( newsList.get(id).getN_content());
		
	}
	
}
