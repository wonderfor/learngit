package org.hydl.chaper8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FileTest extends Activity {
	
	final String FILE_NAME = "hydl.bin";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filetest);
		System.out.println(new StringBuilder("a").append("b").append("c").toString());
		Button read = (Button) findViewById(R.id.read);
		Button write = (Button) findViewById(R.id.write);
		final EditText readt = (EditText) findViewById(R.id.edit_read);
		final EditText writet = (EditText) findViewById(R.id.edit_write);
		write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				write(writet.getText().toString());
				writet.setText(""); 
			}
		});
		read.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				readt.setText(read());
			}
		});
	}
	
	private String read() {
		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			byte[] buff = new byte[1024];
			int hasRead = 0;
			StringBuilder sb = new StringBuilder("");
			while ((hasRead = fis.read(buff))> 0 ) {
				sb.append(new String(buff , 0 ,hasRead));
			}
			fis.close();
			return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	private void write(String content)  {
		try {
			FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
			PrintStream ps = new PrintStream(fos);
			ps.println(content);
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
