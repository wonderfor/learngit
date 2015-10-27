package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RawResTest extends Activity {
	
	MediaPlayer mp1 = null;
	MediaPlayer mp2 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rawres);
		
		mp1 = MediaPlayer.create(this, R.raw.bomb);
		AssetManager am = getAssets();
		try {
			AssetFileDescriptor afd = am.openFd("shot.mp3");
			mp2 = new MediaPlayer();
			mp2.setDataSource(afd.getFileDescriptor());
			mp2.prepare();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Button bn1 = (Button) findViewById(R.id.btn_open1);
		bn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				mp1.start();
			}
		});
		
		Button bn2 = (Button) findViewById(R.id.btn_open2);
		bn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				mp2.start();
			}
		});
		
	}
}

