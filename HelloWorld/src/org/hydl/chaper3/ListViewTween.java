package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ListView;

public class ListViewTween extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listviewtween);
		ListView list = (ListView) findViewById(R.id.lv01);
		WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrice = new DisplayMetrics();
		display.getMetrics(metrice);
		list.setAnimation(new MyAnimation(metrice.xdpi / 2, metrice.ydpi / 2, 3500));
	}
}
