package com.aab.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aab.medicare.helper.Utilities;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_home);
	}

	public void onClickHome (View v)
	{
		int id = v.getId();
		if (id == R.id.ll_home1) {
			startActivity(new Intent(getApplicationContext(), ReminderActivity.class));
		} else if (id == R.id.ll_home2) {
			startActivity(new Intent(getApplicationContext(), ReminderActivity.class));
		} else if (id == R.id.imageView10) {
			Utilities.makeCall(HomeActivity.this, "120");
		}
	}
}
