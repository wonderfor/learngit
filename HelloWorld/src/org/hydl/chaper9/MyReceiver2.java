package org.hydl.chaper9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = getResultExtras(true);
		//����ǰһ��BroadcastReceiver�������keyΪfirst����Ϣ
		String first = bundle.getString("first");
		Toast.makeText(context, "��һ��Broadcast�������ϢΪ :" + first, Toast.LENGTH_LONG).show();
	}

}
