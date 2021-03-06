package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BindServiceTest extends Activity {
	
	Button bind,unbind,getServiceStatus;
	BindService.MyBinder binder ;
	
	private ServiceConnection conn = new ServiceConnection() {
		
		/*
		 * 当该Activity与Service断开连接时回调该方法
		 * @see android.content.ServiceConnection#onServiceDisconnected(android.content.ComponentName)
		 */
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			System.out.println("--Serivce Disconnected--");
		}
		
		/*
		 * 当该Activity与Service连接成功时回调该方法
		 * @see android.content.ServiceConnection#onServiceConnected(android.content.ComponentName, android.os.IBinder)
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			System.out.println("--Service Connected--");
			//获取Service的OnBind方法返回的MyBiinder对象
			binder = (BindService.MyBinder)service;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bindservice);
		bind = (Button) findViewById(R.id.btn_bindserivce);
		unbind = (Button) findViewById(R.id.btn_unbindservice);
		getServiceStatus = (Button) findViewById(R.id.btn_servicestatus);
		
		//创建启动Service的Intent
		final Intent intent = new Intent();
		intent.setAction("org.chaper9.service.BIND_SERVICE");
		bind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});
		unbind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unbindService(conn);
			}
		});
		
		getServiceStatus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(BindServiceTest.this, "Service的Count值为:" + binder.getCount(), 
						Toast.LENGTH_LONG).show();
			}
		});
		
		
	}
}
