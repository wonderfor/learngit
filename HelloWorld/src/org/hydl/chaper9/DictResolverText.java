package org.hydl.chaper9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hydl.chaper8.DictResultActivity;
import org.hydl.chaper9.Words.Word;
import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DictResolverText extends Activity {

	ContentResolver contentResolver;
	Button insert = null;
	Button search = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictresovertext);
		contentResolver = getContentResolver();
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
				ContentValues values = new ContentValues();
				values.put(Words.Word.WORD, word);
				values.put(Words.Word.DETAIL, detail);
				contentResolver.insert(Word.DICT_CONTENT_URI, values);
				Toast.makeText(DictResolverText.this, "添加生词成功!",
						Toast.LENGTH_LONG).show();
			}
		});
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String key = ((EditText) findViewById(R.id.key)).getText()
						.toString();
				Cursor cursor = contentResolver.query(
						Words.Word.DICT_CONTENT_URI, null,
						"word like ? or detail like ?", new String[] {
								"%" + key + "%", "%" + key + "%" }, null);

				Bundle data = new Bundle();
				data.putSerializable("data", convertCursorToList(cursor));
				Intent intent = new Intent(DictResolverText.this,
						DictResultActivity.class);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}

	private ArrayList<Map<String, String>> convertCursorToList(Cursor cursor) {
		ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
		while (cursor.moveToNext()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(Words.Word.WORD, cursor.getString(1));
			map.put(Words.Word.DETAIL, cursor.getString(2));
			result.add(map);

		}
		return result;
	}
}
