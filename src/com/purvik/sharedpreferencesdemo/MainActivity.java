package com.purvik.sharedpreferencesdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView prefValues;
	RelativeLayout myLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void getPrefValues(View view) {
		
		String colorValue;
	
		SharedPreferences myPreference = getSharedPreferences("com.purvik.sharedpreferencesdemo_preferences", MODE_PRIVATE);
		prefValues = (TextView)findViewById(R.id.prefValues);
		prefValues.setText(" Name:" + myPreference.getString("namePreference", "NAME")+
							"\n Class:" + myPreference.getString("prefClass", "CLASS")+ 
							"\n RingTOne: " + myPreference.getString("prefRingTone", "RINGTONE")+
							"\n BgColor:" + myPreference.getString("prefBgColor", "#FFFFF"));
		
		colorValue = myPreference.getString("prefBgColor", "#FFFFFF");
		Log.i("prefBgColor", colorValue);
		seBackgroundColor(colorValue);
		
		Toast.makeText(getApplicationContext(), "Settings Loaded", Toast.LENGTH_LONG).show();
		
	}

	private void seBackgroundColor(String string) {
		// TODO Auto-generated method stub
		myLayout = (RelativeLayout)findViewById(R.id.mainLayout);
		myLayout.setBackgroundColor(Color.parseColor(string));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
//			Intent settingIntent = new Intent("com.prvik.MyAppSettings");
			Intent settingIntent = new Intent(this, MyAppSettings.class);
			startActivity(settingIntent);	
		}
		return super.onOptionsItemSelected(item);
	}
}
