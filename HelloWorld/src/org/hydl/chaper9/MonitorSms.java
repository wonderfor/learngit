package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

public class MonitorSms extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		getContentResolver().registerContentObserver(
				Uri.parse("content://sms"), true,
				new SmsObserver(new Handler()));
	}

	private final class SmsObserver extends ContentObserver {

		public SmsObserver(Handler handler) {
			super(handler);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			Cursor cursor = getContentResolver().query(
					Uri.parse("content://sms/outbox"), null, null, null, null);
			while (cursor.moveToNext()) {
				StringBuilder sb = new StringBuilder();
				sb.append("address=").append(
						cursor.getString(cursor.getColumnIndex("address")));
				sb.append(";subject=").append(
						cursor.getString(cursor.getColumnIndex("subject")));
				sb.append(";body=").append(
						cursor.getString(cursor.getColumnIndex("body")));
				sb.append(";time=").append(
						cursor.getLong(cursor.getColumnIndex("date")));
				System.out.println("Has send SMS:" + sb.toString());
			}
		}

	}
}
