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
		//��ʼ��SurfaceHolder
		holder = surface.getHolder();
		holder.addCallback(new Callback() {

			public void surfaceDestroyed(SurfaceHolder arg0) {
				// TODO Auto-generated method stub

			}

			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				// ��������SurfaceView
				Canvas canvas = holder.lockCanvas();
				//���Ʊ���
				Bitmap back = BitmapFactory.decodeResource(
						SurfaceViewTest.this.getResources(), R.drawable.back2);
				//���Ʊ���
				canvas.drawBitmap(back, 0, 0, null);
				//�������,�ͷŻ���,�ύ�޸�.
				holder.unlockCanvasAndPost(canvas);
				//������һ��,���־û����ϴ������Ƶ�����
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
					//����SurfaceView�ľֲ�����,ֻ���¾ֲ�����
					Canvas canvas = holder.lockCanvas(new Rect(cx - 50, cy - 50, cx + 50, cy + 50));
					//����canvas�ĵ�ǰ״̬
					canvas.save();
					//��ת����'
					canvas.rotate(30 , cx , cy);
					paint.setColor(Color.RED);
					//���ƺ�ɫ����
					canvas.drawRect(cx - 40, cy - 40,cx , cy ,paint);
					//�ָ�canvas֮ǰ�ı���״̬
					canvas.restore();
					paint.setColor(Color.GREEN);
					//������ɫ����
					canvas.drawRect(cx, cy, cx+40, cy+40, paint);
					//�ͷŻ���  �ύ�޸�
					holder.unlockCanvasAndPost(canvas);
				}
				
				return false;
			}
		});
	}
}
