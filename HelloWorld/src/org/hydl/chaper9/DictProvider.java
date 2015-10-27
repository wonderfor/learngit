package org.hydl.chaper9;

import org.hydl.chaper8.MyDatabaseHelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DictProvider extends ContentProvider {

	private static UriMatcher mather = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int WORDS = 1;
	private static final int WORD = 2;
	private MyDatabaseHelper dbOpenHelper;

	static {
		mather.addURI(Words.AUTHORITY, "words", WORDS);
		mather.addURI(Words.AUTHORITY, "word/#", WORD);
	}

	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		int num = 0;
		switch (mather.match(uri)) {
		case WORDS:
			num = db.delete("dict", where, whereArgs);
			break;
		case WORD:
			long id = ContentUris.parseId(uri);
			String whereClause = Words.Word._ID + "=" + id;
			if (where != null && !where.equals("")) {
				whereClause = whereClause + " and " + where;
			}
			num = db.delete("dict", whereClause, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("δ֪Uri:" + uri);
		}
		return num;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (mather.match(uri)) {
		case WORDS:
			return "vnd.android.cursor.dir/org.hydl.dict";
		case WORD:
			return "vnd.adnroid.cursor.item/org.hydl.dict";

		default:
			throw new IllegalArgumentException("δ֪Uri:" + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		switch (mather.match(uri)) {
		case WORDS:
			long rowId = db.insert("dict", Words.Word._ID, values);
			if(rowId > 0) {
				Uri wordUri = ContentUris.withAppendedId(uri, rowId);
				getContext().getContentResolver().notifyChange(wordUri, null);
				return wordUri;
			}
			break;
		default:
			throw new IllegalArgumentException("δ֪Uri:" + uri);
		}
		
		
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dbOpenHelper = new MyDatabaseHelper(getContext(), "myDict.db3", 1);
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String where,
			String[] whereArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		switch (mather.match(uri)) {
		case WORDS:
			return db.query("dict", projection, where, whereArgs, null, null,
					sortOrder);
		case WORD:
			long id = ContentUris.parseId(uri);
			String whereClause = Words.Word._ID + "=" + id;
			if (where != null && !where.equals(where)) {
				whereClause = whereClause + " and " + where;
			}

			return db.query("dict", projection, whereClause, whereArgs, null,
					null, sortOrder);
		default:
			throw new IllegalArgumentException("δ֪Uri:" + uri);
		}

	}

	@Override
	public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
		int num = 0;
		switch (mather.match(uri)) {
		case WORDS:
			num = db.update("dict", values, where, whereArgs);
			break;
		case WORD:
			long id = ContentUris.parseId(uri);
			String whereClause = Words.Word._ID + "=" + id;
			if(where != null && !where.equals("")) {
				whereClause = whereClause + " and " + where;
			}
			
			num = db.update("dict", values, whereClause, whereArgs);
			break;
		default:
			new IllegalArgumentException("δ֪Uri:" + uri);
		}
		
		getContext().getContentResolver().notifyChange(uri, null);
		return num;
	}

}
