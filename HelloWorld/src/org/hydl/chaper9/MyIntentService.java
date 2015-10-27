package org.hydl.chaper9;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {

	
	public MyIntentService() {
		// TODO Auto-generated constructor stub
		super("MyIntentService");
	}
	
	
	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		long endTime = System.currentTimeMillis() + 20 * 1000;
		System.out.println("onStart");
		while (System.currentTimeMillis() < endTime) {
			synchronized (this) {
				try {
					wait(endTime - System.currentTimeMillis());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		
		System.out.println("耗时任务执行完成");
	}

}
