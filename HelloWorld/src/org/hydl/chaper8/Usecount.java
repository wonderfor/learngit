package org.hydl.chaper8;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;

public class Usecount extends Activity {
	
	SharedPreferences preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		preferences = getSharedPreferences("count", MODE_WORLD_READABLE);
		int count = preferences.getInt("count", 0);
		Toast.makeText(this, "程序以前被使用了" + count + "次", Toast.LENGTH_LONG).show();
		Editor editor = preferences.edit();
		editor.putInt("count", ++count);
		editor.commit();
	}
}
