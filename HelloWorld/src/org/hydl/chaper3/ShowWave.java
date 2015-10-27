package org.hydl.chaper3;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShowWave extends Activity {

	private SurfaceHolder holder;
	private Paint paint;
	final int HEIGHT = 320;
	final int WIDTH = 320;
	final int X_OFFSET = 5;
	private int cx = X_OFFSET;
	// 实际的Y轴的位置
	int centerY = HEIGHT / 2;
	Timer timer = new Timer();
	TimerTask task = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showwave);
		final SurfaceView surface = (SurfaceView) findViewById(R.id.show);
		// 初始化Surfaceholder对象
		holder = surface.getHolder();
		paint = new Paint();
		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(3);
		Button sin = (Button) findViewById(R.id.sin);
		Button cos = (Button) findViewById(R.id.cos);
		OnClickListener listener = (new OnClickListener() {

			@Override
			public void onClick(final View source) {
				// TODO Auto-generated method stub
				drawBack(holder);
				cx = X_OFFSET;
				if (task != null) {
					task.cancel();
				}
				task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						int cy = source.getId() == R.id.sin ? centerY
								- (int) (100 * Math.sin((cx - 5) * 2 * Math.PI
										/ 150)) : centerY
								- (int) (100 * Math.cos((cx - 5) * 2 * Math.PI
										/ 150));
						Canvas canvas = holder.lockCanvas(new Rect(cx, cy - 2, cx + 2, cy + 2));
						canvas.drawPoint(cx, cy , paint);
						cx ++ ;
						if(cx > WIDTH) {
							task.cancel();
							task = null;
						}
						holder.unlockCanvasAndPost(canvas);
					}
				};
				timer.schedule(task, 0 , 30);
			}
		});
		
		sin.setOnClickListener(listener);
		cos.setOnClickListener(listener);
		holder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				timer.cancel();
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				drawBack(holder);
			}
		});
	}

	private void drawBack(SurfaceHolder holder) {
		Canvas canvas = holder.lockCanvas();
		// 绘制白色背景
		canvas.drawColor(Color.WHITE);
		Paint p = new Paint();
		p.setColor(Color.BLACK);
		p.setStrokeWidth(2);
		// 绘制坐标轴
		canvas.drawLine(X_OFFSET, centerY, WIDTH, centerY, p);
		canvas.drawLine(X_OFFSET, 40, X_OFFSET, HEIGHT, p);
		holder.unlockCanvasAndPost(canvas);
		holder.lockCanvas(new Rect(0, 0, 0, 0));
		holder.unlockCanvasAndPost(canvas);
	}
}
