package org.hydl.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity {

	private TextView txt;
	PopupMenu popup = null;
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acitivty_menu);
		txt = (TextView) findViewById(R.id.tv_menu);
		registerForContextMenu(txt);

		actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(true);
		//actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);

		Button btn_show = (Button) findViewById(R.id.btn_show);
		btn_show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				actionBar.show();
			}
		});

		Button btn_hide = (Button) findViewById(R.id.btn_hidden);
		btn_hide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				actionBar.hide();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.activity_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View view,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub

		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.context, menu);
		menu.setHeaderIcon(R.drawable.bom2);
		menu.setHeaderTitle("选择背景颜色");

		// super.onCreateContextMenu(menu, view, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem mi) {
		// TODO Auto-generated method stub

		mi.setChecked(true);

		switch (mi.getItemId()) {
		case R.id.red:
			mi.setChecked(true);
			txt.setBackgroundColor(Color.RED);
			break;
		case R.id.green:
			mi.setChecked(true);
			txt.setBackgroundColor(Color.GREEN);
			break;
		case R.id.blue:
			mi.setChecked(true);
			txt.setBackgroundColor(Color.BLUE);
			break;

		}

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		if (item.isCheckable()) {
			item.setChecked(true);
		}

		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(MenuActivity.this,MainActivity.class);
			MenuActivity.this.startActivity(intent);
			break;
		case R.id.font_10:
			txt.setTextSize(10 * 2);
			break;
		case R.id.font_12:
			txt.setTextSize(12 * 2);
			break;
		case R.id.font_14:
			txt.setTextSize(14 * 2);
			break;
		case R.id.font_16:
			txt.setTextSize(16 * 2);
			break;
		case R.id.font_18:
			txt.setTextSize(18 * 2);
			break;
		case R.id.red_font:
			txt.setTextColor(Color.RED);
			break;
		case R.id.green_font:
			txt.setTextColor(Color.GREEN);
			break;
		case R.id.blue_font:
			txt.setTextColor(Color.BLUE);
			break;
		case R.id.plain_item:
			Toast toast = Toast.makeText(this, "您点击了普通菜单项", Toast.LENGTH_LONG);
			toast.show();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void onPopupButtonClick(View source) {
		popup = new PopupMenu(this, source);
		getMenuInflater().inflate(R.menu.popup, popup.getMenu());
		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem mi) {
				// TODO Auto-generated method stub
				switch (mi.getItemId()) {
				case R.id.hidden:
					popup.dismiss();
					break;

				default:
					Toast.makeText(MenuActivity.this, "您点击了" + mi.getTitle(),
							Toast.LENGTH_SHORT).show();
					break;
				}

				return true;
			}
		});

		popup.show();
	}

}
