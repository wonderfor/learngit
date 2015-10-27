package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceViewTest extends Activity {

	private SurfaceHolder holder;
	private Paint paint;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surfaceview);
		paint = new Paint();
		SurfaceView surface = (SurfaceView) findViewById(R.id.show);
		//初始化SurfaceHolder
		holder = surface.getHolder();
		holder.addCallback(new Callback() {

			public void surfaceDestroyed(SurfaceHolder arg0) {
				// TODO Auto-generated method stub

			}

			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				// 锁定整个SurfaceView
				Canvas canvas = holder.lockCanvas();
				//绘制背景
				Bitmap back = BitmapFactory.decodeResource(
						SurfaceViewTest.this.getResources(), R.drawable.back2);
				//绘制背景
				canvas.drawBitmap(back, 0, 0, null);
				//绘制完成,释放画布,提交修改.
				holder.unlockCanvasAndPost(canvas);
				//重新锁一次,“持久化”上次所绘制的内容
				holder.lockCanvas(new Rect(0, 0, 0, 0));
				holder.unlockCanvasAndPost(canvas);
			}

			public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub

			}
		});

		surface.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View source, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if(event.getAction() == MotionEvent.ACTION_DOWN)  {
					int cx = (int)event.getX();
					int cy = (int)event.getY();
					//锁定SurfaceView的局部区域,只更新局部内容
					Canvas canvas = holder.lockCanvas(new Rect(cx - 50, cy - 50, cx + 50, cy + 50));
					//保存canvas的当前状态
					canvas.save();
					//旋转画布'
					canvas.rotate(30 , cx , cy);
					paint.setColor(Color.RED);
					//绘制红色方块
					canvas.drawRect(cx - 40, cy - 40,cx , cy ,paint);
					//恢复canvas之前的保存状态
					canvas.restore();
					paint.setColor(Color.GREEN);
					//绘制绿色方块
					canvas.drawRect(cx, cy, cx+40, cy+40, paint);
					//释放画布  提交修改
					holder.unlockCanvasAndPost(canvas);
				}
				
				return false;
			}
		});
	}
}
