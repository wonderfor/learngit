package org.hydl.chaper10;

import java.util.HashMap;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SoundPoolTest extends Activity implements OnClickListener{
	
	Button bomb,shot,arraw;
	SoundPool soundPool;
	HashMap<Integer, Integer> soundMap = new HashMap<Integer, Integer>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soundpool);
		bomb = (Button) findViewById(R.id.btn_bomb);
		shot = (Button) findViewById(R.id.btn_shot);
		arraw = (Button) findViewById(R.id.btn_arraw);
		
		soundPool = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
		soundMap.put(1, soundPool.load(this, R.raw.bomb,1));
		soundMap.put(2, soundPool.load(this, R.raw.shot,1));
		soundMap.put(3, soundPool.load(this, R.raw.arrow,1));
		bomb.setOnClickListener(this);
		shot.setOnClickListener(this);
		arraw.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_bomb:
			soundPool.play(soundMap.get(1), 1, 1, 0, 0, 1);
			break;
		case R.id.btn_shot:
			soundPool.play(soundMap.get(2), 1, 1, 0, 0, 1);
			break;
		case R.id.btn_arraw:
			soundPool.play(soundMap.get(3), 1, 1, 0, 0, 1);
			break;
		default:
			break;
		}
	}
}
