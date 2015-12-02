package org.hydl.chaper10;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class URLTest extends Activity {
	
	ImageView show;
	Bitmap bitmap;
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if(msg.what == 0x123) {
				show.setImageBitmap(bitmap);
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_urltest);
		show = (ImageView) findViewById(R.id.show);
		new Thread() {
			public void run() {
				try {
					URL url = new URL("http://www.shuadu.cn/por-flash/tripstory183.jpg");
					InputStream is = url.openStream();
					bitmap = BitmapFactory.decodeStream(is);
					handler.sendEmptyMessage(0x123);
					is.close();
					is = url.openStream();
					OutputStream os = openFileOutput("hydl.jpg", MODE_WORLD_READABLE);
					byte[] buff = new byte[1024];
					int hasRead = 0;
					while ((hasRead = is.read(buff)) > 0) {
						os.write(buff,0,hasRead);
					}
					is.close();
					os.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			};
		}.start();
		
	}
}
