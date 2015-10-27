package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SysAction extends Activity {

	final int PICK_CONTACT = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sysaction);
		Button bn = (Button) findViewById(R.id.btn_contact);
		bn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_GET_CONTENT);
				intent.setType("vnd.android.cursor.item/phone");
				startActivityForResult(intent, PICK_CONTACT);
			}
		});
		
		Button bnHome = (Button) findViewById(R.id.btn_home);
		bnHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setAction(Intent.ACTION_MAIN);
				i.addCategory(Intent.CATEGORY_HOME);
				startActivity(i);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case PICK_CONTACT:

			if (resultCode == Activity.RESULT_OK) {
				Uri contactData = data.getData();
				CursorLoader cursorLoader = new CursorLoader(this, contactData,
						null, null, null, null);
				Cursor cursor = cursorLoader.loadInBackground();
				if (cursor.moveToFirst()) {
					String contactId = cursor.getString(cursor
							.getColumnIndex(ContactsContract.Contacts._ID));
					String name = cursor
							.getString(cursor
									.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
					String phoneNumber = "此联系人暂未输入号码";
					Cursor phones = getContentResolver().query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID
									+ " = " + contactId, null, null);
					if (phones.moveToFirst()) {
						phoneNumber = phones
								.getString(phones
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					}

					phones.close();
					EditText show = (EditText) findViewById(R.id.edit_name);
					show.setText(name);
					EditText phone = (EditText) findViewById(R.id.edit_phones);
					phone.setText(phoneNumber);
				}
				cursor.close();
			}

			break;

		}
	}
}
