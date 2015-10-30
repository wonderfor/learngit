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
		
		Button btn_telephonystatus = (Button) findViewById(R.id.btn_telephonystatus);
		btn_telephonystatus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,TelephonyStatus.class);
				startActivity(i);
			}
		});
		
		Button btn_monitorphone = (Button) findViewById(R.id.btn_monitorphone);
		btn_monitorphone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,MonitorPhone.class);
				startActivity(i);
			}
		});
		
		Button btn_blockmain = (Button) findViewById(R.id.btn_blockmain);
		btn_blockmain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,BlockMain.class);
				startActivity(i);
			}
		});
		
		Button btn_sendsms = (Button) findViewById(R.id.btn_sendsms);
		btn_sendsms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,SendSms.class);
				startActivity(i);
			}
		});
		
		Button btn_groupsend = (Button) findViewById(R.id.btn_groupsend);
		btn_groupsend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,GroupSend.class);
				startActivity(i);
			}
		});
		
		Button btn_audiotest = (Button) findViewById(R.id.btn_audiotest);
		btn_audiotest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperNineActivity.this,AudioTest.class);
				startActivity(i);
			}
		});
		
	}
}
