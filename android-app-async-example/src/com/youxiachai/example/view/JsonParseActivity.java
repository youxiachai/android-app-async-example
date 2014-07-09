package com.youxiachai.example.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.youxiachai.appasync.WrapIon;
import com.youxiachai.appasync.DataHanlder.DataEnd;
import com.youxiachai.appasync.example.R;
import com.youxiachai.example.model.Exiftinfo;



public class JsonParseActivity extends Activity{
	
	public static void start(Activity act) {
		Intent intent = new Intent();
		intent.setClass(act, JsonParseActivity.class);
		
		act.startActivity(intent);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jsonparser);
		
		
		String apiUrl = "http://qiniuphotos.qiniudn.com/gogopher.jpg?imageInfo";
	
		
		WrapIon<Exiftinfo> test = new WrapIon<Exiftinfo>(apiUrl, this, new Exiftinfo());
		
		
		test.pipe(new DataEnd<Exiftinfo>() {

			@Override
			public void onEnd(Exiftinfo result) {
				TextView tv1 = (TextView) findViewById(R.id.textView1);
				
				tv1.setText("format: " + result.format);
				
				TextView tv2 = (TextView) findViewById(R.id.textView2);
				
				tv2.setText("width: " + result.width);
				
				TextView tv3 = (TextView) findViewById(R.id.textView3);
				
				tv3.setText("height: " + result.height);
				
				TextView tv4 = (TextView) findViewById(R.id.textView4);
				
				tv4.setText("colorModel: " + result.colorModel);
				
			
			}
		});
		
	}

	
}
