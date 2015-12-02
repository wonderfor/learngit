package org.hydl.chaper10;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChaperTenActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chaperten);
		
		Button btn_mediaplayer = (Button) findViewById(R.id.btn_mediaplayer);
		btn_mediaplayer.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,MediaPlayerTest.class);
				startActivity(i);
			}
		});
		
		Button btn_soundpool = (Button) findViewById(R.id.btn_soundpool);
		btn_soundpool.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,SoundPoolTest.class);
				startActivity(i);
			}
		});
		
		Button btn_videoview = (Button) findViewById(R.id.btn_videoview);
		btn_videoview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,VideoViewTest.class);
				startActivity(i);
			}
		});
		
		Button btn_surfaceview = (Button) findViewById(R.id.btn_surfaceview);
		btn_surfaceview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,SurfaceViewPlayVideo.class);
				startActivity(i);
			}
		});
		
		Button btn_recordsound = (Button) findViewById(R.id.btn_recordsound);
		btn_recordsound.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,RecordSound.class);
				startActivity(i);
			}
		});
		
		Button btn_captureimage = (Button) findViewById(R.id.btn_captureimage);
		btn_captureimage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,CaptureImage.class);
				startActivity(i);
			}
		});
		
		Button btn_recordvideo = (Button) findViewById(R.id.btn_recordvideo);
		btn_recordvideo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,RecordVideo.class);
				startActivity(i);
			}
		});
		
		Button btn_polygon = (Button) findViewById(R.id.btn_polygon);
		btn_polygon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,Polygon.class);
				startActivity(i);
			}
		});
		
		Button btn_multiclient = (Button) findViewById(R.id.btn_multiclient);
		btn_multiclient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,MultiThreadClient.class);
				startActivity(i);
			}
		});
		
		Button btn_urltest = (Button) findViewById(R.id.btn_urltest);
		btn_urltest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,URLTest.class);
				startActivity(i);
			}
		});
		
		Button btn_getpostutil = (Button) findViewById(R.id.btn_getpostutil);
		btn_getpostutil.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChaperTenActivity.this,GetPostActivity.class);
				startActivity(i);
			}
		});
	}
}
