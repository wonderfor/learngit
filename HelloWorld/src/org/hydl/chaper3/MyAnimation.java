package org.hydl.chaper3;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {
	private float centerX;
	private float centerY;
	//���嶯���ĳ����¼�
	private int duration;
	private Camera camera = new Camera();
	public MyAnimation(float x,float y,int duration) {
		// TODO Auto-generated constructor stub
		this.centerX = x;
		this.centerY = y;
		this.duration = duration;
	}
	
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		// TODO Auto-generated method stub
		super.initialize(width, height, parentWidth, parentHeight);
		//���ö��������¼�
		setDuration(duration);
		//���ö���������Ч������
		setFillAfter(true);
		setInterpolator(new LinearInterpolator());
	}
	
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// TODO Auto-generated method stub
		super.applyTransformation(interpolatedTime, t);
		camera.save();
		camera.translate(100.0f - 100.0f * interpolatedTime, 150.0f * interpolatedTime - 150,
				80.0f - 80.0f * interpolatedTime);
		camera.rotateX(360 * (interpolatedTime));
		camera.rotateY((360 * interpolatedTime));
		Matrix matrix = t.getMatrix();
		camera.getMatrix(matrix);
		matrix.preTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
		camera.restore();
	}
}
