package com.aab.medicare;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class PopUpAlarmDateActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);	
				
		/** Creating an Alert Dialog Window */
		AlarmReminder alertReminder = new AlarmReminder();
		
		/** Opening the Alert Dialog Window */
		alertReminder.show(getSupportFragmentManager(), "AlertDemo");		
	}
}
