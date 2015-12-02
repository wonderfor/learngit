package org.hydl.chaper9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "接收到的Intent的action为:" + intent.getAction() + "\n消息内容是:" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
		//创建一个Bundle对象,并存入数据
		Bundle bundle = new Bundle();
		bundle.putString("first", "第一个BroadcastReceiver存入的消息");
		//将bundle放入结果中
		setResultExtras(bundle);
		//取消Broadcast的继续传播
		//abortBroadcast();
	}

}
