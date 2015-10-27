package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

public class MatrixView extends View {

	// ��ʼ��ͼƬ��Դ
	private Bitmap bitmap;
	// Matrix ʵ��
	private Matrix matrix = new Matrix();
	// ������б��
	private float sx = 0.0f;
	// λͼ��͸�
	private int width, height;
	// ���ű���
	private float scale = 1.0f;
	// �ж����Ż�����ת
	private boolean isScale = false;

	public MatrixView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		bitmap = ((BitmapDrawable) context.getResources().getDrawable(
				R.drawable.bom1)).getBitmap();
		width = bitmap.getWidth();
		height = bitmap.getHeight();
		this.setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		matrix.reset();
		if (!isScale) {
			matrix.setSkew(sx, 0);
		} else {
			matrix.setScale(scale, scale);
		}

		Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height,
				matrix, true);
		canvas.drawBitmap(bitmap2, matrix, null);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_A:
			isScale = false;
			sx += 0.1;
			postInvalidate();
			break;
		case KeyEvent.KEYCODE_D:
			isScale = false;
			sx -= 0.1;
			postInvalidate();
			break;
		case KeyEvent.KEYCODE_W:
			isScale = true;
			if (scale < 2.0)
				scale += 0.1;
			postInvalidate();
			break;
		case KeyEvent.KEYCODE_S:
			isScale = true;
			if (scale > 0.5)
				scale -= 0.1;
			postInvalidate();
			break;

		}

		return super.onKeyDown(keyCode, event);
	}

}
