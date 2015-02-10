package com.zhangyongcun.msmk;



import info.androidhive.slidingmenu.R;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("HandlerLeak")
public class InfoFragment extends Fragment {
	
	
	
	protected static final int CHINGUI = 1;

	//构造方法
	public InfoFragment(){
		
	}
	
	WebView webView;
	
	/*显示自定义新闻通知系统
	FinalHttp fh = new FinalHttp();
	
	
	
	List<String> n_idList = new ArrayList<String>(0);
	List<String> n_titleList = new ArrayList<String>(0);
	ListView list;
	



	private Handler handler;
	*/
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);
        this.webView = (WebView) rootView.findViewById(R.id.douguo);
        
        this.webView.setWebViewClient(new DWebViewClient()); 
        webView.loadUrl("http://m.douguo.com/");
        
        /*
        list = (ListView)rootView.findViewById(R.id.list);
       
        //handler消息机制开始------
        handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				if(msg.what == CHINGUI) {
					@SuppressWarnings("unchecked")
					final List<News> newsList = (List<News>)msg.obj;
					MyApplication myApplication = ((MyApplication)getActivity().getApplication());
					myApplication.setNewsList(newsList);
					//存入list中数据中
					for (int i = 0; i < newsList.size(); i++) {
				    	   n_idList.add(newsList.get(i).getN_id());
				    	   n_titleList.add(newsList.get(i).getN_title());
				    }
					
					
					//转换
				    final int size = newsList.size();
				    String[] n_id = (String[]) n_idList.toArray(new String[size]);
				    String[] n_title = (String[]) n_titleList.toArray(new String[size]);
				    NewsList adapter = new NewsList(getActivity(), n_id, n_title);
				    
				    list.setAdapter(adapter);
				    list.setOnItemClickListener(new OnItemClickListener() {
				    	

						//监听List事件  跳转
						public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
							
							Intent it = new Intent();
							it.setClass(getActivity(), NewsActivity.class);
							it.putExtra("pos", position);
							getActivity().startActivity(it);
							
						}
					});
					
					
					
					
					
				}
			}
			
			
        	
        };
        //handler结束
        
        
        //-------------------------------
        //从服务器上获取数据
        //get请求服务器获取json字符串
		fh.get(MyData.Path+"news/news_list.php",new AjaxCallBack<Object>() {
			@Override
			public void onSuccess(Object t) {
				List<News> newsList;
				//JSON  对象转换为List
				Type listType = new TypeToken<List<News>>(){}.getType();
				newsList = new Gson().fromJson(t.toString(), listType);
		        Message msg = new Message();
		        msg.what = CHINGUI;
		        msg.obj = newsList;
		        handler.sendMessage(msg);
		        
				
				
			}
		});
        //----------------------------------
		
		
		
		*/
		
        return rootView;
	}
	
}
class DWebViewClient extends WebViewClient {

    @Override

    public boolean shouldOverrideUrlLoading(WebView view, String url){

    // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边

       view.loadUrl(url);

       return true;

       }

}