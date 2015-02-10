package com.zhangyongcun.adapter;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsList extends ArrayAdapter<String> {
	
	private final Activity context;
	private final String[] n_id;
	private final String[] n_title;
	
	public NewsList(Activity context,String[] n_id ,String[] n_title) {
		
		super(context, R.layout.list_news,n_title);
		this.context = context;
		this.n_id = n_id;
		this.n_title = n_title;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = context.getLayoutInflater();
		View newsRow = inflater.inflate(R.layout.list_news,null,true);
		
		TextView n_idV = (TextView)newsRow.findViewById(R.id.n_id);
		TextView n_titleV = (TextView)newsRow.findViewById(R.id.n_title);
		n_idV.setText(n_id[position]);
		n_titleV.setText(n_title[position]);
		
		
		return newsRow;
	}

	
	
	
	
}
