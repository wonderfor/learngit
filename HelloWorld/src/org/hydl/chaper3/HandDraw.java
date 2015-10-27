package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class HandDraw extends Activity {
	
	
	EmbossMaskFilter emboss;
	BlurMaskFilter blur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handdraw);
		emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f,1.5f}, 0.6f, 6,4.2f);
		blur = new BlurMaskFilter(8, Blur.NORMAL);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.my_menu, menu);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		DrawViews dv = (DrawViews) findViewById(R.id.draw);
		switch (item.getItemId()) {
		case R.id.red:
			dv.paint.setColor(Color.RED);
			item.setChecked(true);
			break;
		case R.id.green:
			dv.paint.setColor(Color.GREEN);
			item.setChecked(true);
			break;
		case R.id.blue:
			dv.paint.setColor(Color.BLUE);
			item.setChecked(true);
			break;
		case R.id.width_1:
			dv.paint.setStrokeWidth(1);
			break;
		case R.id.width_3:
			dv.paint.setStrokeWidth(3);
			break;
		case R.id.width_5:
			dv.paint.setStrokeWidth(5);
			break;
		case R.id.blur:
			dv.paint.setMaskFilter(blur);
			break;
		case R.id.emboss:
			dv.paint.setMaskFilter(emboss);
			break;
		default:
			break;
		}
		return true;
	}
	
	
	
}
