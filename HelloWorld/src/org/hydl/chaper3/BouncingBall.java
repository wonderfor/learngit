package org.hydl.chaper3;

import java.util.ArrayList;

import org.hydl.helloworld.R;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

public class BouncingBall extends Activity {
	
	static final float BALL_SIZE = 50F;
	static final float FULL_TIME = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bouncingball);
		LinearLayout container = (LinearLayout) findViewById(R.id.container);
		container.addView(new MyAnimationView(BouncingBall.this));
	}
	
	public class MyAnimationView extends View {
		
		public final ArrayList<ShapeHolderTwo> balls = new ArrayList<ShapeHolderTwo>();
		
		public MyAnimationView(Context context) {
			super(context);
			ObjectAnimator colorAnim = (ObjectAnimator)AnimatorInflater.loadAnimator(BouncingBall.this, R.animator.color_anim);
			colorAnim.setEvaluator(new ArgbEvaluator());
			colorAnim.setTarget(this);
			colorAnim.start();
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			if(event.getAction() != MotionEvent.ACTION_DOWN && event.getAction()!=MotionEvent.ACTION_MOVE) {
				return false;
			}
			
			ShapeHolderTwo newBall = addBall(event.getX(), event.getY());
			float startY = newBall.getY();
			float endY = getHeight() - BALL_SIZE;
			float h = (float)getHeight();
			float eventY = event.getY();
			int duration = (int)(FULL_TIME * ((h - eventY) / h));
			ValueAnimator fallAnim = ObjectAnimator.ofFloat(newBall , "y" , startY , endY);
			fallAnim.setDuration(duration);
			fallAnim.setInterpolator(new AccelerateInterpolator());
			ValueAnimator squashAniml = ObjectAnimator.ofFloat(newBall,"x",newBall.getX(),newBall.getX() - BALL_SIZE/2);
			squashAniml.setDuration(duration/4);
			squashAniml.setRepeatCount(1);
			squashAniml.setRepeatMode(ValueAnimator.REVERSE);
			squashAniml.setInterpolator(new DecelerateInterpolator());
			ValueAnimator squashAnima2 = ObjectAnimator.ofFloat(newBall,"width",newBall.getWidth(),newBall.getWidth() + BALL_SIZE);
			squashAnima2.setDuration(duration/4);
			squashAnima2.setRepeatCount(1);
			squashAnima2.setRepeatMode(ValueAnimator.REVERSE);
			squashAnima2.setInterpolator(new DecelerateInterpolator());
			ObjectAnimator stretchAnim1 = ObjectAnimator.ofFloat(newBall, "y", endY,endY + BALL_SIZE/2);
			stretchAnim1.setDuration(duration/4);
			stretchAnim1.setRepeatCount(1);
			stretchAnim1.setRepeatMode(ValueAnimator.REVERSE);
			stretchAnim1.setInterpolator(new DecelerateInterpolator());
			ValueAnimator stretchAnim2 = ObjectAnimator.ofFloat(newBall,"height",newBall.getHeight(),newBall.getHeight() - BALL_SIZE / 2);
			stretchAnim2.setDuration(duration/4);
			stretchAnim2.setRepeatCount(1);
			stretchAnim2.setRepeatMode(ValueAnimator.REVERSE);
			stretchAnim2.setInterpolator(new DecelerateInterpolator());
			ObjectAnimator bounceBackAnim = ObjectAnimator.ofFloat(newBall, "y", endY,startY);
			bounceBackAnim.setDuration(duration);
			bounceBackAnim.setInterpolator(new DecelerateInterpolator());
			AnimatorSet bouncer = new AnimatorSet();
			bouncer.play(fallAnim).before(squashAniml);
			bouncer.play(squashAniml).with(squashAnima2);
			bouncer.play(squashAniml).with(stretchAnim1);
			bouncer.play(squashAniml).with(stretchAnim2);
			bouncer.play(bounceBackAnim).after(stretchAnim2);
			ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f,0f);
			fadeAnim.setDuration(250);
			fadeAnim.addListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					// TODO Auto-generated method stub
					balls.remove(((ObjectAnimator)animation).getTarget());
				}
			});
			AnimatorSet animaorSet = new AnimatorSet();
			animaorSet.play(bouncer).before(fadeAnim);
			animaorSet.start();
			return true;
		}
		
		private ShapeHolderTwo addBall(float x , float y) {
			OvalShape circle = new OvalShape();
			circle.resize(BALL_SIZE, BALL_SIZE);
			ShapeDrawable drawable = new ShapeDrawable(circle);
			ShapeHolderTwo shapeHolder = new ShapeHolderTwo(drawable);
			shapeHolder.setX(x - BALL_SIZE / 2);
			shapeHolder.setY(y - BALL_SIZE / 2);
			int red = (int)(Math.random() * 255);
			int green = (int)(Math.random() * 255);
			int blue = (int)(Math.random() * 255);
			int color = 0xff000000 + red << 16 | green << 8 | blue;
			Paint paint = drawable.getPaint();
			int darkColor = 0xff000000 | red / 4 << 16 | green / 4 << 8 | blue / 4;
			RadialGradient gradient = new RadialGradient(37.5f, 12.5f, BALL_SIZE, color, darkColor, Shader.TileMode.CLAMP);
			paint.setShader(gradient);
			shapeHolder.setPaint(paint);
			balls.add(shapeHolder);
			return shapeHolder;
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			for (ShapeHolderTwo shapeholder : balls) {
				canvas.save();
				canvas.translate(shapeholder.getX(), shapeholder.getY());
				shapeholder.getShape().draw(canvas);
				canvas.restore();
			}
			
		}

	}
	
	
	
	
}
