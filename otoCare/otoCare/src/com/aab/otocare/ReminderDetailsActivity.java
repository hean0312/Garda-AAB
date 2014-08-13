package com.aab.otocare;

import android.app.Activity;
import android.os.Bundle;

public class ReminderDetailsActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * dalam reminder details ini ada 4 button, reschedule, renewal request, done, remind later,
	 * ke-4 btn tsb dimunculkan saja dalam layout xml activity_reminder_details,
	 * nanti baru pakai switch untuk membedakan apakah yang diklik user adalah
	 * periodic service, stnk renewal, inssurance renewal 
	 * berdasarkan ke-3 pilihan tersebut, baru nanti dibuat visible invisible ke-4 button nya.
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder_details);
	}
}
