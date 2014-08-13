package com.aab.medicare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileNonCustomerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_non_customer);
		
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile_non_customer);
		
		/*
		 * yang bisa diedit : name, age, disease history, emergency no
		 * 
		 * yang ga bisa diedit : company, benefit of coverage, claim history, view setting, my insurance card.
		 * 
		 * klopun di klik, muncul alert dialog : this menu restricted to garda medika member only. lalu ada pilihan YES n NO
		 * klo YES, ke halaman profile, klo NO, ttp di halaman ini
		 */
	}

}
