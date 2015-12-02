package org.hydl.chaper10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ClentThread implements Runnable {
	
	private Socket s;
	private Handler handler;
	public Handler revHandler;
	BufferedReader br = null;
	OutputStream os = null;
	
	public ClentThread(Handler handler) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			s = new Socket("118.122.93.3", 30000);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();
			new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String content = null;
					try {
						while ((content = br.readLine()) != null) {
							Message msg = new Message();
							msg.what = 0x123;
							msg.obj = content;
							handler.sendMessage(msg);
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}					
				}
			}.start();
			//为当前线程初始化Looper
			Looper.prepare();
			
			//创建revHandler对象
			revHandler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					if(msg.what == 0x345) {
						try {
							os.write((msg.obj.toString() + "\r\n").getBytes("utf-8"));
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			};
			
			Looper.loop();
			
		} catch (SocketTimeoutException e) {
			// TODO: handle exception
			System.out.println("网络连接超时!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
