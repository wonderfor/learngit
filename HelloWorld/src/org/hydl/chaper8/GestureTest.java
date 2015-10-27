package org.hydl.chaper8;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;

import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;

public class GestureTest extends Activity implements OnGestureListener {
	
	GestureDetector detector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clipdraw);
		detector = new GestureDetector(this, this);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		Toast.makeText(GestureTest.this, "onDown", Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		Toast.makeText(GestureTest.this, "onFling", Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(GestureTest.this, "onLongPress", Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		Toast.makeText(GestureTest.this, "onScroll", Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(GestureTest.this, "onShowPress", Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		Toast.makeText(GestureTest.this, "OnSingleTapUp", Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return detector.onTouchEvent(event);
	}

	

}
