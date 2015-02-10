package com.zhangyongcun.msmk;

import info.androidhive.slidingmenu.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhangyongcun.myclass.Eva;
import com.zhangyongcun.myclass.Meal;
import com.zhangyongcun.unil.MyApplication;
import com.zhangyongcun.unil.MyData;

public class MealActivity extends Activity {

	private TextView m_name;
	private TextView b_name;
	private TextView m_price;
	private TextView m_other;
	private ImageView m_img;
	private TextView m_zan;
	private TextView m_cai;
	private EditText m_comment;//用户的评论内容
	private ListView list;//评论的列表
	private String m_id;
	
	
	private FinalBitmap mFinalBitmp ;
	private List<Meal> mealList;
	
	int position ;
	
	
	private Handler handler;
	FinalHttp fh = new FinalHttp();
	
	private static final String PATH = MyData.Path + "bus/bus_b_name.php";
	private static final String PATH2 = MyData.Path + "eva/zan_cai_list.php";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_meal_info);
		
		this.m_name = (TextView) super.findViewById(R.id.m_name); 
		this.b_name = (TextView) super.findViewById(R.id.b_name); 
		this.m_price = (TextView) super.findViewById(R.id.m_price); 
		this.m_other = (TextView) super.findViewById(R.id.m_other); 
		this.m_img = (ImageView) super.findViewById(R.id.m_img); 
		this.m_zan = (TextView) super.findViewById(R.id.m_zan);
		this.m_cai = (TextView) super.findViewById(R.id.m_cai);
		this.m_comment = (EditText) super.findViewById(R.id.m_comment);
		this.list = (ListView)super.findViewById(R.id.evaList); 
		
		
		Intent it = MealActivity.this.getIntent();
		position = it.getIntExtra("position",0);
		
				
		
		MyApplication myApplication = (MyApplication)getApplication();
		this.mealList = myApplication.getMealsList();
		
		this.m_id = mealList.get(position).getM_id().toString();
		
		this.m_name.setText(mealList.get(position).getM_name().toString());
		this.m_price.setText(mealList.get(position).getM_price().toString());
		this.m_other.setText(mealList.get(position).getM_other().toString());
		this .mFinalBitmp = FinalBitmap . create( this);//初始化FinalBitmap 
		mFinalBitmp.display(m_img ,MyData.Path + mealList.get(position).getM_img());//url为定义好的地址
		
		 handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1://设置商家名字
					String b_name = (String)msg.obj;
		            MealActivity.this.b_name.setText(b_name);
					break;
				case 2://设置赞和踩
					String[] zc = (String[])msg.obj;
					MealActivity.this.m_zan.setText(zc[0]);
					MealActivity.this.m_cai.setText(zc[1]);
					break;
				case 3:
					String[] e_commentList = (String[]) msg.obj;
					
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(MealActivity.this, 
							                       android.R.layout.simple_list_item_1,e_commentList);
					MealActivity.this.list.setAdapter(adapter);
					break;
				case 4 ://订单是否成功
					String isOk = (String)msg.obj;
					if (isOk.equals("ture")) {
						Toast.makeText(MealActivity.this, "购买成功！", Toast.LENGTH_LONG).show();
					}else {
						Toast.makeText(MealActivity.this, "对不起，订单失败！", Toast.LENGTH_LONG).show();
					}
					break;
				case 5://赞和踩增加1
					String iszc = (String)msg.obj;
					if(iszc.equals("zan")) {
						int temp = Integer.parseInt(MealActivity.this.m_zan.getText().toString());
						temp++;
						MealActivity.this.m_zan.setText(Integer.toString(temp));
					}else {
						int temp = Integer.parseInt(MealActivity.this.m_cai.getText().toString());
						temp++;
						MealActivity.this.m_cai.setText(Integer.toString(temp));
					}
					
					break;
					
				
	
				}
				

				
				
			}
			
		};
		//根据b_id 获取商家名字
		
		AjaxParams params = new AjaxParams();
		params.put("b_id", mealList.get(position).getB_id());
		
		FinalHttp fh = new FinalHttp();
		fh.post(PATH, params,new AjaxCallBack<Object>() {


			@Override
			public void onSuccess(Object t) {
				
				String b_name = null;
				
				try {
					JSONArray arr = new JSONArray(t.toString());
					    JSONObject temp = (JSONObject) arr.get(0);  
					    b_name = temp.getString("b_name");  
				} catch (Exception e) {
					e.printStackTrace();
				}
				Message msg = new Message();
				msg.what = 1;
			    msg.obj = b_name;
			    handler.sendMessage(msg);
				
				
			
			}
			
		});
		
		//根据m_id 获取赞和踩
		AjaxParams params2 = new AjaxParams();
		params2.put("m_id", mealList.get(position).getM_id());
		
		FinalHttp fh2 = new FinalHttp();
		fh2.post(PATH2, params2,new AjaxCallBack<Object>() {


			@Override
			public void onSuccess(Object t) {
				String m_zan = null;
				String m_cai = null;
				try {
					JSONArray arr = new JSONArray(t.toString());
					JSONObject temp = (JSONObject) arr.get(0);  
					m_zan = temp.getString("z_zan");  
					m_cai = temp.getString("z_cai"); 
					    
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String[] zc = new String[]{m_zan,m_cai};
				
				Message msg = new Message();
				msg.what = 2;
			    msg.obj = zc;
			    handler.sendMessage(msg);
			}
			
		});
	
		//根据m_id获取评论
		FinalHttp fh_eva = new FinalHttp();
		AjaxParams params_eva = new AjaxParams();
		params_eva.put("m_id",m_id);
		fh_eva.post(MyData.Path + "eva/evaluate_list.php", params_eva,new AjaxCallBack<Object>() {

			@Override
			public void onSuccess(Object t) {
				Message msg = new Message();
				msg.what = 3;
				if (t.toString()=="") {//没有评论的情况
					
				}else {
					List<Eva> evaList;
					//JSON 对象转换为List
					Type listType = new TypeToken<List<Eva>>(){}.getType();
					evaList = new Gson().fromJson(t.toString(), listType);
					List<String> evaL = new ArrayList<String>(0);
					
					for (int i = 0; i < evaList.size(); i++) {
						evaL.add(evaList.get(i).getE_comment());
					}
					//转换
				
				    String[] e_commentList = (String[])evaL.toArray(new String[evaList.size()]);
					
					msg.obj = e_commentList;
					handler.sendMessage(msg);
				}
				
			}
			
			
		});
		//请求结束
		
		
	}
	
	//监听购买按钮事件
	public void buyOnClick(View view) {
		SharedPreferences pref = MealActivity.this.getPreferences(0);//从Activity对象中获取
		String u_name = pref.getString("name","");
		if ((u_name=="")) {
			
			postBuy(u_name);
			
		}else {
			Toast.makeText(MealActivity.this, "当前未登录，请登录后再操作！", Toast.LENGTH_LONG).show();
		}
		
		
	}
	//监听评论按钮事件
	public void evaOnClick(View view) {
		SharedPreferences pref = MealActivity.this.getPreferences(0);//从Activity对象中获取
		String u_name = pref.getString("name", "");
		if (u_name.equals("")) {
			String m_comment = MealActivity.this.m_comment.getText().toString().trim();
			if (!m_comment.equals("")) { 
				AjaxParams paramEva = new AjaxParams();
				paramEva.put("m_id", m_id);
				paramEva.put("e_comment",MealActivity.this.m_comment.getText().toString().trim());
				
				FinalHttp fh_eva = new FinalHttp();
				fh_eva.post(MyData.Path + "eva/eva_com_add.php", paramEva,new AjaxCallBack<Object>() {

					@Override
					public void onSuccess(Object t) {
						Toast.makeText(MealActivity.this, "评论成功", Toast.LENGTH_LONG).show();
						//实现listview刷新效果,此方法尚且需要修改
						Intent it = new Intent(MealActivity.this,MealActivity.class);
						it.putExtra("position",position);
						
						MealActivity.this.startActivity(it);
						MealActivity.this.finish();
						
					}
					
				});
				
				
			}else {
				Toast.makeText(MealActivity.this, "你还没有输入评论内容！", Toast.LENGTH_LONG).show();
			}
			
			
		}else {
			Toast.makeText(MealActivity.this, "当前未登录，请登录后再操作！", Toast.LENGTH_LONG).show();
		}
		
		
		
		
		
	}
	
	/**
	 * 想服务器提交订单
	 * @param u_name
	 * @return
	 */
	public void postBuy(String u_name){
		AjaxParams params = new AjaxParams();
		params.put("u_name", u_name);
		params.put("m_id", m_id);
		FinalHttp fh_buy = new FinalHttp();
		fh_buy.post(MyData.Path + "ord/order_add.php", params,new AjaxCallBack<Object>() {

			@Override
			public void onSuccess(Object t) {
				Message msg = new Message();
				msg.what = 4;
				if (t.toString().equals("订单成功")) {
					msg.obj = "ture";
					handler.sendMessage(msg);
				}else {
					msg.obj = "fales";
					handler.sendMessage(msg);
				}
			}
			
			
			
		});
	}
	//监听赞
	public void zan(View v) {
		AjaxParams params = new AjaxParams();
		params.put("m_id", m_id);
		FinalHttp fh = new FinalHttp();
		fh.post(MyData.Path + "eva/zan_add.php",params,new AjaxCallBack<Object>() {

			@Override
			public void onSuccess(Object t) {
				Toast.makeText(MealActivity.this, t.toString(), Toast.LENGTH_LONG).show();
				Message msg = new Message();
				msg.what = 5;
				msg.obj = "zan";
				handler.sendMessage(msg);
			}
			
		});
		
		
	}
	//监听踩
	public void cai(View v) {
		AjaxParams params = new AjaxParams();
		params.put("m_id", m_id);
		FinalHttp fh = new FinalHttp();
		fh.post(MyData.Path + "eva/cai_add.php",params,new AjaxCallBack<Object>() {

			@Override
			public void onSuccess(Object t) {
				Toast.makeText(MealActivity.this, t.toString(), Toast.LENGTH_LONG).show();
				Message msg = new Message();
				msg.what = 5;
				msg.obj = "cai";
				handler.sendMessage(msg);
			}
			
		});
		
		
	}
	
	
}


