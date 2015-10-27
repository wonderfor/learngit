package org.hydl.chaper3;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnim extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tween);
		final ImageView flower = (ImageView) findViewById(R.id.img_anim);
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.img_anim);
		anim.setFillAfter(true);
		final Animation reverse = AnimationUtils.loadAnimation(this, R.anim.img_reverse);
		reverse.setFillAfter(true);
		Button bn = (Button) findViewById(R.id.btn_startanim);
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what == 0x123) {
					flower.startAnimation(reverse);
				}
			}
		};
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flower.startAnimation(anim);
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						handler.sendEmptyMessage(0x123);
					}
				}, 3500);
			}
		});
	}
}
