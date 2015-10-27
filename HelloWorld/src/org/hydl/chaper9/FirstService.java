package org.hydl.chaper9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FirstService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * Service被创建时回调该方法
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("Serivce is Created");
	}
	
	/*
	 * Service被启动时回调该方法
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("Service is Started");
		return START_STICKY;
	}
	
	/*
	 * Service被关闭之前回调
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("Service is Stoped");
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return true;
	}

}
