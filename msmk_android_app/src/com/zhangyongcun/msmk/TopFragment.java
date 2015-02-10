package com.zhangyongcun.msmk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhangyongcun.adapter.MealList;
import com.zhangyongcun.myclass.Meal;
import com.zhangyongcun.unil.MyApplication;
import com.zhangyongcun.unil.MyData;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
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

public class TopFragment extends Fragment {
	
	FinalHttp fh = new FinalHttp();
	protected static final int CHINGUI = 1;
	private Handler handler;
	
	List<String> m_nameList = new ArrayList<String>(0);
	List<String> m_imgList = new ArrayList<String>(0);
	
	ListView list;
	
	public TopFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
         
        list = (ListView)rootView.findViewById(R.id.list);
        
        //handler消息机制开始------
          handler = new Handler(){

  			@Override
  			public void handleMessage(Message msg) {
  				if(msg.what == CHINGUI) {
  					@SuppressWarnings("unchecked")
  					final List<Meal> mealList = (List<Meal>)msg.obj;
  					MyApplication myApplication = ((MyApplication)getActivity().getApplication());
  					myApplication.setMealsList(mealList);
  					
  					//myApplication.setDb(getActivity());
  					//把从数据库获取到的meal表数据存入sqlite数据库
  					//SqliteMeal sqliteMeal = new SqliteMeal(getActivity());
  					//sqliteMeal.savaData();
  					
  					//存入list中数据中
  					for (int i = 0; i < mealList.size(); i++) {
  				    	   m_nameList.add(mealList.get(i).getM_name());
  				    	   m_imgList.add(mealList.get(i).getM_img());
  				    }
  					
  					
  					//转换
  				    final int size = mealList.size();
  				    String[] m_name = (String[]) m_nameList.toArray(new String[size]);
  				    String[] m_img = (String[]) m_imgList.toArray(new String[size]);
  				    
  				    MealList adapter = new MealList(getActivity(), m_name, m_img);
  				    
  				    list.setAdapter(adapter);
  				    list.setOnItemClickListener(new OnItemClickListener() {
  				    	

  						//监听List事件  跳转
  						public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  							
  							Intent it = new Intent();
  							it.setClass(getActivity(), MealActivity.class);
  							it.putExtra("position", position);
  							getActivity().startActivity(it);
  							
  							
  						}
  					});
  					
  					
  					
  					
  					
  				}
  			}
  			
  			//handler结束
          	
          };
          
        //-------------------------------
          //从服务器上获取数据
          //get请求服务器获取json字符串
  		fh.get(MyData.Path+"eva/eva_zan_top.php",new AjaxCallBack<Object>() {
  			@Override
  			public void onSuccess(Object t) {
  				List<Meal> mealList;
  				//JSON  对象转换为List
  				Type listType = new TypeToken<List<Meal>>(){}.getType();
  				mealList = new Gson().fromJson(t.toString(), listType);
  		        Message msg = new Message();
  		        msg.what = CHINGUI;
  		        msg.obj = mealList;
  		        handler.sendMessage(msg);
  		        
  				
  				
  			}
  		});
          //----------------------------------
        
        return rootView;
    }
}
