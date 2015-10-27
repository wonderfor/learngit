package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ForResultActivity extends Activity {
	
	Button bn;
	EditText city;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forresult);
		bn = (Button) findViewById(R.id.bnforto);
		city = (EditText) findViewById(R.id.etittxt);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ForResultActivity.this,SelectCityActivity.class);
				startActivityForResult(intent, 0);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO Auto-generated method stub
		if(requestCode == 0 && requestCode == 0) {
			Bundle data = intent.getExtras();
			String resultCity = data.getString("city");
			city.setText(resultCity);
		}
	}
}
