package org.hydl.chaper9;

import java.util.Timer;
import java.util.TimerTask;

import org.hydl.chaper9.ICat.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/***
 * �ͻ��˰�������ͷ����һ��
 * ���ҿͻ���org.hydl.chaper9��ֻ����aidl�ļ�
 * @author Administrator
 *
 */
public class AidlService extends Service {

	private CatBinder catBinder;
	Timer timer = new Timer();
	String[] colors = new String[] { "��ɫ", "��ɫ", "��ɫ" };
	double[] weights = new double[] { 2.3, 3.1, 1.58 };
	private String color ;
	private double weight;

	public class CatBinder extends Stub {

		@Override
		public String getColor() throws RemoteException {
			// TODO Auto-generated method stub
			return color;
		}

		@Override
		public double getWeight() throws RemoteException {
			// TODO Auto-generated method stub
			return weight;
		}
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return catBinder;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		catBinder = new CatBinder();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int rand = (int)(Math.random()*3);
				color = colors[rand];
				weight = weights[rand];
				System.out.println("--------" + rand);
			}
		}, 0,800);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		timer.cancel();
	}
	
	

}