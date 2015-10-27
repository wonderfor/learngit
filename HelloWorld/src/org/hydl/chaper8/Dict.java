package org.hydl.chaper8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dict extends Activity {

	MyDatabaseHelper dbHelper;
	Button insert = null;
	Button search = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dict);
		dbHelper = new MyDatabaseHelper(this, "myDict.db3", 1);
		insert = (Button) findViewById(R.id.add);
		search = (Button) findViewById(R.id.search);
		insert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String word = ((EditText) findViewById(R.id.word)).getText()
						.toString();
				String detail = ((EditText) findViewById(R.id.detail))
						.getText().toString();
				insertData(dbHelper.getReadableDatabase(), word, detail);
				Toast.makeText(Dict.this, "添加生词成功", 8000).show();
			}
		});

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String key = ((EditText) findViewById(R.id.key)).getText()
						.toString();
				Cursor cursor = dbHelper
						.getReadableDatabase()
						.rawQuery(
								"select * from dict where word like ? or detail like ?",
								new String[] { "%" + key + "%", "%" + key + "%" });

				Bundle data = new Bundle();
				data.putSerializable("data", converCursorToList(cursor));
				Intent intent = new Intent(Dict.this,DictResultActivity.class);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}

	protected ArrayList<Map<String, String>> converCursorToList(Cursor cursor) {
		ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (cursor.moveToNext()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("word", cursor.getString(1));
			map.put("detail", cursor.getString(2));
			result.add(map);
		}

		return result;

	}

	private void insertData(SQLiteDatabase db, String word, String detail) {
		db.execSQL("insert into dict values (null,?,?)", new String[] { word,
				detail });
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (dbHelper != null) {
			dbHelper.close();
		}
	}

}
