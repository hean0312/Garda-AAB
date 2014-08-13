package com.aab.otocare;

import android.app.Activity;
import android.os.Bundle;

public class DoneActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * pada DoneActivity, ada 3 hal yang terjadi :
	 * a. saat done untuk periodic service maka akan muncul 3 input yaitu odometer, tanggal dan cost service.
	 * b. saat done untuk  stnk maka tidak akan muncul reminder lagi dan masa expired STNK ditambahkan 1 tahun (by script ke DB)
	 * c. saat done untuk inssurance maka tidak akan muncul reminder lagi dan masa expired Insurance ditambahkan 1 tahun.
	 *  
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_done);
	}
}
