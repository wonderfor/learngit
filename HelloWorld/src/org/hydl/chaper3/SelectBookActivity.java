package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class SelectBookActivity extends Activity implements
		BookListFragment.Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_twopane);
	}

	@Override
	public void onItemSelected(Integer id) {
		// TODO Auto-generated method stub
		/*
		Bundle arguments = new Bundle();
		arguments.putInt(BookDetailFragment.ITEM_ID, id);
		BookDetailFragment fragment = new BookDetailFragment();
		fragment.setArguments(arguments);
		getFragmentManager().beginTransaction()
				.replace(R.id.book_detail_container, fragment).commit();
				*/
		
		//可以使用back返回上一个fragment
		Bundle arguments = new Bundle();
		arguments.putInt(BookDetailFragment.ITEM_ID, id);
		BookDetailFragment fragment = new BookDetailFragment();
		fragment.setArguments(arguments);
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.book_detail_container, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
		
	}

}
