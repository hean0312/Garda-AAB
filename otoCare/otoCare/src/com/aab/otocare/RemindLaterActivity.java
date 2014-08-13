package com.aab.otocare;

import android.app.Activity;
import android.os.Bundle;

public class RemindLaterActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * ada 3 hal :
	 * a. remind later pada periodic service : Akan diingatkan kembali 50 km sebelum acuan service 
	 * b. remind later pada STNK : Akan diingatkan kembali setiap hari selama 7hari sebelum jatuh tempo. 
	 * c. remind later pada inssurance : Akan diingatkan kembali 2 minggu sebelum jatuh tempo
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remind_later);
	}
}
