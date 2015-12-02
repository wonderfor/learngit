package org.hydl.chaper9;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MusicBox extends Activity implements OnClickListener{
	
	//获取界面中显示歌曲标题,作者文本框
	TextView title,author;
	//播放,暂停,停止按钮
	ImageButton play,stop;
	ActivityReceiver activityReceiver;
	public static final String CTL_ACTION = "org.hydl.chaper9.action.CTL_ACTION";
	public static final String UPDATE_ACTION = "org.hydl.chaper9.action.UPDATE_ACTION";
	//定义音乐的播放状态,0x11代表没有播放;0x12代表正在播放;0x13代表暂停
	int status = 0x11;
	String[] titles = new String[]{"心愿","约定","美丽新世界"};
	String[] authorStrs = new String[]{"未知艺术家","周蕙","伍佰"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_musicbox);
		
		//获取界面中的两个按钮
		play = (ImageButton) findViewById(R.id.play);
		stop = (ImageButton) findViewById(R.id.stop);
		title = (TextView) findViewById(R.id.title);
		author = (TextView) findViewById(R.id.author);
		//为两个按钮
		play.setOnClickListener(this);
		stop.setOnClickListener(this);
		activityReceiver = new ActivityReceiver();
		//创建IntentFilter
		IntentFilter filter = new IntentFilter();
		//指定BroadcastReceiver监听Action 
		filter.addAction(UPDATE_ACTION);
		//注册BroadcastReceiver
		registerReceiver(activityReceiver, filter);
		Intent intent = new Intent();
		intent.setAction("org.hydl.chaper9.MusicService");
		//启动后台Service
		startService(intent);
	}
	
	//自定义BroadcastReceiver,负责监听从Service传播回来的广播
	public class ActivityReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			//获取Intent中的update消息,update代表播放状态
			int update = intent.getIntExtra("update", -1);
			//获取Intent中的current消息,current代表当前正在播放的歌曲
			int current = intent.getIntExtra("current", -1);
			if(current >= 0) {
				title.setText(titles[current]);
				author.setText(authorStrs[current]);
			}
			
			switch (update) {
			case 0x11:
				play.setImageResource(R.drawable.play);
				//设置当前状态
				status = 0x11;
				break;
			//控制系统进入播放状态
			case 0x12:
				//播放状态下设置使用暂停图标
				play.setImageResource(R.drawable.pause);
				//设置当前状态
				status = 0x12;
				break;
			//控制系统进入暂停状态
			case 0x13:
				//暂停状态下使用播放图标
				play.setImageResource(R.drawable.play);
				//设置当前状态
				status = 0x13;
				break;
			default:
				break;
			}
		}
		
	}

	@Override
	public void onClick(View source) {
		// TODO Auto-generated method stub
		//创建Intent
		Intent intent = new Intent("org.hydl.chaper9.action.CTL_ACTION");
		switch (source.getId()) {
		//按下播放/暂停按钮
		case R.id.play:
			intent.putExtra("control", 1);
			break;
		//按下停止按钮
		case R.id.stop:
			intent.putExtra("control", 2);
			break;
		default:
			break;
		}
		//发送广播,将被Service组件中的BroadcastReceiver接收到
		sendBroadcast(intent);
	}
}
