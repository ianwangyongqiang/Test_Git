package com.skycopyhot.gittest.adapter;

import java.util.ArrayList;
import java.util.List;

import com.skycopyhot.gittest.R;
import com.skycopyhot.gittest.activity.TestSwipeListView.ContactStruct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SwipeListViewAdapter extends BaseAdapter {
	
	private List<ContactStruct> mData = new ArrayList<ContactStruct>();
	private Context mContext;
	
	public SwipeListViewAdapter(Context context) {
		mContext = context;
	}
	
	public void setData(List<ContactStruct> data) {
		mData.addAll(data);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ContactStruct struct = (ContactStruct) getItem(position);
		ContactHolder holder = null;
		if (convertView == null) {
			holder = new ContactHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
			holder.mNameText = (TextView) convertView.findViewById(R.id.nametext);
			holder.mNumberText = (TextView) convertView.findViewById(R.id.subtext);
			convertView.setTag(holder);
		} else {
			holder = (ContactHolder) convertView.getTag();
		}
		holder.mNameText.setText(struct.mName);
		holder.mNumberText.setText(struct.mNumber);
		return convertView;
	}
	
	private class ContactHolder {
		public TextView mNameText;
		public TextView mNumberText;
	}

}
