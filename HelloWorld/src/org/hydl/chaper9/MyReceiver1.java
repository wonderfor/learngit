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
		Toast.makeText(context, "���յ���Intent��actionΪ:" + intent.getAction() + "\n��Ϣ������:" + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
		//����һ��Bundle����,����������
		Bundle bundle = new Bundle();
		bundle.putString("first", "��һ��BroadcastReceiver�������Ϣ");
		//��bundle��������
		setResultExtras(bundle);
		//ȡ��Broadcast�ļ�������
		//abortBroadcast();
	}

}
