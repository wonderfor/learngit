package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DateTypeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datetype);
	}
	
	public void scheme(View source) {
		Intent i = new Intent();
		i.setData(Uri.parse("lee://www.baidu.com:1234/test"));
		startActivity(i);
	}
	
	public void schemeHostPort(View source) {
		Intent i = new Intent();
		i.setData(Uri.parse("lee://www.baidu.com:8888/test"));
		startActivity(i);
	}
	
	
	public void schemeHostPath(View source){
		Intent i = new Intent();
		i.setData(Uri.parse("lee://www.baidu.com:1234/mypath"));
		startActivity(i);
	}
	
	public void schemeHostPortPath(View source){
		Intent i = new Intent();
		i.setData(Uri.parse("lee://www.baidu.com:8888/mypath"));
		startActivity(i);
	}
	
	public void schemeHostPortPathType(View source) {
		Intent i = new Intent();
		i.setDataAndType(Uri.parse("lee://www.baidu.com:8888/mypath"),"abc/xyz");
		startActivity(i);
	}
}
