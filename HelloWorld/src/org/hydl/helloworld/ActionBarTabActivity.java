package org.hydl.helloworld;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ActionBarTabActivity extends Activity implements
		ActionBar.TabListener {

	private static final String SELECTED_ITEM = "selected_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionbartab);
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar
				.addTab(actionBar.newTab().setText("��һҳ").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("�ڶ�ҳ").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("����ҳ").setTabListener(this));
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmenttransaction) {
		// TODO Auto-generated method stub
		Fragment fragment = new DummyFragment();
		Bundle args = new Bundle();
		args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
		fragment.setArguments(args);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, fragment);
		ft.commit();
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// ѡ��ǰ�汣���������Ӧ��Fragment��
		getActionBar().setSelectedNavigationItem(
				savedInstanceState.getInt(SELECTED_ITEM));
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		//����ǰѡ�е�Fragmentҳ���������浽bundle��
		outState.putInt(SELECTED_ITEM, getActionBar().getSelectedNavigationIndex());
	}
}
