package org.hydl.chaper3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

	public float currentX = 40;
	public float currentY = 50;
	Paint p = new Paint();
	
	public DrawView(Context context , AttributeSet set) {
		super(context , set);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		p.setColor(Color.RED);
		canvas.drawCircle(currentX, currentY, 15, p);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		this.currentX = event.getX();
		this.currentY = event.getY();
		this.invalidate();
		return true;
	}
}
