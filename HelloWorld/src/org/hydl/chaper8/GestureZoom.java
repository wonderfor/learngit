package org.hydl.chaper8;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;

public class GestureZoom extends Activity implements OnGestureListener {

	// 定义手势检测器实例
	GestureDetector detector;
	ImageView imageView;
	Bitmap bitmap;
	int width, height;
	float currentScale = 1;
	Matrix matrix;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesturezoom);
		detector = new GestureDetector(this, this);
		imageView = (ImageView) findViewById(R.id.show);
		matrix = new Matrix();
		bitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.bom1);
		width = bitmap.getWidth();
		height = bitmap.getHeight();
		imageView.setImageBitmap(BitmapFactory.decodeResource(
				this.getResources(), R.drawable.bom1));
	}

	@Override
	public boolean onTouchEvent(MotionEvent me) {
		// TODO Auto-generated method stub
		return detector.onTouchEvent(me);
	}

	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2,
			float velocityX, float velocityY) {
		// TODO Auto-generated method stub
		velocityX = velocityX > 4000 ? 4000 : velocityX;
		velocityX = velocityX < -4000 ? -4000 : velocityX;
		// 根据手势计算缩放比,如果velocityX>0,放大图像,否则缩小图像
		currentScale += currentScale * velocityX / 4000.0f;
		// 保证currentScale不等于0
		currentScale = currentScale > 0.01 ? currentScale : 0.01f;
		// 重置Matrix
		matrix.reset();
		// 缩放Matrix
		matrix.setScale(currentScale, currentScale, 160, 200);
		BitmapDrawable tmp = (BitmapDrawable) imageView.getDrawable();
		if (!tmp.getBitmap().isRecycled()) {
			tmp.getBitmap().recycle();
		}
		// 根据原始位图和Matrix创建新图片
		Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height,
				matrix, true);
		imageView.setImageBitmap(bitmap2);
		return true;
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
