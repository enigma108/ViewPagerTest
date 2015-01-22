package com.example.viewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class DetailedViewActivity extends ActionBarActivity {

	private int intent_position = -1;
	private int num_of_pages = 0;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	private String data_title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailed_view_pager);
		
		//get position of item in list(also position of array) from intent extras 
		intent_position = getIntent().getIntExtra("position", -1);
		
		//length of array - used to determine the number of pages in viewpager
		getNumPages();
		
		//init viewpager and pageradapter 
		mPager = (ViewPager)findViewById(R.id.pager);
		mPagerAdapter = new DetailedViewPagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);
	}

	private void getNumPages() {
		
		//data_title - String used to identify which array to use 
		//num_of_pages - determine the length of array - used to determine the number of pages in viewpager
		switch (intent_position) {
		
		case 0:
			data_title = Data.TITLE_ALPHABETS;
			num_of_pages = Data.ALPHABETS.length;
			break;
			
		case 1:
			data_title = Data.TITLE_NUMBERS;
			num_of_pages = Data.NUMBERS.length;
			break;
			
		case 2:
			data_title = Data.TITLE_COLORS;
			num_of_pages = Data.COLORS.length;
			break;
			
		default:
			data_title = null;
			num_of_pages = 0;	
		}
	}
	
	private class DetailedViewPagerAdapter extends FragmentStatePagerAdapter {

		public DetailedViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			
			//get instance of fragment - send position and string identifier for array
			return SinglePageFragment.newInstance(position, data_title);
		}

		@Override
		public int getCount() {
			
			//number of pages on viewpager
			return num_of_pages;
		}
	}
}
