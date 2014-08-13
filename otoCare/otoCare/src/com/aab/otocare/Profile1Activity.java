package com.aab.otocare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aab.otocare.helper.Utilities;

public class Profile1Activity extends Activity {

	String myValSwitch;
	String txtPN,VehicleBrand,VehicleType,VehicleYear,ChassisNumber,EngineNumber,STNKExpiredDate,PolicyNumber,InsuranceName,PolicyPeriodFrom,PolicyPeriodTo,Coverage;
	TextView txtName, txtEmail, txtPhone, txtHome, txtDOB, txtSIM;
	Button btnNextProfile2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile1);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile);
		
		txtName = (TextView)findViewById(R.id.txtName);
		txtEmail = (TextView)findViewById(R.id.txtEmail);
		txtPhone = (TextView)findViewById(R.id.txtPhone);
		txtHome = (TextView)findViewById(R.id.txtHome);
		txtDOB = (TextView)findViewById(R.id.txtDOB);
		txtSIM = (TextView)findViewById(R.id.txtSIM);
		
		btnNextProfile2 = (Button)findViewById(R.id.btnNextProfile2);
		
		Utilities.takeIntent = getIntent();
		
		txtName.setText(Utilities.takeIntent.getStringExtra("txtName"));
		txtEmail.setText(Utilities.takeIntent.getStringExtra("txtEmail"));
		txtPhone.setText(Utilities.takeIntent.getStringExtra("txtPhone"));
		txtHome.setText(Utilities.takeIntent.getStringExtra("txtHome"));
		txtDOB.setText(Utilities.takeIntent.getStringExtra("txtDOB"));
		txtSIM.setText(Utilities.takeIntent.getStringExtra("txtSIM"));
		
		txtPN = Utilities.takeIntent.getStringExtra("txtPN");
		VehicleBrand = Utilities.takeIntent.getStringExtra("txtVB");
		
		VehicleType = Utilities.takeIntent.getStringExtra("txtVT");
		VehicleYear = Utilities.takeIntent.getStringExtra("txtVY");
		
		ChassisNumber = Utilities.takeIntent.getStringExtra("txtCN");
		EngineNumber = Utilities.takeIntent.getStringExtra("txtEN");
		
		STNKExpiredDate = Utilities.takeIntent.getStringExtra("txtSTNK");
		PolicyNumber = Utilities.takeIntent.getStringExtra("txtPolicyNumber");
		
		PolicyPeriodFrom = Utilities.takeIntent.getStringExtra("txtPPF");
		PolicyPeriodTo = Utilities.takeIntent.getStringExtra("txtPPT");
		Coverage = Utilities.takeIntent.getStringExtra("txtCover");

	}
	
	public void onClickProfile(View v)
	{
		int id = v.getId();
		
		if (id == R.id.btnNextProfile2) {
			Intent giveIntent = new Intent(getApplicationContext(), Profile2Activity.class);
			giveIntent.putExtra("txtPN", txtPN);
			giveIntent.putExtra("txtVB", VehicleBrand);
			
			giveIntent.putExtra("txtVT", VehicleType);
			giveIntent.putExtra("txtVY", VehicleYear);
			giveIntent.putExtra("txtCN", ChassisNumber);
			giveIntent.putExtra("txtEN", EngineNumber);
			
			giveIntent.putExtra("txtSTNK", STNKExpiredDate);
			giveIntent.putExtra("txtPolicyNumber", PolicyNumber);
			giveIntent.putExtra("txtInsurance", InsuranceName);
			giveIntent.putExtra("txtPPF", PolicyPeriodFrom);

			giveIntent.putExtra("txtPPT", PolicyPeriodTo);
			giveIntent.putExtra("txtCover", Coverage);
			startActivityForResult(giveIntent, 0);
		}
	}
}
