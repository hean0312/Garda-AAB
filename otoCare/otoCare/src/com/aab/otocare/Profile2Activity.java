package com.aab.otocare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aab.otocare.helper.Utilities;

public class Profile2Activity extends Activity {
	
	TextView txt_police_number, txt_vehicle_brand, txt_vehicle_type, txt_vehicle_year, txt_engine_number, txt_chassis_number,txt_stnk_expired;
	Button btnNextProfile3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile2);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile);
		
		txt_police_number = (TextView)findViewById(R.id.txt_police_number);
		txt_vehicle_brand = (TextView)findViewById(R.id.txt_vehicle_brand);
		txt_vehicle_type = (TextView)findViewById(R.id.txt_vehicle_type);
		txt_vehicle_year = (TextView)findViewById(R.id.txt_vehicle_year);
		txt_engine_number = (TextView)findViewById(R.id.txt_engine_number);
		txt_chassis_number = (TextView)findViewById(R.id.txt_chassis_number);
		txt_stnk_expired = (TextView)findViewById(R.id.txt_stnk_expired);
		
		btnNextProfile3 = (Button)findViewById(R.id.btnNextProfile3);
		
		Utilities.takeIntent = getIntent();
		
		txt_police_number.setText(Utilities.takeIntent.getStringExtra("txtPN"));
		txt_vehicle_brand.setText(Utilities.takeIntent.getStringExtra("txtVB"));
		txt_vehicle_type.setText(Utilities.takeIntent.getStringExtra("txtVT"));
		txt_vehicle_year.setText(Utilities.takeIntent.getStringExtra("txtVY"));
		txt_engine_number.setText(Utilities.takeIntent.getStringExtra("txtEN"));
		txt_chassis_number.setText(Utilities.takeIntent.getStringExtra("txtCN"));
		txt_stnk_expired.setText(Utilities.takeIntent.getStringExtra("txtSTNK"));
	}
	
	public void onClickProfile2(View v)
	{
		int id = v.getId();
		
		if (id == R.id.btnNextProfile3) {
			Intent giveIntent = new Intent(getApplicationContext(), Profile3Activity.class);
			giveIntent.putExtra("txtPolicyNumber", Utilities.takeIntent.getStringExtra("txtPolicyNumber"));
			giveIntent.putExtra("txtInsurance", Utilities.takeIntent.getStringExtra("txtInsurance"));
			giveIntent.putExtra("txtPPF", Utilities.takeIntent.getStringExtra("txtPPF"));

			giveIntent.putExtra("txtPPT", Utilities.takeIntent.getStringExtra("txtPPT"));
			giveIntent.putExtra("txtCover", Utilities.takeIntent.getStringExtra("txtCover"));
			startActivityForResult(giveIntent, 0);
		}
	}
}
