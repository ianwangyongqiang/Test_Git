package com.skycopyhot.gittest.activity;

import java.util.ArrayList;
import java.util.List;

import com.skycopyhot.gittest.R;
import com.skycopyhot.gittest.adapter.SwipeListViewAdapter;

import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.widget.ListView;

public class TestSwipeListView extends Activity {

	private SwipeListViewAdapter mAdapter;
	private ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipelistview);
		View emptyView = findViewById(R.id.empty_view);
		mListView = (ListView) findViewById(R.id.swipelistview);
		mListView.setEmptyView(emptyView);
		mAdapter = new SwipeListViewAdapter(this);
		new GetContacts().execute();
		mListView.setAdapter(mAdapter);
	}
	
	class GetContacts extends AsyncTask<String, String, List<ContactStruct>> {

		@Override
		protected List<ContactStruct> doInBackground(String... params) {
			String[] projection = new String[] {Contacts._ID, Contacts.DISPLAY_NAME, Contacts.HAS_PHONE_NUMBER};
			Cursor cursor = getContentResolver().query(Contacts.CONTENT_URI, projection, null, null, null);
			List<ContactStruct> list = new ArrayList<ContactStruct>();
			while (cursor.moveToNext()) {
				String hasPhone = cursor.getString(cursor.getColumnIndex(Contacts.HAS_PHONE_NUMBER));
				if ("1".equalsIgnoreCase(hasPhone)) {
					String id = cursor.getString(cursor.getColumnIndex(Contacts._ID));
					String name = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME));
					Cursor phones = getContentResolver().query(Phone.CONTENT_URI, null, Phone.CONTACT_ID + "=" + id, null, null);
					phones.moveToLast();
					String number = phones.getString(phones.getColumnIndex(Phone.NUMBER));
					ContactStruct struct = new ContactStruct(name, number);
					list.add(struct);
				}
			}
			cursor.close();
			return list;
		}
		
		@Override
		protected void onPostExecute(List<ContactStruct> result) {
			mAdapter.setData(result);
			super.onPostExecute(result);
		}
		
	}
	
	public class ContactStruct {
		public String mName;
		public String mNumber;
		public ContactStruct(String name, String number) {
			mName = name;
			mNumber = number;
		}
	}
}
