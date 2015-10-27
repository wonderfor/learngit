package org.hydl.chaper8;

import java.util.List;
import java.util.Map;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class DictResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup);
		setTitle(R.string.ditc_title);
		ListView listView = (ListView) findViewById(R.id.show);
		Intent intent = getIntent();
		Bundle data = intent.getExtras();
		List<Map<String, String>> list = (List<Map<String, String>>) data
				.getSerializable("data");
		SimpleAdapter adapter = new SimpleAdapter(DictResultActivity.this,
				list, R.layout.linesdt, new String[] { "word", "detail" },
				new int[] { R.id.word, R.id.detail });
		listView.setAdapter(adapter);
	}
}
