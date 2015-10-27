package org.hydl.chaper3;

import java.io.InputStream;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class BitMapTest extends Activity {
	
	String[] images = null;
	AssetManager assets = null;
	int currentImg = 0;
	ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitmap);
		
		image = (ImageView) findViewById(R.id.img03);
		
		try {
			assets = getAssets();
			//get /assets/ files
			images = assets.list("");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		final Button btn_next = (Button) findViewById(R.id.btn_next);
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				if(currentImg >= images.length) {
					currentImg = 0;
				}
				
				//find next image file ,isn't image file,currentImage+1.
				while(!images[currentImg].endsWith(".png") && !images[currentImg].endsWith(".jpg")&&
						!images[currentImg].endsWith(".gif")) {
					currentImg++;
					if(currentImg >= images.length) {
						currentImg = 0;
					}
				}
				
				InputStream assetFile = null;
				try {
					assetFile = assets.open(images[currentImg++]);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
				if(bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
					bitmapDrawable.getBitmap().recycle();
				}
				image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
			}
		});
		
		
	}
}
