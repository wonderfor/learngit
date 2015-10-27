package org.hydl.helloworld;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryActivity extends Activity {
	
	int[] imageIds = new int[]{
			R.drawable.bom1,R.drawable.bom2,R.drawable.bom3,
			R.drawable.bom1,R.drawable.bom2,R.drawable.bom3,
			R.drawable.bom1,R.drawable.bom2,R.drawable.bom3,
			R.drawable.bom1,R.drawable.bom2,R.drawable.bom3
	};
	
	Gallery gallery;
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		gallery = (Gallery) findViewById(R.id.gallery);
		imageView = (ImageView) findViewById(R.id.imageViewGallery);
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				ImageView imageView = new ImageView(GalleryActivity.this);
				imageView.setImageResource(imageIds[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(75,100));
				//TypedArray typeArray = obtainStyledAttributes(R.styleable.Gallery);
				
				
				return imageView;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageIds.length;
			}
		};
		
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

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
		
	}
	
}
