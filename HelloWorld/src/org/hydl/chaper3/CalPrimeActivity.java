package org.hydl.chaper3;

import java.util.ArrayList;
import java.util.List;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalPrimeActivity extends Activity {

	static final String UPPER_NUM = "upper";
	EditText etNum;
	CalThread calThread;

	// 定义一个线程类
	class CalThread extends Thread {
		public Handler handler;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Looper.prepare();
			handler = new Handler() {
				public void handleMessage(Message msg) {
					if (msg.what == 0x123) {
						int upper = msg.getData().getInt(UPPER_NUM);
						List<Integer> nums = new ArrayList<Integer>();
						outer: for (int i = 2; i <= upper; i++) {
							for (int j = 2; j <= Math.sqrt(i); j++) {
								if (i != 2 && i % j == 0) {
									continue outer;
								}
							}
							nums.add(i);
						}
						Toast.makeText(CalPrimeActivity.this, nums.toString(),
								Toast.LENGTH_LONG).show();
					}
				}

			};
			Looper.loop();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calprime);
		etNum = (EditText) findViewById(R.id.editCal);
		calThread = new CalThread();
		calThread.start();
	}
	
	public void cal(View source) {
		Message msg = new Message();
		msg.what = 0x123;
		Bundle bundle = new Bundle();
		bundle.putInt(UPPER_NUM,Integer.parseInt(etNum.getText().toString()));
		msg.setData(bundle);
		calThread.handler.sendMessage(msg);
	}
	
}
