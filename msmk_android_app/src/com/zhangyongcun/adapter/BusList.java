package com.zhangyongcun.adapter;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BusList extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] b_names;
	private final String[] b_addresss;
	private final String[] b_phones;
	private final String[] b_others;
	
	
	
	public BusList(Activity context,String[] b_names, String[] b_addresss,String[] b_phones,String[] b_others) {
		super(context, R.layout.list_meal, b_names);
		this.context = context;
		this.b_names = b_names;
		this.b_addresss = b_addresss;
		this.b_phones = b_phones;
		this.b_others = b_others;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_business, null,true);
		
		TextView b_name = (TextView)rowView.findViewById(R.id.b_name);
		TextView b_address = (TextView)rowView.findViewById(R.id.b_address);
		TextView b_phone = (TextView)rowView.findViewById(R.id.b_phone);
		TextView b_other = (TextView)rowView.findViewById(R.id.b_other);
		
		//…Ë÷√m_name
		b_name.setText(b_names[position]);
		b_address.setText(b_addresss[position]);
		b_phone.setText(b_phones[position]);
		b_other.setText(b_others[position]);
		
		
		return rowView;
	}
	
}
