package org.hydl.chaper9;

import java.util.ArrayList;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;



public class ContactProviderTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactprovider);

		Button btn_search = (Button) findViewById(R.id.btn_search);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ArrayList<String> names = new ArrayList<String>();
				final ArrayList<ArrayList<String>> details = new ArrayList<ArrayList<String>>();
				Cursor cursor = getContentResolver().query(
						ContactsContract.Contacts.CONTENT_URI, null, null,
						null, null);

				while (cursor.moveToNext()) {
					String contactId = cursor.getString(cursor
							.getColumnIndex(ContactsContract.Contacts._ID));
					String name = cursor.getString(cursor
							.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

					names.add(name);
					Cursor phones = getContentResolver().query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID
									+ "=" + contactId, null, null);

					ArrayList<String> detail = new ArrayList<String>();
					while (phones.moveToNext()) {
						String phoneNumber = phones.getString(phones
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						detail.add("电话号码:" + phoneNumber);
					}
					phones.close();

					Cursor emails = getContentResolver().query(
							ContactsContract.CommonDataKinds.Email.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Email.CONTACT_ID
									+ "=" + contactId, null, null);
					while (emails.moveToNext()) {
						String emailAddress = emails.getString(emails
								.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
						detail.add("邮件地址:" + emailAddress);
					}

					emails.close();
					details.add(detail);
				}
				cursor.close();
				View resultDialog = getLayoutInflater().inflate(
						R.layout.result_contentprovider, null);
				ExpandableListView list = (ExpandableListView) resultDialog
						.findViewById(R.id.list);
				ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

					private TextView getTextView() {
						AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
								ViewGroup.LayoutParams.MATCH_PARENT, 64);
						TextView textView = new TextView(
								ContactProviderTest.this);
						textView.setLayoutParams(lp);
						textView.setGravity(Gravity.CENTER_VERTICAL
								| Gravity.LEFT);
						textView.setPadding(36, 0, 0, 0);
						textView.setTextSize(20);
						return textView;
					}

					@Override
					public boolean isChildSelectable(int groupPosition,
							int childPosition) {
						// TODO Auto-generated method stub
						return true;
					}

					@Override
					public boolean hasStableIds() {
						// TODO Auto-generated method stub
						return true;
					}

					@Override
					public View getGroupView(int groupPosition,
							boolean isExpanded, View convertView,
							ViewGroup parent) {
						// TODO Auto-generated method stub
						TextView textView = getTextView();
						textView.setText(getGroup(groupPosition).toString());
						return textView;
					}

					@Override
					public long getGroupId(int groupPosition) {
						// TODO Auto-generated method stub
						return groupPosition;
					}

					@Override
					public int getGroupCount() {
						// TODO Auto-generated method stub
						return names.size();
					}

					@Override
					public Object getGroup(int groupPosition) {
						// TODO Auto-generated method stub
						return names.get(groupPosition);
					}

					@Override
					public int getChildrenCount(int groupPosition) {
						// TODO Auto-generated method stub
						return details.get(groupPosition).size();
					}

					@Override
					public View getChildView(int groupPosition,
							int childPosition, boolean isLastChild,
							View convertView, ViewGroup parent) {
						// TODO Auto-generated method stub
						TextView textView = getTextView();
						textView.setText(getChild(groupPosition, childPosition)
								.toString());
						return textView;
					}

					@Override
					public long getChildId(int groupPosition, int childPosition) {
						// TODO Auto-generated method stub
						return childPosition;
					}

					@Override
					public Object getChild(int groupPosition, int childPosition) {
						// TODO Auto-generated method stub
						return details.get(groupPosition).get(childPosition);
					}
				};

				list.setAdapter(adapter);
				new AlertDialog.Builder(ContactProviderTest.this)
						.setView(resultDialog).setPositiveButton("确定", null)
						.show();
			}
		});

		Button btn_add = (Button) findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = ((EditText) findViewById(R.id.name)).getText().toString();
				String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
				String email = ((EditText) findViewById(R.id.email)).getText().toString();
				// 创建一个空的ContentValues
				ContentValues values = new ContentValues();
				// 向RawContacts.CONTENT_URI执行一个空值插入
				// 目的是获取系统返回的rawContactId
				Uri rawContactUri = getContentResolver().insert(
						RawContacts.CONTENT_URI, values);
				long rawContactId = ContentUris.parseId(rawContactUri);
				values.clear();
				values.put(Data.RAW_CONTACT_ID, rawContactId);
				// 设置内容类型
				values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
				// 设置联系人名字
				values.put(StructuredName.GIVEN_NAME, name);
				// 向联系人URI添加联系人名称
				getContentResolver().insert(
						android.provider.ContactsContract.Data.CONTENT_URI,
						values);
				values.clear();
				values.put(Data.RAW_CONTACT_ID, rawContactId);
				values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
				// 设置联系人的电话号码
				values.put(Phone.NUMBER, phone);
				// 设置电话类型
				values.put(Phone.TYPE, Phone.TYPE_MOBILE);
				// 向联系人电话号码URI添加电话号码
				getContentResolver().insert(
						android.provider.ContactsContract.Data.CONTENT_URI,
						values);
				values.clear();
				values.put(Data.RAW_CONTACT_ID, rawContactId);
				values.put(Data.MIMETYPE, Email.CONTENT_ITEM_TYPE);
				// 设置联系人的E-mail地址
				values.put(Email.DATA, email);
				// 设置电子邮件的类型
				values.put(Email.TYPE, Email.TYPE_WORK);
				// 向联系人E-mail URI添加E-mail数据
				getContentResolver().insert(
						android.provider.ContactsContract.Data.CONTENT_URI,
						values);
				Toast.makeText(ContactProviderTest.this, "联系人数据添加成功",
						Toast.LENGTH_LONG).show();

			}
		});
	}
}
