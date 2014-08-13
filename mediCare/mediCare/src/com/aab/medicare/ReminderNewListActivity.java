package com.aab.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReminderNewListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_new_list);
	}
	
	public void onClickReminderNewList (View v)
    {
        int id = v.getId();
        if (id == R.id.ll_newlist_name) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_newlist_set_reminder) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_newlist_alarm) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_newlist_repeat) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnYesNewlist) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnNoNewlist) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnSaveNewlist) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		}
    }
}
