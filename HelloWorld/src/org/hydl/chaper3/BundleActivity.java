package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BundleActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bundle);
		Button bn = (Button) findViewById(R.id.bn);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText name = (EditText) findViewById(R.id.edname);
				EditText pass = (EditText) findViewById(R.id.edpass);
				RadioButton male = (RadioButton) findViewById(R.id.male);
				String gender = male.isChecked() ? "ÄÐ" : "Å®";
				Person p = new Person(name.getText().toString(),pass.getText().toString(),gender);
				Bundle data = new Bundle();
				data.putSerializable("person", p);
				Intent intent = new Intent(BundleActivity.this,ResultActivity.class);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}
}
