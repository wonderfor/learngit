package org.hydl.chaper3;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Butterfly extends Activity {
	
	private float curX = 0 ;
	private float curY = 30;
	float nextX = 0;
	float nextY = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_butter);
		final ImageView imageView = (ImageView) findViewById(R.id.img07);
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if(msg.what == 0x123) {
					if(nextX > 320) {
						curX = nextX = 0;
					} else {
						nextX += 8;
					}
					
					nextY = curY + (float)(Math.random() * 10 - 5);
					TranslateAnimation anim = new TranslateAnimation(curX,nextY,curY,nextY);
					curX = nextX;
					curY = nextY;
					anim.setDuration(200);
					imageView.startAnimation(anim);
				}
			}
		};
		
		final AnimationDrawable butterfly = (AnimationDrawable) imageView.getBackground();
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				butterfly.start();
				new Timer().schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						handler.sendEmptyMessage(0x123);
					}
				}, 0,200);
			}
		});
	}
}
