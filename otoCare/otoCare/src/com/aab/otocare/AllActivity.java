package com.aab.otocare;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class AllActivity extends TabActivity{

	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all);
		
		tabHost = getTabHost();
		
		tabHost.addTab(tabHost
				.newTabSpec("tab1")
				.setIndicator("",
						getResources().getDrawable(R.drawable.home))
				.setContent(new Intent(this, HomeActivity.class)));

		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("",
						getResources().getDrawable(R.drawable.invoice))
				.setContent(new Intent(this, ProfileRegistrationActivity.class)));
		//harus nya ke profile

		tabHost.addTab(tabHost
				.newTabSpec("tab3")
				.setIndicator("",
						getResources().getDrawable(R.drawable.products))
				.setContent(new Intent(this, LocationActivity.class)));
		
		tabHost.addTab(tabHost
				.newTabSpec("tab4")
				.setIndicator("",
						getResources().getDrawable(R.drawable.invoice))
				.setContent(new Intent(this, KnowledgeActivity.class)));

		tabHost.addTab(tabHost
				.newTabSpec("tab5")
				.setIndicator("",
						getResources().getDrawable(R.drawable.products))
				.setContent(new Intent(this, SettingActivity.class)));
		
		tabHost.setCurrentTab(0);
		
//		for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
//		{
//        	tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#F7F3F7"));
//		}
//		
//		tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#1E90FF"));
	}

//	@Override
//	public void onTabChanged(String tabId) {
//		// TODO Auto-generated method stub
//	    for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
//		{
//			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#F7F3F7"));
//		}
//
//		tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#1E90FF"));
//	}
}
