package org.hydl.helloworld;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabhost);
		TabHost tabHost = getTabHost();
		TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("�ѽӵ绰")
				.setContent(R.id.tab01);
		tabHost.addTab(tab1);
		TabSpec tab2 = tabHost
				.newTabSpec("tab2")
				.setIndicator("�����绰",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02);
		tabHost.addTab(tab2);
		TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("δ�ӵ绰")
				.setContent(R.id.tab03);
		tabHost.addTab(tab3);

	}
}
