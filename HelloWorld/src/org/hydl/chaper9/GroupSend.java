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

	// 记录需要群发的号码列表
	ArrayList<String> sendList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groupsend);
		sManager = SmsManager.getDefault();
		// 获取界面上的文本框,按钮
		numbers = (EditText) findViewById(R.id.ed_phone);
		content = (EditText) findViewById(R.id.ed_sms);
		select = (Button) findViewById(R.id.select);
		send = (Button) findViewById(R.id.send);
		// 为send绑定点击事件
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for (String number : sendList) {
					// 创建一个PendingIntent对象
					PendingIntent pi = PendingIntent.getActivity(
							GroupSend.this, 0, new Intent(), 0);
					// 发送短信
					sManager.sendTextMessage(number, null, content.getText()
							.toString(), pi, null);
				}
				Toast.makeText(GroupSend.this, "短信群发完成", Toast.LENGTH_LONG)
						.show();
			}
		});

		// 为select的单机事件绑定监听器
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
						// 获取联系人的电话号码去掉中间的划线空格
						String number = cursor
								.getString(
										cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
								.replace("-", "").replace(" ", "");
						rb.setText(number);
						//如果号码已经加入黑名单,默认选中
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
				
				//加载list.xml布局对应的view
				View selectView = getLayoutInflater().inflate(R.layout.list, null);
				final ListView listview = (ListView) selectView.findViewById(R.id.list);
				listview.setAdapter(adapter);
				new AlertDialog.Builder(GroupSend.this).setView(selectView).setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
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
