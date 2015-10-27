package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DrawViewActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawview);
		Button btn_changeori = (Button) findViewById(R.id.btn_changeori);
		btn_changeori.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Configuration config = getResources().getConfiguration();
				if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
					DrawViewActivity.this
							.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
				if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
					DrawViewActivity.this
							.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕"
				: "竖向屏幕";
		Toast.makeText(DrawViewActivity.this,
				"系统屏幕方向改变" + "\n 修改后的屏幕方向为:" + screen, Toast.LENGTH_SHORT)
				.show();
	}
}
