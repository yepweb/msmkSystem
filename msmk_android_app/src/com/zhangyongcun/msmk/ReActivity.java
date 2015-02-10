package com.zhangyongcun.msmk;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zhangyongcun.unil.MyData;

public class ReActivity extends Activity {
	public  EditText u_name;
	public EditText u_pwd;
	public EditText u_phone;
	public EditText u_address;
	public EditText u_other;
	
	
	private String apiPath = MyData.Path + "login/user_add.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		this.u_name = (EditText) super.findViewById(R.id.u_name);
		this.u_pwd = (EditText) super.findViewById(R.id.u_pwd);
		this.u_phone = (EditText) super.findViewById(R.id.u_phone);
		this.u_address = (EditText) super.findViewById(R.id.u_address);
		this.u_other = (EditText) super.findViewById(R.id.u_other);
		
		
		
		
		
	}
	
	public void register(View v) {

		String u_name =  this.u_name.getText().toString();
		String u_pwd = this.u_pwd.getText().toString();
		String u_phone = this.u_phone.getText().toString();
		String u_addres = this.u_address.getText().toString(); 
		String u_other = this.u_other.getText().toString();

		
		//POST请求
		
		AjaxParams params = new AjaxParams();
		params.put("u_name", u_name);
		params.put("u_pwd", u_pwd);
		params.put("u_phone", u_phone);
		params.put("u_addres", u_addres);
		params.put("u_other", u_other);
		
		FinalHttp fh = new FinalHttp();
		fh.post(apiPath, params,new AjaxCallBack<Object>() {

			@Override
			public void onLoading(long count, long current) {
				Log.i("info", "等待中");
			}

			@Override
			public void onSuccess(Object t) {
				if("false".equals(t.toString())) {
					Toast.makeText(ReActivity.this, "注册失败", Toast.LENGTH_LONG).show();
				}else 
					Toast.makeText(ReActivity.this, "注册成功", Toast.LENGTH_LONG).show();
			    return ;	
			}
			
		});
		//请求结束
		
		
	}

	

}



	
	
