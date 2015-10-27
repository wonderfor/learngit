package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class ValuesResTest extends Activity {

	// use string resource
	int[] textIds = new int[] { R.string.c1, R.string.c2, R.string.c3,
			R.string.c4, R.string.c5, R.string.c6, R.string.c7, R.string.c8,
			R.string.c9 };

	// use color resource
	int[] colorIds = new int[] { R.color.c1, R.color.c2, R.color.c3,
			R.color.c4, R.color.c5, R.color.c6, R.color.c7, R.color.c8,
			R.color.c9 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valuetest);
		
		BaseAdapter ba = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView text = new TextView(ValuesResTest.this);
				Resources res = ValuesResTest.this.getResources();
				text.setWidth((int)res.getDimension(R.dimen.cell_width));
				text.setHeight((int)res.getDimension(R.dimen.cell_height));
				text.setText(textIds[position]);
				text.setBackgroundResource(colorIds[position]);
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
				return getResources().getText(textIds[position]);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return textIds.length;
			}
		};
		
		GridView grid = (GridView) findViewById(R.id.grid01);
		grid.setAdapter(ba);
		
	}
}
