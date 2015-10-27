package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActionDataActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actiondata);
		
		Button bn1 = (Button) findViewById(R.id.bn1);
		bn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view	) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				String data = "http://www.baidu.com";
				Uri uri = Uri.parse(data);
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(uri);
				startActivity(intent);
			}
		});
		
		Button bn2 = (Button) findViewById(R.id.bn2);
		bn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_EDIT);
				String data = "content://com.android.contacts/contacts/1";
				Uri uri = Uri.parse(data);
				intent.setData(uri);
				startActivity(intent);
			}
		});
		
		Button bn3 = (Button) findViewById(R.id.bn3);
		bn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_DIAL);
				String data = "tel:13800138000";
				Uri uri = Uri.parse(data);
				intent.setData(uri);
				startActivity(intent);
			}
		});
		
	}
}
