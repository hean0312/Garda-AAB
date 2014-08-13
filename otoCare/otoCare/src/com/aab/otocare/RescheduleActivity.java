package com.aab.otocare;

import android.app.Activity;
import android.os.Bundle;

public class RescheduleActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * ada 2 opsi :
	 * a. reschedule periodic services : muncul 3 input yaitu tanggal, waktu dan lokasi.
	 * b. renewal request for inssurance : muncul policy summary (ambil dari DB) dan contact number untuk dihubungi 
	 * abis di-submit langsung masuk ke dashboard PIC Officer, maksudnya ??
	 * ada 2 tombol, tombol save buat a. dan tombol submit buat b.
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reschedule);
	}
}
