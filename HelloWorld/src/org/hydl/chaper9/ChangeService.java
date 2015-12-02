package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;

public class ChangeService extends Service {

	
	//���嶨ʱ�����ı�ֽ��Դ
	int[] wallpapers = new int[]{R.drawable.back,R.drawable.bom1,R.drawable.bom2,R.drawable.bom3};
	//����ϵͳ�ı�ֽ�������
	WallpaperManager wManager;
	//���嵱ǰ����ʾ�ı�ֽ
	int current = 0;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		//����������һ��,ϵͳ���¿�ʼ
		if(current >= 4)
			current = 0;
		try {
			wManager.setResource(wallpapers[current++]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return START_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		wManager = WallpaperManager.getInstance(this);
	}

}
