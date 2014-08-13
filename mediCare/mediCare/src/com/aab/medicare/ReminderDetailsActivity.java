package com.aab.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aab.medicare.helper.Utilities;

public class ReminderDetailsActivity extends Activity {

	String idReminder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_details);
		
		Utilities.takeIntent = getIntent();
		idReminder = Utilities.takeIntent.getStringExtra("id_reminder");
	}
	
	public void onClickReminderDetails (View v)
	{
		int id = v.getId();
		if (id == R.id.btnReschedule) {
			startActivity(new Intent(getApplicationContext(), RescheduleActivity.class));
		} else if (id == R.id.btnDone) {
			startActivity(new Intent(getApplicationContext(), DoneActivity.class));
		} else if (id == R.id.btnRemindLater) {
			startActivity(new Intent(getApplicationContext(), RemindLaterActivity.class));
		}
	}
	
}
