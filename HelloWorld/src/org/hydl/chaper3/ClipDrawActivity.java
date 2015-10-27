package org.hydl.chaper3;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class ClipDrawActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clipdraw);
		ImageView imageview = (ImageView) findViewById(R.id.img01);
		final ClipDrawable drawable = (ClipDrawable) imageview.getDrawable();
		final Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				
				if(msg.what == 0x1233) {
					drawable.setLevel(drawable.getLevel() + 200);
				}
				
			}
		};
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message msg = new Message();
				msg.what = 0x1233;
				handler.sendMessage(msg);
				if(drawable.getLevel()>10000) {
					timer.cancel();
				}
			}
		}, 0,300);
		
	}
}
