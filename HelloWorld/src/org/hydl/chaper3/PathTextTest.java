package org.hydl.chaper3;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class PathTextTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new TextView(this));
	}
	
	class TextView extends View{

		
		final String DRAW_STAR = "·è¿ñJava½²Òå";
		Path[] paths = new Path[3];
		Paint paint;
		
		public TextView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			paths[0] = new Path();
			paths[0].moveTo(0, 0);
			for(int i = 1;i<=7;i++) {
				paths[0].lineTo(i*30, (float)Math.random()*30);
			}
			
			paths[1] = new Path();
			RectF rectf = new RectF(0, 0, 200, 120);
			paths[1].addOval(rectf, Path.Direction.CCW);
			paths[2] = new Path();
			paths[2].addArc(rectf, 60, 180);
			//³õÊ¼»¯»­±Ê
			paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(Color.CYAN);
			paint.setStrokeWidth(1);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			canvas.drawColor(Color.WHITE);
			canvas.translate(40, 40);
			paint.setTextAlign(Paint.Align.RIGHT);
			paint.setTextSize(20);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawPath(paths[0],paint);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawTextOnPath(DRAW_STAR, paths[0], -8, 20, paint);
			canvas.translate(0, 60);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawPath(paths[1], paint);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawTextOnPath(DRAW_STAR, paths[1], -20,20, paint);
			canvas.translate(0, 120);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawPath(paths[2], paint);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawTextOnPath(DRAW_STAR, paths[2], -10, 20, paint);
		}
		
	}
	
}
