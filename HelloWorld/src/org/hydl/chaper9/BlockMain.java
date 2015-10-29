package org.hydl.chaper9;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.android.internal.telephony.ITelephony;

public class BlockMain extends Activity {

	// 记录黑名单的List
	ArrayList<String> blockList = new ArrayList<String>();
	TelephonyManager tManager;
	// 监听通话状态的监听器
	CustomPhoneCallListener cpListener;

	public class CustomPhoneCallListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String number) {
			// TODO Auto-generated method stub
			// super.onCallStateChanged(state, number);
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				if (isBlock(number)) {
					try {
						Method method = Class.forName(
								"android.os.ServiceManager").getMethod(
								"getService", String.class);
						// 获取远程TELEPHONY_SERVICE的IBinder对象的代理
						IBinder binder = (IBinder) method.invoke(null,
								new Object[] { TELEPHONY_SERVICE });
						// 将IBinder对象的代理转换为ITelephony对象
						ITelephony telephony = ITelephony.Stub
								.asInterface(binder);
						// 挂断电话
						telephony.endCall();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				break;

			}
			super.onCallStateChanged(state, number);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blockmain);
		tManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		cpListener = new CustomPhoneCallListener();
		// 通过TelephonyManager监听通话状态的改变
		tManager.listen(cpListener, PhoneStateListener.LISTEN_CALL_STATE);
		Button btn_managerblock = (Button) findViewById(R.id.btn_managerblock);
		btn_managerblock.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Cursor cursor = getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null, null, null, null);
				BaseAdapter adapter = new BaseAdapter() {

					@Override
					public View getView(int position, View connvertView,
							ViewGroup group) {
						// TODO Auto-generated method stub
						cursor.moveToPosition(position);
						CheckBox rb = new CheckBox(BlockMain.this);
						// 获取联系人的电话号码,并去掉中间的中画线
						String number = cursor
								.getString(
										cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
								.replace("-", "");
						rb.setText(number);
						if(isBlock(number)) {
							rb.setChecked(true);
						}

						return rb;
					}

					@Override
					public long getItemId(int position) {
						// TODO Auto-generated method stub
						return position;
					}

					@Override
					public Object getItem(int position) {
						// TODO Auto-generated method stub
						return position;
					}

					@Override
					public int getCount() {
						// TODO Auto-generated method stub
						return cursor.getCount();
					}
				};
				
				View selectView = getLayoutInflater().inflate(R.layout.list, null);
				//获取selectView中的名为list的ListView组件
				final ListView listView = (ListView) selectView.findViewById(R.id.list);
				listView.setAdapter(adapter);
				
				new AlertDialog.Builder(BlockMain.this).setView(selectView).setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//清空blockList集合
						blockList.clear();
						//遍历listview组件的每个列表项
						for (int i = 0; i < listView.getCount(); i++) {
							CheckBox checkBox = (CheckBox) listView.getChildAt(i);
							//如果该列表项被勾选
							if(checkBox.isChecked()) {
								blockList.add(checkBox.getText().toString());
							}
						}
						System.out.println(blockList);
					}
				}).show();
				
			}
		});
		
	}
	
	//判断某个电话号码时候在黑名单之内
	public boolean isBlock(String phone) {
		for(String s1 : blockList) {
			if(s1.equals(phone)) {
				return true;
			}
		}
		return false;
	}
	
}
