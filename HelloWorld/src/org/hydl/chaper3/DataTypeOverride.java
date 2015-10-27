package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DataTypeOverride extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datatype);
		Button btn_type1 = (Button) findViewById(R.id.btn_type1);
		btn_type1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setType("abc/xyz");
				intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
				Toast.makeText(DataTypeOverride.this, intent.toString(), Toast.LENGTH_LONG).show();
			}
		});
		
		Button btn_type2 = (Button) findViewById(R.id.btn_type2);
		btn_type2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
				intent.setType("abc/xyz");
				Toast.makeText(DataTypeOverride.this, intent.toString(), Toast.LENGTH_LONG).show();
			}
		});
		
		Button btn_typ3 = (Button) findViewById(R.id.btn_type3);
		btn_typ3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath"), "abc/xyz");
				Toast.makeText(DataTypeOverride.this, intent.toString(), Toast.LENGTH_LONG).show();
			}
		});
		
	}
}
