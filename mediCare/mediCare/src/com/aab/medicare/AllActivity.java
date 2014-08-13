package com.aab.medicare;

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
				.setIndicator("",getResources().getDrawable(R.drawable.icon_home))
				.setContent(new Intent(this, HomeActivity.class)));		    
		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_profile))
				.setContent(new Intent(this, ProfileDetailsActivity.class)));	
		tabHost.addTab(tabHost
				.newTabSpec("tab3")
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_maps))
				.setContent(new Intent(this, LocationActivity.class)));		
		tabHost.addTab(tabHost
				.newTabSpec("tab4")
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_knowlage))
				.setContent(new Intent(this, KnowledgeActivity.class)));
		tabHost.addTab(tabHost
				.newTabSpec("tab5")
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_setting))
				.setContent(new Intent(this, SettingActivity.class)));		
		tabHost.setCurrentTab(0);		
				
	}		
		
}
