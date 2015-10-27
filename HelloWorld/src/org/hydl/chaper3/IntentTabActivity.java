package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class IntentTabActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intenttab);

		TabHost tabHost = getTabHost();
		tabHost.addTab(tabHost
				.newTabSpec("tab1")
				.setIndicator("已接电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(new Intent(this, SchemeActivity.class)));
		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("呼出电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(new Intent(this, ActionDataActivity.class)));
		tabHost.addTab(tabHost
				.newTabSpec("tab3")
				.setIndicator("未接电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(new Intent(this, DateTypeActivity.class)));
		
		
	}
}
