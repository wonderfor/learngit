package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ArrayResTest extends Activity {
	
	String[] texts ; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arrayrestest);
		texts = getResources().getStringArray(R.array.string_arr);
		BaseAdapter ba = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView text = new TextView(ArrayResTest.this);
				Resources res = ArrayResTest.this.getResources();
				text.setWidth((int)res.getDimension(R.dimen.cell_width));
				text.setHeight((int)res.getDimension(R.dimen.cell_height));
				text.setText(texts[position]);
				TypedArray icons = res.obtainTypedArray(R.array.plain_arr);
				text.setBackgroundDrawable(icons.getDrawable(position));
				text.setTextSize(20);
				return text;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return texts[position];
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return texts.length;
			}
		};
		
		GridView grid = (GridView) findViewById(R.id.grid01);
		grid.setAdapter(ba);
	}
}
