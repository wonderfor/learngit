package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MusicBox extends Activity implements OnClickListener{
	
	//��ȡ��������ʾ��������,�����ı���
	TextView title,author;
	//����,��ͣ,ֹͣ��ť
	ImageButton play,stop;
	ActivityReceiver activityReceiver;
	public static final String CTL_ACTION = "org.hydl.chaper9.action.CTL_ACTION";
	public static final String UPDATE_ACTION = "org.hydl.chaper9.action.UPDATE_ACTION";
	//�������ֵĲ���״̬,0x11����û�в���;0x12�������ڲ���;0x13������ͣ
	int status = 0x11;
	String[] titles = new String[]{"��Ը","Լ��","����������"};
	String[] authorStrs = new String[]{"δ֪������","��ޥ","���"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_musicbox);
		
		//��ȡ�����е�������ť
		play = (ImageButton) findViewById(R.id.play);
		stop = (ImageButton) findViewById(R.id.stop);
		title = (TextView) findViewById(R.id.title);
		author = (TextView) findViewById(R.id.author);
		//Ϊ������ť
		play.setOnClickListener(this);
		stop.setOnClickListener(this);
		activityReceiver = new ActivityReceiver();
		//����IntentFilter
		IntentFilter filter = new IntentFilter();
		//ָ��BroadcastReceiver����Action 
		filter.addAction(UPDATE_ACTION);
		//ע��BroadcastReceiver
		registerReceiver(activityReceiver, filter);
		Intent intent = new Intent();
		intent.setAction("org.hydl.chaper9.MusicService");
		//������̨Service
		startService(intent);
	}
	
	//�Զ���BroadcastReceiver,���������Service���������Ĺ㲥
	public class ActivityReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			//��ȡIntent�е�update��Ϣ,update������״̬
			int update = intent.getIntExtra("update", -1);
			//��ȡIntent�е�current��Ϣ,current����ǰ���ڲ��ŵĸ���
			int current = intent.getIntExtra("current", -1);
			if(current >= 0) {
				title.setText(titles[current]);
				author.setText(authorStrs[current]);
			}
			
			switch (update) {
			case 0x11:
				play.setImageResource(R.drawable.play);
				//���õ�ǰ״̬
				status = 0x11;
				break;
			//����ϵͳ���벥��״̬
			case 0x12:
				//����״̬������ʹ����ͣͼ��
				play.setImageResource(R.drawable.pause);
				//���õ�ǰ״̬
				status = 0x12;
				break;
			//����ϵͳ������ͣ״̬
			case 0x13:
				//��ͣ״̬��ʹ�ò���ͼ��
				play.setImageResource(R.drawable.play);
				//���õ�ǰ״̬
				status = 0x13;
				break;
			default:
				break;
			}
		}
		
	}

	@Override
	public void onClick(View source) {
		// TODO Auto-generated method stub
		//����Intent
		Intent intent = new Intent("org.hydl.chaper9.action.CTL_ACTION");
		switch (source.getId()) {
		//���²���/��ͣ��ť
		case R.id.play:
			intent.putExtra("control", 1);
			break;
		//����ֹͣ��ť
		case R.id.stop:
			intent.putExtra("control", 2);
			break;
		default:
			break;
		}
		//���͹㲥,����Service����е�BroadcastReceiver���յ�
		sendBroadcast(intent);
	}
}
