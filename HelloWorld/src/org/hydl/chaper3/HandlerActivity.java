package org.hydl.chaper3;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class HandlerActivity extends Activity {

	int[] imageIds = new int[] { R.drawable.bom1, R.drawable.bom2,
			R.drawable.bom3, R.drawable.ic_launcher };
	ImageView show;
	int currentImageId = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler);
		show = (ImageView) findViewById(R.id.imageView02);
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x1233) {
					show.setImageResource(imageIds[currentImageId++
							% imageIds.length]);
				}
			}
		};

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(0x1233);
			}
		}, 0, 1200);
	}

}
