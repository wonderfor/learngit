package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class I18nTest extends Activity {
	
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_i18ntest);
		tv = (TextView) findViewById(R.id.show);
		tv.setText(R.string.msg);
	}
}
