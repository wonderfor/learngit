package org.hydl.chaper9;

import java.util.ArrayList;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class GroupSend extends Activity {

	EditText numbers, content;
	Button select, send;
	SmsManager sManager;

	// ��¼��ҪȺ���ĺ����б�
	ArrayList<String> sendList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groupsend);
		sManager = SmsManager.getDefault();
		// ��ȡ�����ϵ��ı���,��ť
		numbers = (EditText) findViewById(R.id.ed_phone);
		content = (EditText) findViewById(R.id.ed_sms);
		select = (Button) findViewById(R.id.select);
		send = (Button) findViewById(R.id.send);
		// Ϊsend�󶨵���¼�
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for (String number : sendList) {
					// ����һ��PendingIntent����
					PendingIntent pi = PendingIntent.getActivity(
							GroupSend.this, 0, new Intent(), 0);
					// ���Ͷ���
					sManager.sendTextMessage(number, null, content.getText()
							.toString(), pi, null);
				}
				Toast.makeText(GroupSend.this, "����Ⱥ�����", Toast.LENGTH_LONG)
						.show();
			}
		});

		// Ϊselect�ĵ����¼��󶨼�����
		select.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Cursor cursor = getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null, null, null, null);
				BaseAdapter adapter = new BaseAdapter() {

					@Override
					public View getView(int position, View convertView,
							ViewGroup parent) {
						// TODO Auto-generated method stub
						cursor.moveToPosition(position);
						CheckBox rb = new CheckBox(GroupSend.this);
						// ��ȡ��ϵ�˵ĵ绰����ȥ���м�Ļ��߿ո�
						String number = cursor
								.getString(
										cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
								.replace("-", "").replace(" ", "");
						rb.setText(number);
						//��������Ѿ����������,Ĭ��ѡ��
						if(isChecked(number)) {
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
				
				//����list.xml���ֶ�Ӧ��view
				View selectView = getLayoutInflater().inflate(R.layout.list, null);
				final ListView listview = (ListView) selectView.findViewById(R.id.list);
				listview.setAdapter(adapter);
				new AlertDialog.Builder(GroupSend.this).setView(selectView).setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						sendList.clear();
						for (int i = 0; i < listview.getCount(); i++) {
							CheckBox checkbox = (CheckBox) listview.getChildAt(i);
							if(checkbox.isChecked()) {
								sendList.add(checkbox.getText().toString());
							}
						}
						numbers.setText(sendList.toString());
					}
				}).show();
			}
		});
	}
	
	public boolean isChecked(String phone) {
		for (String s1 : sendList) {
			if(s1.equals(phone)) {
				return true;
			}
		}
		return false;
	}
}
