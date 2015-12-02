package org.hydl.chaper9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "接收到的intent的Action为:" + intent.getAction() + "\n 消息内容是:" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
	}

}
