package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaPlayer;
import android.os.Bundle;

public class AlarmActivity extends Activity {
	
	MediaPlayer alarmMusic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//����ָ������,��Ϊ֮����MediaPlayer
		alarmMusic = MediaPlayer.create(this, R.raw.ring);
		alarmMusic.setLooping(true);
		//��������
		alarmMusic.start();
		//����һ���Ի���
		new AlertDialog.Builder(AlarmActivity.this).setTitle("����").setMessage("��������,GO!GO!GO!").setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//ֹͣ����
				alarmMusic.stop();
				//������Activity
				AlarmActivity.this.finish();
			}
		}).show();
	}
}
