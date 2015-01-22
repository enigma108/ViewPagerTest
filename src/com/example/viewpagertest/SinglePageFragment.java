package com.example.viewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SinglePageFragment extends Fragment {
	
	int mNum;
	String mDataTitle;
	
	//create new instance of fragment 
	static SinglePageFragment newInstance(int num, String data_title) {
		
		//create fragment instance
		SinglePageFragment f = new SinglePageFragment();
		
		//create bundle and put position number and string array identifier in bundle
		Bundle args = new Bundle();
		args.putInt("num", num);
		args.putString("data_title", data_title);
		
		//set bundle as arguments for fragment
		f.setArguments(args);
		return f;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//get position number and string array identifier in bundle
		if(getArguments() != null) {
			mNum = getArguments().getInt("num");
			mDataTitle = getArguments().getString("data_title");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		//inflate the fragment 
		View v = inflater.inflate(R.layout.detailed_view_single_page, container, false);
		
		//identify the textview from layout
		TextView tv = (TextView) v.findViewById(R.id.tv_data_disp);
		
		//set the text of textview from the correct array with position passed as index. 
		//getDataArray method provides the correct array. 
		tv.setText(getDataArray(mDataTitle)[mNum]);
		return v;
	}
	
	private String[] getDataArray(String data_title) {
		
		//identify array from string array identifier and return the array
		
		String[] data = null;
		
		switch(data_title) {
		
		case Data.TITLE_ALPHABETS:
			data = Data.ALPHABETS;
			break;
		
		case Data.TITLE_NUMBERS:
			data = Data.NUMBERS;
			break;
			
		case Data.TITLE_COLORS:
			data = Data.COLORS;
			break;
			
		}
		
		return data;
	}
}
