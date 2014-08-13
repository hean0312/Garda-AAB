package com.aab.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MedicalControlActivity extends Activity {

	TextView txtSetCheckUpMedical;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medical_control);
		
		txtSetCheckUpMedical = (TextView)findViewById(R.id.txtSetCheckUpMedical);
	}
	
	public void onClickMedicalControl (View v)
    {
        int id = v.getId();
        if (id == R.id.ll_preg_set_checkup) {
        	startActivity(new Intent(getApplicationContext(), CreateAlarmDateActivity.class));
		} else if (id == R.id.ll_preg_alarm) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.ll_preg_alert) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnYesMedical) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnNoMedical) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		} else if (id == R.id.btnSaveMedical) {
			startActivity(new Intent(getApplicationContext(), ReminderNewListActivity.class));
		}
    }

	
}
