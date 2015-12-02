package org.hydl.chaper9;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;

public class MusicService extends Service {

	MyReceiver serviceReceiver;
	AssetManager am;
	String[] musics = new String[]{"wish.mp3","promise.mp3","beautiful.mp3"};
	MediaPlayer mPlayer;
	//��ǰ��״̬,0x11����û�в���;0x12�������ڲ���;0x13������ͣ
	int status = 0x11;
	//��¼��ǰ���ڲ��ŵ�����
	int current = 0;
	
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		am = getAssets();
		//����BroadcastReceiver
		serviceReceiver = new MyReceiver();
		//����IntentFilter
		IntentFilter filter = new IntentFilter();
		filter.addAction(MusicBox.CTL_ACTION);
		registerReceiver(serviceReceiver, filter);
		//����MediaPlayer
		mPlayer = new MediaPlayer();
		//ΪMediaPlayer��������¼��󶨼�����
		mPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				current++;
				if(current >= 3) {
					current = 0;
				}
				//���͹㲥֪ͨActivity�����ı���
				Intent sendIntent = new Intent(MusicBox.UPDATE_ACTION);
				sendIntent.putExtra("current", current);
				//���͹㲥,��Activity����е�BroadcastReceiver���յ�
				sendBroadcast(sendIntent);
				//׼������������
				prepareAndPlay(musics[current]);
			}
		});
		super.onCreate();
		
	}
	
	public class MyReceiver extends BroadcastReceiver {
		
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			int control = intent.getIntExtra("control", -1);
			switch (control) {
			//���Ż���ͣ
			case 1:
				//ԭ��û�в���״̬
				if(status == 0x11) {
					//׼������������
					prepareAndPlay(musics[current]);
					status = 0x12;
				//ԭ�����ڲ���״̬
				}else if(status == 0x12) {
					//��ͣ
					mPlayer.pause();
					//�ı�Ϊ��ͣ״̬
					status = 0x13;
				//ԭ��������ͣ״̬
				}else if(status == 0x13) {
					mPlayer.start();
					status = 0x12;
				}
				break;
			case 2:
				//���ԭ�����ڲ��Ż���ͣ
				if(status == 0x12 || status == 0x13) {
					//ֹͣ����
					mPlayer.stop();
					status = 0x11;
				}
			
			}
			//�㲥֪ͨActivity����ͼ��,�ı���
			Intent sendIntent = new Intent(MusicBox.UPDATE_ACTION);
			sendIntent.putExtra("update", status);
			sendIntent.putExtra("current", current);
			//���͹㲥,����Activity����е�BroadcastReceiver���յ�
			sendBroadcast(sendIntent);
		}
		
		
		
	}
	
	private void prepareAndPlay(String music) {
		try {
			//��ָ���ļ�
			AssetFileDescriptor afd = am.openFd(music);
			mPlayer.reset();
			//ʹ��MediaPlayer����ָ���������ļ�
			mPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
			//׼������
			mPlayer.prepare();
			//����
			mPlayer.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
