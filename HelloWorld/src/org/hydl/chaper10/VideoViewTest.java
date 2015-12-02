package org.hydl.chaper10;

import java.io.File;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewTest extends Activity {
	
	VideoView videoView;
	MediaController mController;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(R.layout.activity_videoview);
		videoView = (VideoView) findViewById(R.id.video);
		mController = new MediaController(this);
		File video = new File("/mnt/sdcard/movie.mp4");
		if (video.exists()) {
			videoView.setVideoPath(video.getAbsolutePath());
			videoView.setMediaController(mController);
			mController.setMediaPlayer(videoView);
			videoView.requestFocus();
		}
		
	}
}
