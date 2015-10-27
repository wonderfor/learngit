package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class PlayGameActivity extends Activity {

	private int speed = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//去掉窗口标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏显示
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//创建 PlaneView对象
		final PlaneView planeView = new PlaneView(this);
		setContentView(planeView);
		planeView.setBackgroundResource(R.drawable.bom1);
		//获取窗口管理器
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		//获取屏幕宽高
		display.getMetrics(metrics);
		planeView.currentX = metrics.widthPixels / 2;
		planeView.currentY = metrics.heightPixels - 40;
		planeView.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View source, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_S:
					planeView.currentY += speed;
					break;
				case KeyEvent.KEYCODE_W:
					planeView.currentY -= speed;
					break;
				case KeyEvent.KEYCODE_A:
					planeView.currentX -= speed;
					break;
				case KeyEvent.KEYCODE_D:
					planeView.currentX += speed;
					break;
				default:
					break;
				}
				
				planeView.invalidate();
				return true;
			}
		});
		
	}
}
