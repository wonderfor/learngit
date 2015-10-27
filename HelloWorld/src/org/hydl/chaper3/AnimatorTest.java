package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AnimatorTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animator);
		
		LinearLayout container = (LinearLayout) findViewById(R.id.container);
		container.addView(new MyAnimationView(this));
	}
	
	public class MyAnimationView extends View {

		public MyAnimationView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(AnimatorTest.this, R.animator.color_anim);
			colorAnim.setEvaluator(new ArgbEvaluator());
			colorAnim.setTarget(this);
			colorAnim.start();
		} 
		
	}
}
