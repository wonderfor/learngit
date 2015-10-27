package org.hydl.chaper9;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BindService extends Service {
	
	private int count;
	private boolean quit;
	private MyBinder binder = new MyBinder();

	public class MyBinder extends Binder{
		public int getCount() {
			return count;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return binder;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("Service is Created");
		//����һ���߳�,��̬�޸�count״ֵ̬
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(!quit) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
					
					count++;
				}
			}
		}.start();
	}
	
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("Service is UnBinded");
		return true;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.quit = true;
		System.out.println("Service is Destoryed");
	}
	

}