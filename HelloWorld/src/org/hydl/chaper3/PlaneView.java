package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PlaneView extends View {

	public float currentX;
	public float currentY;
	Bitmap plane;

	public PlaneView(Context context) {
		super(context);
		// ¶¨Òå·É»úÍ¼Æ¬
		plane = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.ic_launcher);
		setFocusable(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint p = new Paint();
		canvas.drawBitmap(plane, currentX, currentY,p);
	}

}
