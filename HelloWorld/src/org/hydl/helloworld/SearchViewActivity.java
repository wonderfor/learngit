package org.hydl.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchViewActivity extends Activity implements SearchView.OnQueryTextListener{
	
	private SearchView sv;
	private ListView lv;
	
	private final String[] mStrings = {"aaaaa","bbbbb","ccccc"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchview);
		
		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mStrings));
		lv.setTextFilterEnabled(true);
		sv = (SearchView) findViewById(R.id.sv);
		sv.setIconifiedByDefault(false);
		sv.setOnQueryTextListener(this);
		sv.setSubmitButtonEnabled(true);
		sv.setQueryHint("查找");
		
	}
	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		if(TextUtils.isEmpty(newText)) {
			lv.clearTextFilter();
		}else{
			lv.setFilterText(newText);
		}
		return true;
	}
	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "您选择的是:" + query, Toast.LENGTH_SHORT).show();
		return false;
	}
}
