package org.hydl.chaper10;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MultiThreadClient extends Activity {
	
	EditText input;
	TextView show;
	Button send;
	Handler handler;
	ClentThread clientThread;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiclient);
		input = (EditText) findViewById(R.id.input);
		send = (Button) findViewById(R.id.send);
		show = (TextView) findViewById(R.id.show);
		handler = new Handler() {
			public void handleMessage(Message msg) {
				if(msg.what == 0x123) {
					show.append("\n" + msg.obj.toString());
				}
			}
		};
		
		clientThread = new ClentThread(handler);
		new Thread(clientThread).start();
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Message msg = new Message();
					msg.what = 0x345;
					msg.obj = input.getText().toString();
					clientThread.revHandler.sendMessage(msg);
					input.setText("");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
