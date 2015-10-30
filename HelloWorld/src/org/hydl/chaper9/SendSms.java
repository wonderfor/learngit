package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSms extends Activity {

	EditText number, content;
	Button send;
	SmsManager sManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sendsms);
		sManager = SmsManager.getDefault();
		number = (EditText) findViewById(R.id.et_phone);
		content = (EditText) findViewById(R.id.et_sms);
		send = (Button) findViewById(R.id.btn_send);
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				PendingIntent pi = PendingIntent.getActivity(SendSms.this, 0,
						new Intent(), 0);
				sManager.sendTextMessage(number.getText().toString(), null,
						content.getText().toString(), pi, null);
				Toast.makeText(SendSms.this, "短信发送完成", Toast.LENGTH_LONG)
						.show();
			}
		});
	}
}
