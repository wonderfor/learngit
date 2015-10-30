package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class AudioTest extends Activity {
	
	Button play , up,down;
	ToggleButton mute;
	AudioManager aManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audiotest);
		aManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
		
		play = (Button) findViewById(R.id.btn_play);
		up = (Button) findViewById(R.id.btn_up);
		down = (Button) findViewById(R.id.btn_down);
		mute = (ToggleButton) findViewById(R.id.btn_mute);
		play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MediaPlayer mPlayer = MediaPlayer.create(AudioTest.this, R.raw.ring);
				mPlayer.setLooping(true);
				mPlayer.start();
			}
		});
		
		up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				aManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);
			}
		});
		
		down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				aManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER,AudioManager.FLAG_SHOW_UI);
			}
		});
		
		mute.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton source, boolean ischecked) {
				// TODO Auto-generated method stub
				aManager.setStreamMute(AudioManager.STREAM_MUSIC, ischecked);
			}
		});
		
	}
}
