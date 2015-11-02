package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.Toast;

public class VibratorTest extends Activity {
	Vibrator vibrator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		Toast.makeText(this, "ÊÖ»úÕð¶¯", Toast.LENGTH_LONG).show();
		vibrator.vibrate(2000);
		return super.onTouchEvent(event);
	}
}
