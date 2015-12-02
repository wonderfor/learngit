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
		//加载指定音乐,并为之创建MediaPlayer
		alarmMusic = MediaPlayer.create(this, R.raw.ring);
		alarmMusic.setLooping(true);
		//播放音乐
		alarmMusic.start();
		//创建一个对话框
		new AlertDialog.Builder(AlarmActivity.this).setTitle("闹钟").setMessage("闹钟响了,GO!GO!GO!").setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//停止音乐
				alarmMusic.stop();
				//结束该Activity
				AlarmActivity.this.finish();
			}
		}).show();
	}
}
