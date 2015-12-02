package org.hydl.chaper10;

import java.io.File;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class RecordSound extends Activity implements OnClickListener{
	ImageButton record,stop;
	File soundFile;
	MediaRecorder mRecorder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recordsound);
		record = (ImageButton) findViewById(R.id.record);
		stop = (ImageButton) findViewById(R.id.stop);
		record.setOnClickListener(this);
		stop.setOnClickListener(this);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		if(soundFile != null && soundFile.exists()) {
			mRecorder.stop();
			mRecorder.release();
			mRecorder = null;
		}
		
		super.onDestroy();
	}
	
	@Override
	public void onClick(View source) {
		// TODO Auto-generated method stub
		
		switch (source.getId()) {
		case R.id.record:
			if(!Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
				Toast.makeText(RecordSound.this, "SDø®≤ª¥Ê‘⁄,«Î≤Â»ÎSDø®",  Toast.LENGTH_LONG).show();
				return;
			}
			try {
				soundFile = new File(Environment.getExternalStorageDirectory().getCanonicalFile() + "/sound.amr");
				mRecorder = new MediaRecorder();
				mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				mRecorder.setOutputFile(soundFile.getAbsolutePath());
				mRecorder.prepare();
				mRecorder.start();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case R.id.stop:
			if(soundFile != null && soundFile.exists()) {
				mRecorder.stop();
				mRecorder.release();
				mRecorder = null;
			}
			break;

		default:
			break;
		}
		
	}
}
