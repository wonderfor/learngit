package org.hydl.chaper3;

import java.util.Set;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		EditText show = (EditText) findViewById(R.id.editsecond1);
		String aciont = getIntent().getAction();
		show.setText("ActionÎª : " + aciont);
		EditText cate = (EditText) findViewById(R.id.editsecond2);
		Set<String> cates = getIntent().getCategories();
		cate.setText("CategoryÊôÐÔÎª£º" + cates);
		
		Button btn_returnhome = (Button) findViewById(R.id.btn_returnhome);
		btn_returnhome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
		
	}
}
