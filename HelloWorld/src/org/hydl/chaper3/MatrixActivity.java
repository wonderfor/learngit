package org.hydl.chaper3;

import android.app.Activity;
import android.os.Bundle;

public class MatrixActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new MatrixView(this,null));
	}
}
