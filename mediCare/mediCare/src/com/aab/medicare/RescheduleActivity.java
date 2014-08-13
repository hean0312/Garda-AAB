package com.aab.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RescheduleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reschedule);
	}

	public void onClickReschedule (View v)
    {
        int id = v.getId();
        if (id == R.id.ll_reschedule_name_and_time) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_reschedule_preferred_date) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_reschedule_remindmeon) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_reschedule_location) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnSaveReschedule) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		}
    }
	
}
