package org.hydl.readother;



import org.hydl.chaper9.ICat;
import org.hydl.chaper9.ICat.Stub;
import org.hydl.readother.R;
import org.hydl.readother.R.id;
import org.hydl.readother.R.layout;

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
import android.widget.EditText;

public class AidlClient extends Activity{
	
	private ICat catService;
	private Button get;
	EditText color,weight;
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			catService = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			//获取远程Service的OnBind方法返回的对象的代理
			catService = ICat.Stub.asInterface(service);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aidlclient);
		get = (Button) findViewById(R.id.btn_getservice);
		color = (EditText) findViewById(R.id.ed_color);
		weight = (EditText) findViewById(R.id.ed_weight);
		Intent intent = new Intent();
		//HellowWorld项目中定义
		
		intent.setAction("org.hydl.chaper9.aidlservice");
		bindService(intent, conn, Service.BIND_AUTO_CREATE);
		get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//获取并显示远程Service的状态
				try {
					String colors = catService.getColor();
					double weights = catService.getWeight();
					System.out.println("colors:" + colors + "\n" + "weight:" + weights);
					color.setText(colors);
					weight.setText(weights + "");
					
					System.out.println("readother");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.unbindService(conn);
	}
	
}
