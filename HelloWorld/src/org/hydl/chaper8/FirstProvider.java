package org.hydl.chaper8;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class FirstProvider extends ContentProvider{

	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		// TODO Auto-generated method stub
		System.out.println(uri + "===delete����������===");
		System.out.println("where����Ϊ:" + where);
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		System.out.println(uri + "===insert����������===");
		System.out.println("values����Ϊ:" + values); 
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		System.out.println("===onCreate����������===");
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String where, String[] whereArgs,
			String sortOrder) {
		// TODO Auto-generated method stub
		System.out.println(uri + "===query����������===");
		System.out.println("where����Ϊ:" + where);
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
		// TODO Auto-generated method stub
		System.out.println(uri + "===update����������===");
		System.out.println("where����Ϊ:" + where);
		return 0;
	}

}
