package com.example.viewpagertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopicListFragment extends ListFragment {

	onTopicSelectedListener mCallback;
	
	public interface onTopicSelectedListener {

		public void onTopicSelected(int position);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Setting up List - Data.TOPICS	used to show on list.
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Data.TOPICS));
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		//assigning to the activity
		mCallback = (onTopicSelectedListener) activity;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		//position of item is sent to MainActivity
		mCallback.onTopicSelected(position);
	}
}
