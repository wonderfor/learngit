package org.hydl.chaper3;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;

public class MoveBack extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(new MyView(this));
	}

	class MyView extends View {

		// 记录背景位图的实际高度
		final int BACK_HEIGHT = 1879;
		// 背景图片
		private Bitmap back;
		private Bitmap plane;
		// 背景图的开始位置
		final int WIDTH = 520;
		final int HEIGHT = 1440;
		private int startY = BACK_HEIGHT - HEIGHT;

		public MyView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			back = BitmapFactory.decodeResource(context.getResources(),
					R.drawable.back);
			plane = BitmapFactory.decodeResource(context.getResources(),
					R.drawable.plane);

			final Handler handler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					if (msg.what == 0x123) {
						if (startY <= 3) {
							startY = BACK_HEIGHT - HEIGHT;
						} else {
							startY -= 3;
						}
					}
					invalidate();
				}
			};

			new Timer().schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					handler.sendEmptyMessage(0x123);
				}
			}, 0, 100);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			Bitmap bitmap2 = Bitmap
					.createBitmap(back, 0, startY, WIDTH, HEIGHT);
			canvas.drawBitmap(bitmap2, 0, 0, null);
			canvas.drawBitmap(plane, 140, 480, null);
		}

	}
}
