package org.hydl.chaper8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SDCardTest extends Activity {
	
	final String FILE_NAME = "/hydl.bin";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filetest);
		Button read = (Button) findViewById(R.id.read);
		Button write = (Button) findViewById(R.id.write);
		final EditText edit_read = (EditText) findViewById(R.id.edit_read);
		final EditText edit_write = (EditText) findViewById(R.id.edit_write);
		write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				write(edit_write.getText().toString());
				edit_write.setText("");
			}
		});
		
		read.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				edit_read.setText(read());
			}
		});
		
	}
	
	private String read() {
		try {
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				File sdCardDir = Environment.getExternalStorageDirectory();
				FileInputStream fis = new FileInputStream(sdCardDir.getCanonicalPath() + FILE_NAME);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				StringBuilder sb = new StringBuilder("");
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	private void write(String content) {
		try {
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				File sdCardDir =  Environment.getExternalStorageDirectory();
				File targetFile = new File(sdCardDir.getCanonicalPath() + FILE_NAME);
				RandomAccessFile raf = new RandomAccessFile(targetFile, "rw");
				raf.seek(targetFile.length());
				content = content + "\n";
				raf.write(content.getBytes());
				raf.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
