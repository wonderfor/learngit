package org.hydl.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class GridViewActivity extends Activity {

	GridView grid;
	ImageView imageView;

	int[] imageIds = new int[] { R.drawable.bom1,
			R.drawable.bom2, R.drawable.bom3,
			R.drawable.bom1, R.drawable.bom2,
			R.drawable.bom3, R.drawable.bom1,
			R.drawable.bom2, R.drawable.bom3,
			R.drawable.bom1, R.drawable.bom2,
			R.drawable.bom3, R.drawable.bom1,
			R.drawable.bom2, R.drawable.bom3,
			R.drawable.bom1 };

	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);

		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < imageIds.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", imageIds[i]);
			listItems.add(listItem);
		}

		// 获取现实图片的ImageView
		imageView = (ImageView) findViewById(R.id.imageView);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
				R.layout.cell, new String[] { "image" },
				new int[] { R.id.image1 });
		
		grid = (GridView) findViewById(R.id.grid01);
		grid.setAdapter(simpleAdapter);
		grid.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				imageView.setImageResource(imageIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long it) {
				// TODO Auto-generated method stub
				imageView.setImageResource(imageIds[position]);
			}
		});
		
	}
}
