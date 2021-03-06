package org.hydl.readother;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Context useCount = null;
		try {
			useCount = createPackageContext("org.hydl.helloworld", Context.CONTEXT_IGNORE_SECURITY);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		SharedPreferences prefs = useCount.getSharedPreferences("count", Context.MODE_WORLD_READABLE);
		int count = prefs.getInt("count", 0);
		TextView tv = (TextView) findViewById(R.id.show);
		tv.setText("UseCount应用程序以前使用了" + count + "次");
		
		Button btn_firstresolver = (Button) findViewById(R.id.btn_firstresolver);
		btn_firstresolver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,FirstResovler.class);
				startActivity(i);
			}
		});
		
		Button btn_aidlclient = (Button) findViewById(R.id.btn_aidlclient);
		btn_aidlclient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,AidlClient.class);
				startActivity(i);
			}
		});
		
		Button btn_compxclient = (Button) findViewById(R.id.btn_complex);
		btn_compxclient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this,ComplexClient.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
