package com.zhangyongcun.msmk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhangyongcun.adapter.BusList;
import com.zhangyongcun.myclass.Business;
import com.zhangyongcun.unil.MyApplication;
import com.zhangyongcun.unil.MyData;

import info.androidhive.slidingmenu.R;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BusinessFragment extends Fragment {
	
	
	List<String> b_nameList = new ArrayList<String>(0);
	List<String> b_addressList = new ArrayList<String>(0);
	List<String> b_phoneList = new ArrayList<String>(0);
	List<String> b_otherList = new ArrayList<String>(0);
	
	FinalHttp fh = new FinalHttp();
	Handler handler;
	
	ListView bus_List;
	
	public BusinessFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_business, container, false);
        this.bus_List = (ListView) rootView.findViewById(R.id.bus_List);
      
      //handler消息机制开始------
        handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1://设置商家数据
					
					@SuppressWarnings("unchecked")
					final List<Business> busList = (List<Business>)msg.obj;
					MyApplication myApplication = ((MyApplication)getActivity().getApplication());
					myApplication.setBusList(busList);
					
					//myApplication.setDb(getActivity());
					//把从数据库获取到的meal表数据存入sqlite数据库
					//SqliteMeal sqliteMeal = new SqliteMeal(getActivity());
					//sqliteMeal.savaData();
					
					//存入list中数据中
					for (int i = 0; i < busList.size(); i++) {
				    	   b_nameList.add(busList.get(i).getB_name());
				    	   b_addressList.add(busList.get(i).getB_address());
				    	   b_phoneList.add(busList.get(i).getB_phone());
				    	   b_otherList.add(busList.get(i).getB_other());
				    }
					
					
					//转换
				    final int size = busList.size();
				    String[] b_names = (String[]) b_nameList.toArray(new String[size]);
				    String[] b_addresss = (String[]) b_addressList.toArray(new String[size]);
				    String[] b_phones = (String[]) b_phoneList.toArray(new String[size]);
				    String[] b_others = (String[]) b_otherList.toArray(new String[size]);
				    
				    BusList adapter = new BusList(getActivity(), b_names, b_addresss, b_phones, b_others);
				    
				    bus_List.setAdapter(adapter);
				    bus_List.setOnItemClickListener(new OnItemClickListener() {
				    	

						//监听List事件  跳转
						public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
							
							Intent it = new Intent();
							it.setClass(getActivity(), BusMealActivity.class);
							it.putExtra("position", position);
							getActivity().startActivity(it);
							
							
						}
					});
					
					
					
					break;

				
				}	
					
					
					
					
				
			}
			
			//handler结束
        
        };
        
      //-------------------------------
        //从服务器上获取数据
        //get请求服务器获取json字符串
		fh.get(MyData.Path+"bus/bus_list.php",new AjaxCallBack<Object>() {
			@Override
			public void onSuccess(Object t) {
				List<Business> busList;
				//JSON  对象转换为List
				Type listType = new TypeToken<List<Business>>(){}.getType();
				busList = new Gson().fromJson(t.toString(), listType);
		        Message msg = new Message();
		        msg.what = 1;
		        msg.obj = busList;
		        handler.sendMessage(msg);
		        
				
				
			}
		});
        //---------------------------------- 
        return rootView;
    }
	
	
}
