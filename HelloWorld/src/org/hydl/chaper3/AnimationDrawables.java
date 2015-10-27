package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationDrawables extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		
		final ImageView image = (ImageView) findViewById(R.id.img02);
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.my_anim);
		anim.setFillAfter(true);
		Button bn = (Button) findViewById(R.id.btn_stop);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				image.startAnimation(anim);
			}
		});
	}
}
