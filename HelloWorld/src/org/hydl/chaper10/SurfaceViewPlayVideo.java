package org.hydl.chaper10;

import java.io.IOException;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;

public class SurfaceViewPlayVideo extends Activity implements OnClickListener {

	SurfaceView surfaceView;
	ImageButton play, pause, stop;
	MediaPlayer mPlayer;
	// 记录当前视频的播放位置
	int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surfaceviewplayvideo);
		// 获取界面中的三个按钮
		play = (ImageButton) findViewById(R.id.play);
		pause = (ImageButton) findViewById(R.id.pause);
		stop = (ImageButton) findViewById(R.id.stop);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		stop.setOnClickListener(this);
		mPlayer = new MediaPlayer();
		surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
		surfaceView.getHolder().setKeepScreenOn(true);
		surfaceView.getHolder().addCallback(new SurfaceListener());

	}

	@Override
	public void onClick(View source) {
		// TODO Auto-generated method stub
		try {
			switch (source.getId()) {
			case R.id.play:
				play();
				break;
			case R.id.pause:
				if (mPlayer.isPlaying()) {
					mPlayer.pause();
				} else {
					mPlayer.start();
				}
				break;
			case R.id.stop:
				if (mPlayer.isPlaying())
					mPlayer.stop();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void play() throws IOException {
		mPlayer.reset();
		mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mPlayer.setDataSource("/mnt/sdcard/movie.mp4");
		mPlayer.setDisplay(surfaceView.getHolder());
		mPlayer.prepare();
		WindowManager wManager = getWindowManager();
		DisplayMetrics metrics = new DisplayMetrics();
		wManager.getDefaultDisplay().getMetrics(metrics);
		surfaceView.setLayoutParams(new LayoutParams(metrics.widthPixels,
				mPlayer.getVideoHeight() * metrics.widthPixels
						/ mPlayer.getVideoWidth()));
		mPlayer.start();
	}

	private class SurfaceListener implements SurfaceHolder.Callback {
		
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub

		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			if (position > 0) {
				try {
					// 开始播放
					play();
					// 并直接从指定位置开始播放
					mPlayer.seekTo(position);
					position = 0;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub

		}

	}
	
	protected void onPause() {
		if (mPlayer.isPlaying()) {
			position = mPlayer.getCurrentPosition();
		}
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if(mPlayer.isPlaying()) mPlayer.stop();
		mPlayer.release();
		super.onDestroy();
	}

}
