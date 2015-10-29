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

	// ��¼��������List
	ArrayList<String> blockList = new ArrayList<String>();
	TelephonyManager tManager;
	// ����ͨ��״̬�ļ�����
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
						// ��ȡԶ��TELEPHONY_SERVICE��IBinder����Ĵ���
						IBinder binder = (IBinder) method.invoke(null,
								new Object[] { TELEPHONY_SERVICE });
						// ��IBinder����Ĵ���ת��ΪITelephony����
						ITelephony telephony = ITelephony.Stub
								.asInterface(binder);
						// �Ҷϵ绰
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
		// ͨ��TelephonyManager����ͨ��״̬�ĸı�
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
						// ��ȡ��ϵ�˵ĵ绰����,��ȥ���м���л���
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
				//��ȡselectView�е���Ϊlist��ListView���
				final ListView listView = (ListView) selectView.findViewById(R.id.list);
				listView.setAdapter(adapter);
				
				new AlertDialog.Builder(BlockMain.this).setView(selectView).setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						//���blockList����
						blockList.clear();
						//����listview�����ÿ���б���
						for (int i = 0; i < listView.getCount(); i++) {
							CheckBox checkBox = (CheckBox) listView.getChildAt(i);
							//������б����ѡ
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
	
	//�ж�ĳ���绰����ʱ���ں�����֮��
	public boolean isBlock(String phone) {
		for(String s1 : blockList) {
			if(s1.equals(phone)) {
				return true;
			}
		}
		return false;
	}
	
}
