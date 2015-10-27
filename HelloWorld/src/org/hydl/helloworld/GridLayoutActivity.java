package org.hydl.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLayoutActivity extends Activity {

	GridLayout gridLayout;
	// 定义16个按钮的文本
	String[] chars = new String[] { "7", "8", "9", "÷", "4", "5", "6", "x",
			"1", "2", "3", "-", ".", "0", "=", "+" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_grid);
		gridLayout = (GridLayout) findViewById(R.id.gridlayout);
		for(int i = 0 ; i < chars.length ; i ++) {
			Button bn = new Button(this);
			bn.setText(chars[i]);
			bn.setTextSize(40);
			GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
			GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
			params.setGravity(Gravity.FILL);
			gridLayout.addView(bn, params);
		}
	}
	
	
}
