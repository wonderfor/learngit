package org.hydl.chaper8;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class DBTest extends Activity {

	SQLiteDatabase db;
	Button bn = null;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dbtest);
		
		db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()
				+ "/my.db3", null);
		listView = (ListView) findViewById(R.id.listview);
		bn = (Button) findViewById(R.id.insert);
		bn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String title = ((EditText) findViewById(R.id.title)).getText()
						.toString();
				String content = ((EditText) findViewById(R.id.content))
						.getText().toString();
				try {
					insertData(db, title, content);
					Cursor cursor = db.rawQuery("select * from news_inf", null);
					inflateList(cursor);
				} catch (Exception e) {
					// TODO: handle exception
					db.execSQL("create table news_inf(_id integer"
							+ " primary key autoincrement,"
							+ " news_title varchar(50),"
							+ " news_content varchar(255))");
					insertData(db, title, content);
					Cursor cursor = db.rawQuery("select * from news_inf", null);
					inflateList(cursor);
				}
			}
		});

	}

	private void insertData(SQLiteDatabase db, String title, String content) {
		// ÷¥––≤Â»Î”Ôæ‰
		db.execSQL("insert into news_inf values(null,?,?)", new String[] {
				title, content });
	}

	private void inflateList(Cursor cursor) {
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(DBTest.this,
				R.layout.lines, cursor, new String[] { "news_title",
						"news_content" }, new int[] { R.id.my_title,
						R.id.my_content },
				CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		listView.setAdapter(adapter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (db != null && db.isOpen()) {
			db.close();
		}
	}

}
