package com.youxiachai.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.youxiachai.appasync.example.R;
import com.youxiachai.example.view.HuageListView;
import com.youxiachai.example.view.JsonParseActivity;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	public void startJsonParse(View v) {
		JsonParseActivity.start(this);;
	}
	
	public void startHuageListView (View v) {
		HuageListView.start(this);
	}

}
