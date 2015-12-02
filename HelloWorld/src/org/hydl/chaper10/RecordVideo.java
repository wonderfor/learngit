package org.hydl.chaper10;

import java.io.File;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class RecordVideo extends Activity implements OnClickListener{
	
	ImageButton record,stop;
	File videoFile;
	MediaRecorder mRecorder;
	SurfaceView sView;
	private boolean isRecording = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recordvideo);
		
		record = (ImageButton) findViewById(R.id.record);
		stop = (ImageButton) findViewById(R.id.stop);
		stop.setEnabled(false);
		record.setOnClickListener(this);
		stop.setOnClickListener(this);
		sView = (SurfaceView) findViewById(R.id.sView);
		sView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		sView.getHolder().setFixedSize(320, 480);
		sView.getHolder().setKeepScreenOn(true);
	}

	@Override
	public void onClick(View source) {
		// TODO Auto-generated method stub
		switch (source.getId()) {
		case R.id.record:
			if(!Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
				Toast.makeText(RecordVideo.this, "SDø®≤ª¥Ê‘⁄,«Î≤Â»ÎSDø®!", Toast.LENGTH_LONG).show();
				return;
			}
			try {
				videoFile = new File(Environment.getExternalStorageDirectory().getCanonicalFile() + "/myvideo.mp4");
				mRecorder = new MediaRecorder();
				mRecorder.reset();
				mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				mRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
				mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
				mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
				mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
				//mRecorder.setVideoSize(320, 480);
				//mRecorder.setVideoFrameRate(4);
				mRecorder.setOutputFile(videoFile.getAbsolutePath());
				mRecorder.setPreviewDisplay(sView.getHolder().getSurface());
				mRecorder.prepare();
				mRecorder.start();
				System.out.println("-----recording------");
				record.setEnabled(false);
				stop.setEnabled(true);
				isRecording = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case R.id.stop:
			if(isRecording) {
				mRecorder.stop();
				mRecorder.release();
				mRecorder = null;
				record.setEnabled(true);
				stop.setEnabled(false);
			}
			break;
		default:
			break;
		}
	}
}
