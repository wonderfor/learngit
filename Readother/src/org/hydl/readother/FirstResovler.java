package org.hydl.readother;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstResovler extends Activity {

	ContentResolver contentResolver;
	Uri uri = Uri.parse("content://org.hydl.chaper8.firstprovider/");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firstresovler);

		contentResolver = getContentResolver();

		Button btn_query = (Button) findViewById(R.id.btn_query);
		btn_query.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c = contentResolver.query(uri, null, "query_where",
						null, null);
				Toast.makeText(FirstResovler.this,
						"远程ContentProvide返回的Cursor为：" + c, Toast.LENGTH_LONG)
						.show();
			}
		});

		Button btn_insert = (Button) findViewById(R.id.btn_add);
		btn_insert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put("name", "fkjava");
				Uri newUri = contentResolver.insert(uri, values);
				Toast.makeText(FirstResovler.this,
						"远程ContentProvider新插入记录的Uri为:" + newUri,
						Toast.LENGTH_LONG).show();
			}
		});

		Button btn_update = (Button) findViewById(R.id.btn_update);
		btn_update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put("name", "fkjava");
				int count = contentResolver.update(uri, values, "update_where",
						null);
				Toast.makeText(FirstResovler.this,
						"远程ConentProvier更新的记录为：" + count, Toast.LENGTH_LONG)
						.show();
			}
		});

		Button btn_delete = (Button) findViewById(R.id.btn_delete);
		btn_delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int count = contentResolver.delete(uri, "delete_where", null);
				Toast.makeText(FirstResovler.this,
						"远程ContentProiver删除的记录为:" + count, Toast.LENGTH_LONG)
						.show();
			}
		});

	}
}
