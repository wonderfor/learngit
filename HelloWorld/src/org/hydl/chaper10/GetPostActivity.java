package org.hydl.chaper10;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GetPostActivity extends Activity {
	
	Button get, post;
	TextView show;
	//代表服务器响应的字符串
	String response;
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0x123) {
				show.setText(response);
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_getpost);
		get = (Button) findViewById(R.id.get);
		post = (Button) findViewById(R.id.post);
		show = (TextView) findViewById(R.id.show);
		
		get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						response = GetPostUtil.sendGet("http://192.168.0.97:801/", null);
						//发送消息通知UI线程更新UI组件
						handler.sendEmptyMessage(0x123);
					}
				}.start();
			}
		});
		
		post.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread() {
					public void run() {
						response = GetPostUtil.sendPost("http://192.168.0.97:801/", null);
					};
				}.start();
				handler.sendEmptyMessage(0x123);
			}
		});
	}
}
