package com.aab.otocare;

import java.util.Locale;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends Activity {

	String languageToLoad;
	Locale locale;
	Configuration config;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_setting);
	}
	
	public void onClickSetting (View v)
	{
//		int id = v.getId();
//		switch(id){
//		case R.id.button2 :
//			languageToLoad  = "id"; // your language
//			setLocale(languageToLoad);
//		    Log.d("Home", "Indonesia");
//			break;
//			
//		case R.id.button3 :
//			languageToLoad  = "en"; // your language
//			setLocale(languageToLoad);
//		    Log.d("Home", "English");
//			break;
//			
//		}
	}
	
	public void setLocale(String localeCode)
	{
//		locale = new Locale(localeCode); 
//	    Locale.setDefault(locale);
//	    config = new Configuration();
//	    config.locale = locale;
//	    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
		
		Locale locale = new Locale(localeCode);
	    Locale.setDefault(locale);
	    Configuration config = new Configuration();
	    config.locale = locale;
	    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
	    
	}
}
