package com.example.viewpagertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements TopicListFragment.onTopicSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//ListFragment - TopicList is a fragment on MainActivity
		TopicListFragment tlist = new TopicListFragment();
		//adding TopicList to the MainActivity
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, tlist).commit();
	}

	@Override
	public void onTopicSelected(int position) {
		
		//position data sent to DetailedViewActivity which load the viewpager
		Intent intent = new Intent(this, DetailedViewActivity.class);
		intent.putExtra("position", position);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
