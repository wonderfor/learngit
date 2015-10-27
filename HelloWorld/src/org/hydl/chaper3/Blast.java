package org.hydl.chaper3;

import java.lang.reflect.Field;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Blast extends Activity {
	
	private MyView myView;
	private AnimationDrawable anim;
	private MediaPlayer bomb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		FrameLayout frame = new FrameLayout(this);
		setContentView(frame);
		frame.setBackgroundResource(R.drawable.back);
		bomb = MediaPlayer.create(this, R.raw.bomb);
		myView = new MyView(this);
		myView.setBackgroundResource(R.drawable.blast);
		myView.setVisibility(View.INVISIBLE);
		anim = (AnimationDrawable) myView.getBackground();
		frame.addView(myView);
		frame.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN) {
					anim.stop();
					float x = event.getX();
					float y = event.getY();
					myView.setLocation((int)y-40, (int)x-20);
					myView.setVisibility(View.VISIBLE);
					anim.start();
					bomb.start();
				}
				
				return false;
			}
		});
	}
	
	class MyView extends ImageView {

		public MyView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public void setLocation(int top, int left) {
			
		}
		
		protected void onDraw(Canvas canvas) {
			try {
				Field field = AnimationDrawable.class.getDeclaredField("mCurFrame");
				field.setAccessible(true);
				int curFrame = field.getInt(anim);
				if(curFrame == anim.getNumberOfFrames() - 1) {
					setVisibility(View.INVISIBLE);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			super.onDraw(canvas);
		};
	}
}
