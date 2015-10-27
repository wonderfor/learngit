package org.hydl.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity {
	
	private ViewFlipper viewFlipper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewflipper);
		viewFlipper = (ViewFlipper) findViewById(R.id.details);
	}
	
	public void prev(View source) {
		viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
		viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
		viewFlipper.showPrevious();
		viewFlipper.stopFlipping();
	}
	
	public void next(View source) {
		viewFlipper.setInAnimation(this,android.R.anim.slide_out_right);
		viewFlipper.setOutAnimation(this,android.R.anim.slide_in_left);
		viewFlipper.showNext();
		viewFlipper.stopFlipping();
	}
	
	public void auto(View source) {
		viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
		viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
		viewFlipper.startFlipping();
	}
	
}
