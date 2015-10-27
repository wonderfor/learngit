package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FatPo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fatpo);
		Button btn_start = (Button) findViewById(R.id.btn_start);
		Button btn_stop = (Button) findViewById(R.id.btn_stop);
		ImageView imageView = (ImageView) findViewById(R.id.img06);
		final AnimationDrawable anim = (AnimationDrawable) imageView.getBackground();
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				anim.start();
			}
		});
		btn_stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				anim.stop();
			}
		});
	}
}
