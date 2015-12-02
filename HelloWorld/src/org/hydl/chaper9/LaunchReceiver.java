package org.hydl.chaper9;

import org.hydl.helloworld.BaseActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LaunchReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Intent tIntent = new Intent();
		tIntent.setAction("org.hydl.chaper9.LaunchService");
		//Æô¶¯Ö¸¶¨Service
		context.startService(tIntent);
		
		/*
		Intent  i = new Intent(context,BaseActivity.class);
		context.startActivity(i);
		*/
	}

}
