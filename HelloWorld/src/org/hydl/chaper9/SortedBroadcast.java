package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SortedBroadcast extends Activity {
	
	Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sortedbroadcast);
		
		send = (Button) findViewById(R.id.btn_send);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("org.hydl.chaper9.SORT_BROADCAST");
				intent.putExtra("msg", "简单的消息");
				//发送有序广播
				sendOrderedBroadcast(intent, null);
			}
		});
	}
}
