package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class WarpTest extends Activity {

	private Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this, R.drawable.bom1));
	}

	private class MyView extends View {

		private final int WIDTH = 20;
		private final int HEIGHT = 20;
		// ��¼��ͼƬ�ϰ���441������
		private final int COUNT = (WIDTH + 1) * (HEIGHT + 1);
		// ����һ������,����Bitmap�ϵ�21*21���������
		private final float[] verts = new float[COUNT * 2];
		// ����һ������,����Bitmap�ϵ�21*21���㾭��Ť���������
		// ��ͼƬ����Ť���Ĺؼ������޸ĸ�������Ԫ�ص�ֵ
		private final float[] orig = new float[COUNT * 2];

		public MyView(Context context, int drawableId) {
			super(context);
			// TODO Auto-generated constructor stub
			setFocusable(true);
			bitmap = BitmapFactory.decodeResource(getResources(), drawableId);
			// ��ȡͼƬ�Ŀ��,�߶�
			float bitmapWidth = bitmap.getWidth();
			float bitmapHeight = bitmap.getHeight();
			int index = 0;
			for (int y = 0; y <= HEIGHT; y++) {
				float fy = bitmapHeight * y / HEIGHT;
				for (int x = 0; x <= WIDTH; x++) {
					float fx = bitmapWidth * x / WIDTH;
					// ��ʼ�� orig��verts���顣��ʼ����orig��verts
					// ����������ȵر�����21*21�����x��y����
					orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
					orig[index * 2 + 1] = verts[index * 2 + 1] = fy;
					index += 1;
				}
			}
			setBackgroundColor(Color.WHITE);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			// �� bitmap �� verts �������Ť��
			// �ӵ�һ���㣨�ɵ�5������0���ƣ���ʼŤ��
			canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT, verts, 0, null, 0,
					null);
		}

		private void warp(float cx, float cy) {
			for (int i = 0; i < COUNT * 2; i += 2) {
				float dx = cx - orig[i + 0];
				float dy = cy - orig[i + 1];
				float dd = dx * dx + dy * dy;
				float d = (float) Math.sqrt(dd);
				float pull = 8000 / ((float) (dd * d));
				if (pull >= 1) {
					verts[i + 0] = cx;
					verts[i + 1] = cy;
				} else {
					verts[i + 0] = orig[i + 0] + dx * pull;
					verts[i + 1] = orig[i + 1] + dy * pull;
				}
			}
			invalidate();
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			warp(event.getX(), event.getY());
			return true;
		}
	}

}
