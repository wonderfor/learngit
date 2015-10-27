package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView name = (TextView) findViewById(R.id.name);
		TextView passwd = (TextView) findViewById(R.id.pass);
		TextView gender = (TextView) findViewById(R.id.gender);
		Intent intent = getIntent();
		Person p = (Person)intent.getSerializableExtra("person");
		name.setText("您的用户名为：" + p.getUsername());
		passwd.setText("您的密码为：" + p.getPassword());
		gender.setText("您的性别为:" + p.getSex());
	}
}
