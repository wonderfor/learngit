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
		// 获取程序界面的按钮
		setTime = (Button) findViewById(R.id.btn_settime);
		// 获取AlarmManager对象
		aManger = (AlarmManager) getSystemService(Service.ALARM_SERVICE);
		// 为"设置闹铃"按钮绑定监听器
		setTime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar currentTime = Calendar.getInstance();
				// 创建一个TimePickerDialog实例,并把它显示出来
				new TimePickerDialog(AlarmTest.this, 0,
						new OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker tp, int hourOfDay,
									int minute) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(AlarmTest.this,
										AlarmActivity.class);
								// 创建PendingIntent对象
								PendingIntent pi = PendingIntent.getActivity(
										AlarmTest.this, 0, intent, 0);
								Calendar c = Calendar.getInstance();
								c.setTimeInMillis(System.currentTimeMillis());
								c.set(Calendar.HOUR, hourOfDay);
								c.set(Calendar.MINUTE, minute);
								// 设置AlarmManager将在Calendar对应的时间启动指定组件
								aManger.set(AlarmManager.RTC_WAKEUP,
										c.getTimeInMillis(), pi);
								// 显示闹铃设置成功的提示信息
								Toast.makeText(AlarmTest.this, "闹铃设置成功啦",
										Toast.LENGTH_SHORT).show();
							}
						}, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
								.get(Calendar.MINUTE), true).show();
			}
		});
	}
}
