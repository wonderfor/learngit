package org.hydl.chaper3;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class LaunchersActivity extends LauncherActivity {
	
	String[] names = new String[]{"���ó������","�鿴�Ǽʱ���"};
	//��������Activity��Ӧ��ʵ����
	Class<?>[] clazzs = {PreferencesActivity.class,ExpandableListsActivity.class};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
		setListAdapter(adapter);
	}
	
	@Override
	protected Intent intentForPosition(int position) {
		// TODO Auto-generated method stub
		return new Intent(LaunchersActivity.this,clazzs[position]);
	}
}
