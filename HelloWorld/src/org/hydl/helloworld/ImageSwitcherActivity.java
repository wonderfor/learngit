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
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwitcherActivity extends Activity {

	int[] imageIds = new int[] { R.drawable.bom1, R.drawable.bom2,
			R.drawable.bom3, R.drawable.bom1, R.drawable.bom2, R.drawable.bom3,
			R.drawable.bom1, R.drawable.bom2, R.drawable.bom3, R.drawable.bom1,
			R.drawable.bom2, R.drawable.bom3 };
	
	ImageSwitcher switcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imageswitcher);

		// ����һ��List����,List�����Ԫ��ʦMap
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imageIds.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", imageIds[i]);
			listItems.add(listItem);
		}

		// ��ȡ��ʾͼƬ��ImageSwitcher
		switcher = (ImageSwitcher) findViewById(R.id.iamgeswitcher);
		// λImageSwitcher����ͼƬ�л��Ķ���Ч��
		switcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				ImageView imageview = new ImageView(ImageSwitcherActivity.this);
				imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageview.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

				return imageview;
			}
		});

		// ����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
				R.layout.cell, new String[] { "image" },
				new int[] { R.id.image1 });

		GridView grid = (GridView) findViewById(R.id.gridview_imageswticher);
		grid.setAdapter(simpleAdapter);
		grid.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switcher.setImageResource(imageIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switcher.setImageResource(imageIds[position]);
			}
		});
	}
}
