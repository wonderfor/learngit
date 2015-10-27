package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChaperNineActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapernine);

		Button btn_dictresolver = (Button) findViewById(R.id.btn_dictresolver);
		btn_dictresolver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,DictResolverText.class);
				startActivity(i);
			}
		});
		
		Button btn_contactprovider = (Button) findViewById(R.id.btn_contactprovider);
		btn_contactprovider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,ContactProviderTest.class);
				startActivity(i);
			}
		});
		
		Button btn_mediaprovider = (Button) findViewById(R.id.btn_mediaprovider);
		btn_mediaprovider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,MediaProviderTest.class);
				startActivity(i);
			}
		});
		
		Button btn_monitorsms = (Button) findViewById(R.id.btn_monitorsms);
		btn_monitorsms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,MonitorSms.class);
				startActivity(i);
			}
		});
		
		Button btn_startService = (Button) findViewById(R.id.btn_stratservice);
		btn_startService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,StartServiceTest.class);
				startActivity(i);
			}
		});
		
		Button btn_bindservice = (Button) findViewById(R.id.btn_bindservice);
		btn_bindservice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,BindServiceTest.class);
				startActivity(i);
			}
		});
		
		Button btn_intentservice = (Button) findViewById(R.id.btn_intentservicetest);
		btn_intentservice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,IntentServiceTest.class);
				startActivity(i);
			}
		});
		
	}
}