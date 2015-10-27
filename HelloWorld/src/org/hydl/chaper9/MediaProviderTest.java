package org.hydl.chaper9;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MediaProviderTest extends Activity {

	private List<String> names;
	private List<String> descs;
	private List<String> fileNames;
	private ListView show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediaprovider);
		names = new ArrayList<String>();
		descs = new ArrayList<String>();
		fileNames = new ArrayList<String>();
		show = (ListView) findViewById(R.id.show);

		Button btn_view = (Button) findViewById(R.id.view);
		btn_view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				names.clear();
				descs.clear();
				fileNames.clear();
				Cursor cursor = getContentResolver().query(
						Media.EXTERNAL_CONTENT_URI, null, null, null, null);
				while (cursor.moveToNext()) {
					// ��ȡͼƬ����ʾ��
					String name = cursor.getString(cursor
							.getColumnIndex(Media.DISPLAY_NAME));
					// ��ȡͼƬ����ϸ��Ϣ
					String desc = cursor.getString(cursor
							.getColumnIndex(Media.DESCRIPTION));
					// ��ȡͼƬ�ı���λ�õ�����
					byte[] data = cursor.getBlob(cursor
							.getColumnIndex(Media.DATA));
					// ��ͼƬ����ӵ� names����
					names.add(name);
					// ��ͼƬ������ӵ�desc����
					descs.add(desc);
					// ��ͼƬ����·����ӵ�fileNames������
					fileNames.add(new String(data, 0, data.length - 1));
				}
				// ����һ��List����,List����Ԫ����Map
				List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
				// ��names,descs�������϶��������ת����Map������
				for (int i = 0; i < names.size(); i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("name", names.get(i));
					map.put("desc", descs.get(i));
					listItems.add(map);
				}
				// ����һ��SimpleAdapter
				SimpleAdapter simpleAdapter = new SimpleAdapter(
						MediaProviderTest.this, listItems, R.layout.lineimg,
						new String[] { "name", "desc" }, new int[] { R.id.name,
								R.id.desc });

				show.setAdapter(simpleAdapter);

			}
		});

		show.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View source,
					int position, long id) {
				// TODO Auto-generated method stub
				View viewDialog = getLayoutInflater().inflate(R.layout.view,
						null);
				ImageView image = (ImageView) viewDialog
						.findViewById(R.id.image);
				image.setImageBitmap(BitmapFactory.decodeFile(fileNames
						.get(position)));
				new AlertDialog.Builder(MediaProviderTest.this)
						.setView(viewDialog).setPositiveButton("ȷ��", null)
						.show();

			}
		});

		Button btn_add = (Button) findViewById(R.id.add);
		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put(Media.DISPLAY_NAME, "jinta");
				values.put(Media.DESCRIPTION, "����");
				values.put(Media.MIME_TYPE, "image/jpeg");
				Uri uri = getContentResolver().insert(
						Media.EXTERNAL_CONTENT_URI, values);
				Bitmap map = BitmapFactory.decodeResource(
						MediaProviderTest.this.getResources(), R.drawable.bom1);
				OutputStream os = null;
				try {
					os = getContentResolver().openOutputStream(uri);
					map.compress(Bitmap.CompressFormat.JPEG, 100, os);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
}
