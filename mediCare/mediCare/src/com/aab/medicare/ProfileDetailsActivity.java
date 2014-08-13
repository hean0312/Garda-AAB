package com.aab.medicare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_details);
		
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile_details);
	}
}
