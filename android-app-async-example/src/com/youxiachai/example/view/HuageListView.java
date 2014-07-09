package com.youxiachai.example.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import me.maxwin.view.IXListViewLoadMore;
import me.maxwin.view.IXListViewRefreshListener;
import me.maxwin.view.XListView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.youxiachai.appasync.WrapIon;
import com.youxiachai.appasync.example.R;

/**
 * @author youxiachai
 * @date   2014年7月9日
 */
public class HuageListView extends Activity {
	
	
	public static void start(Activity act) {
		Intent intent = new Intent();
		intent.setClass(act, HuageListView.class);
		act.startActivity(intent);
		
	}
	
	
	List<String> huageImageUrl = new ArrayList<String>();
	
	XListView mHuageListView;
	
	
	private static class HuageAdapter extends BaseAdapter {
		
		private List<String> mData;
		
		private Context mContext;
		
		public HuageAdapter(List<String> data, Context ctx){
			
			this.mData = data;
			this.mContext = ctx;
			
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
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Log.d("HuageListView", "current " + position);
			if(convertView == null) {
				convertView = new ImageView(mContext);
			}
			
			WrapIon<ImageView> wi = new WrapIon<ImageView>(mData.get(position), mContext, (ImageView) convertView);
			wi.setLogging("HuageListView");
			wi.pipe();
			
			return convertView;
		}
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_huagelistview);
		
		mHuageListView = (XListView) findViewById(R.id.huagelistview);
		
		//create 100 url data;
		
		for(int i = 0; i < 20; i++){
			huageImageUrl.add("http://qiniuphotos.qiniudn.com/gogopher.jpg");
		}
		
		mHuageListView.setAdapter(new HuageAdapter(huageImageUrl, this));
		
		mHuageListView.setPullRefreshEnable(new IXListViewRefreshListener() {
			
			@Override
			public void onRefresh() {
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						mHuageListView.stopRefresh(String.format("%1$tF %1$tT", Calendar.getInstance()));
					}
				}, 2000);
				
			}
		});
		
		mHuageListView.setPreLoadCount(12);
		
		mHuageListView.setPullLoadEnable(new IXListViewLoadMore() {
			
			@Override
			public void onLoadMore() {
				
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						mHuageListView.stopLoadMore();
					}
				}, 2000);
				
			}
		});

	}
}
