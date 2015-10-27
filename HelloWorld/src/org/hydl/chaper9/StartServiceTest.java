package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartServiceTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startservice);
		
		Button btn_start = (Button) findViewById(R.id.btn_start);
		Button btn_stop = (Button) findViewById(R.id.btn_stop);
		
		final Intent intent = new Intent();
		intent.setAction("org.chaper9.service.firstservice");
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(intent);
			}
		});
		
		btn_stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
	}
}
