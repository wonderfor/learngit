package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActionCateAttr extends Activity{
	final static String CRAZYIT_ACTION = "org.hydl.chaper3.CRAZYIT_ACTION";
	final static String CRAZYIT_CATEGORY = "org.hydl.chaper3.CRAZYIT_CATEGORY";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datatype);
		Button bn = (Button) findViewById(R.id.btn_type1);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(ActionCateAttr.CRAZYIT_ACTION);
				intent.addCategory(ActionCateAttr.CRAZYIT_CATEGORY);
				startActivity(intent);
			}
		});
	}
	
}
