package org.hydl.helloworld;

import org.hydl.chaper9.ChaperNineActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baseactivity);
		
		Button btn_chaper1 = (Button) findViewById(R.id.btn_chaper1);
		btn_chaper1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(BaseActivity.this,MainActivity.class);
				startActivity(i);
			}
		});
		
		Button btn_chaper9 = (Button) findViewById(R.id.btn_chaper9);
		btn_chaper9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(BaseActivity.this,ChaperNineActivity.class);
				startActivity(i);
			}
		});
	}
}
