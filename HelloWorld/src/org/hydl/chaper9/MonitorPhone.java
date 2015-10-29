package org.hydl.chaper9;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MonitorPhone extends Activity {
	
	TelephonyManager tManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line);
		
		tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		//创建一个通话状态监听器
		PhoneStateListener listener = new PhoneStateListener() {
			@Override
			public void onCallStateChanged(int state, String number) {
				// TODO Auto-generated method stub
				switch (state) {
				//无任何状态
				case TelephonyManager.CALL_STATE_IDLE:
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK:
					break;
				//来电响铃时
				case TelephonyManager.CALL_STATE_RINGING:
					OutputStream os = null;
					try {
						os = openFileOutput("phoneList", MODE_APPEND);
					} catch (FileNotFoundException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					PrintStream ps = new PrintStream(os);
					//将来电号码记录到文件中
					ps.println(new Date() + "来电" + number);
					ps.close();
					break;
				default:
					break;
				}
				super.onCallStateChanged(state, number);
			}
		};
		
		tManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
	}
}
