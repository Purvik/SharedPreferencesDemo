package com.purvik.sharedpreferencesdemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MyAppSettings extends PreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}

}
