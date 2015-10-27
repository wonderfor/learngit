package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentServiceTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intentsercie);
		
		Button btn_startservice = (Button) findViewById(R.id.btn_startservice);
		Button btn_startintentservice = (Button) findViewById(R.id.btn_startintentsercice);
		
		btn_startservice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setAction("org.chaper9.service.MyService");
				startService(i);
			}
		});
		
		btn_startintentservice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setAction("org.chaper9.service.MyIntentService");
				startService(i);
			}
		});
	}
}
