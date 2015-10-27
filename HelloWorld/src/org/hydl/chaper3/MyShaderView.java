package org.hydl.chaper3;

import org.hydl.helloworld.R.color;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyShaderView extends View {

	Paint paint = new Paint();
	
	public MyShaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setColor(color.c3);
		canvas.drawRect(50, 450,450,50,paint);
	}
	
	

}
