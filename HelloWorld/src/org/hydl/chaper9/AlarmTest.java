package org.hydl.chaper9;

import java.util.Calendar;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmTest extends Activity {

	Button setTime;
	AlarmManager aManger;
	Calendar currentTime = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarmtest);
		// ��ȡ�������İ�ť
		setTime = (Button) findViewById(R.id.btn_settime);
		// ��ȡAlarmManager����
		aManger = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
		// Ϊ"��������"��ť�󶨼�����
		setTime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar currentTime = Calendar.getInstance();
				// ����һ��TimePickerDialogʵ��,��������ʾ����
				new TimePickerDialog(AlarmTest.this, 0,
						new OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker tp, int hourOfDay,
									int minute) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(AlarmTest.this,
										AlarmActivity.class);
								// ����PendingIntent����
								PendingIntent pi = PendingIntent.getActivity(
										AlarmTest.this, 0, intent, 0);
								Calendar c = Calendar.getInstance();
								c.setTimeInMillis(System.currentTimeMillis());
								c.set(Calendar.HOUR, hourOfDay);
								c.set(Calendar.MINUTE, minute);
								// ����AlarmManager����Calendar��Ӧ��ʱ������ָ�����
								aManger.set(AlarmManager.RTC_WAKEUP,
										c.getTimeInMillis(), pi);
								// ��ʾ�������óɹ�����ʾ��Ϣ
								Toast.makeText(AlarmTest.this, "�������óɹ���",
										Toast.LENGTH_SHORT).show();
							}
						}, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
								.get(Calendar.MINUTE), true).show();
			}
		});
	}
}
