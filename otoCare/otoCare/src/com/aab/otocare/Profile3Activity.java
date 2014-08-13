package com.aab.otocare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aab.otocare.helper.Utilities;

public class Profile3Activity extends Activity {

	TextView txt_policy_number, txt_insurance_name, txt_ppf, txt_ppt, txt_coverage;
	Button btnGoHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile3);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile);
		
		txt_policy_number = (TextView)findViewById(R.id.txt_policy_number);
		txt_insurance_name = (TextView)findViewById(R.id.txt_insurance_name);
		txt_ppf = (TextView)findViewById(R.id.txt_ppf);
		txt_ppt = (TextView)findViewById(R.id.txt_ppt);
		txt_coverage = (TextView)findViewById(R.id.txt_coverage);
		
		btnGoHome = (Button)findViewById(R.id.btnGoHome);
		
		Utilities.takeIntent = getIntent();
		
		txt_policy_number.setText(Utilities.takeIntent.getStringExtra("txtPolicyNumber"));
		txt_insurance_name.setText(Utilities.takeIntent.getStringExtra("txtInsurance"));
		txt_ppf.setText(Utilities.takeIntent.getStringExtra("txtPPF"));
		txt_ppt.setText(Utilities.takeIntent.getStringExtra("txtPPT"));
		txt_coverage.setText(Utilities.takeIntent.getStringExtra("txtCover"));
	}
	
	public void onClickProfile3(View v)
	{
		int id = v.getId();
		
		if (id == R.id.btnGoHome) {
			Utilities.giveIntent = new Intent(getApplicationContext(), HomeActivity.class);
			startActivity(Utilities.giveIntent);
		}
	}
}
