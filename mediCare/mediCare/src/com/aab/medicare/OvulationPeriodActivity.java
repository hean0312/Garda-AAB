package com.aab.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OvulationPeriodActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ovulation_period);
	}

	public void onClickOvuPeriod (View v)
    {
        int id = v.getId();
        if (id == R.id.ll_ovu_mens_cycle) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_ovu_lastmonth) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_ovu_estimates) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_ovu_alert) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_ovu_repeat) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnYesOvu) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnNoOvu) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnSaveOvu) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		}
    }
	
}
