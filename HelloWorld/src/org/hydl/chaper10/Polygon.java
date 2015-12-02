package org.hydl.chaper10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Polygon extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		GLSurfaceView glView = new GLSurfaceView(this);
		MyRenderer myRender = new MyRenderer();
		glView.setRenderer(myRender);
		setContentView(glView);
	}
}
