package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlarmChangeWallpaper extends Activity {

	// ����AlarmManager����
	AlarmManager aManager;
	Button start, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wall);
		start = (Button) findViewById(R.id.btn_start);
		stop = (Button) findViewById(R.id.btn_stop);
		aManager = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
		// ָ������ChangeService���
		Intent intent = new Intent();
		intent.setAction("org.hydl.chaper9.changeservice");
		// ����PendingIntent����
		final PendingIntent pi = PendingIntent.getService(
				AlarmChangeWallpaper.this, 0, intent, 0);
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//����ÿ��5��ִ��pi��������һ��
				aManager.setRepeating(AlarmManager.RTC_WAKEUP, 0, 5000, pi);
				start.setEnabled(false);
				stop.setEnabled(true);
				Toast.makeText(AlarmChangeWallpaper.this, "��ֽ��ʱ���������ɹ���", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				start.setEnabled(true);
				stop.setEnabled(false);
				//ȡ����pi�ĵ���
				aManager.cancel(pi);
			}
		});

	}
}
