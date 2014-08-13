package com.aab.otocare;

import java.util.Calendar;
import java.util.HashMap;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.aab.otocare.helper.ConnectionDetector;
import com.aab.otocare.helper.HTTPRequest;
import com.aab.otocare.helper.Utilities;
import com.aab.otocare.session.ProfileSession;

public class ProfileNonCustomerActivity extends Activity {

	private EditText txtName, txtEmail, txtPhone, txtAddress,
	txtPN,txtVB, txtVT, txtVY, txtCN, txtEN, txtPN3, txtIN, txtCover,
	txtBirthdate, txtSIMExpired, txtSIMExpired2, txtPPF, txtPPT;
	private DatePicker dpResultBirth;
	private Button btnChangeDate;
	LinearLayout ll1, ll2, ll3;
	ProgressBar dialog;
	ProfileSession myProfile;
	String name, email, telephoneNumber, homeAddress, DOB, 
	simExpiredDate, policeNumber, vehicleBrand, vehicleType, 
	vehicleYear, chassisNumber, engineNumber, stnkExpiredDate, 
	policyNumber, insuranceName, policyPeriodFrom, policyPeriodTo, coverage;
	
	
	private int year;
	private int month;
	private int day;
 
	static final int DATE_DIALOG_ID = 999;
	static final int DATE_DIALOG_ID2 = 998;
	static final int DATE_DIALOG_ID3 = 997;
	static final int DATE_DIALOG_ID4 = 996;
	static final int DATE_DIALOG_ID5 = 995;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_non_customer);
		ll1 = (LinearLayout)findViewById(R.id.ll_profile_non1);
		ll2 = (LinearLayout)findViewById(R.id.ll_profile_non2);
		ll3 = (LinearLayout)findViewById(R.id.ll_profile_non3);
		
		setCurrentDateOnView();
		dialog = (ProgressBar) findViewById(R.id.pd_splash_indicator);
		myProfile = new ProfileSession(getApplicationContext());
	}
	
	// display current date
		public void setCurrentDateOnView() {
			txtName = (EditText) findViewById(R.id.txtName);
			txtEmail = (EditText) findViewById(R.id.txtEmail);
			txtPhone = (EditText) findViewById(R.id.txtPhone);
			txtAddress = (EditText) findViewById(R.id.txtAddress);
			txtBirthdate = (EditText) findViewById(R.id.txtBirthdate);
			txtSIMExpired = (EditText) findViewById(R.id.txtSIMExpired);
			
			
			txtPN = (EditText) findViewById(R.id.txtPN);
			txtVB = (EditText) findViewById(R.id.txtVB);
			txtVT = (EditText) findViewById(R.id.txtVT);
			txtVY = (EditText) findViewById(R.id.txtVY);
			txtCN = (EditText) findViewById(R.id.txtCN);
			txtEN = (EditText) findViewById(R.id.txtEN);
			txtSIMExpired2 = (EditText) findViewById(R.id.txtSIMExpired2);
			
			txtPN3 = (EditText) findViewById(R.id.txtPN3);
			txtIN = (EditText) findViewById(R.id.txtIN);
			txtPPF = (EditText) findViewById(R.id.txtPPF);
			txtPPT = (EditText) findViewById(R.id.txtPPT);
			txtCover = (EditText) findViewById(R.id.txtCover);
			
			dpResultBirth = (DatePicker) findViewById(R.id.dpResultBirth);
	 
			final Calendar c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);
	 
			// set current date into EditText
			txtBirthdate.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(day).append("-").append(month + 1).append("-").append(year).append(" "));
//				.append(month + 1).append("-").append(day).append("-")
//				.append(year).append(" "));
	 
			txtSIMExpired.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
			txtSIMExpired2.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
			txtPPF.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
			txtPPT.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
			  
			
			// set current date into datepicker
			dpResultBirth.init(year, month, day, null);
	 
		}
		
		public void onClickNewMember(View v)
		{
			int id = v.getId();
			if (id == R.id.txtBirthdate) {
				showDialog(DATE_DIALOG_ID);
			}
			else if (id == R.id.txtSIMExpired) {
				showDialog(DATE_DIALOG_ID2);
			}
			else if (id == R.id.txtSIMExpired2) {
				showDialog(DATE_DIALOG_ID3);
			}
			else if (id == R.id.btnNextProfile2) {
				ll1.setVisibility(View.GONE);
				ll2.setVisibility(View.VISIBLE);
				ll3.setVisibility(View.GONE);
			}
			else if (id == R.id.txtPPF) {
				showDialog(DATE_DIALOG_ID4);
			}
			else if (id == R.id.txtPPT) {
				showDialog(DATE_DIALOG_ID5);
			}
			else if (id == R.id.btnNextProfile3) {
				ll1.setVisibility(View.GONE);
				ll2.setVisibility(View.GONE);
				ll3.setVisibility(View.VISIBLE);
			}
			else if (id == R.id.btnSubmitAll) {
				
				Utilities.progress = ProgressDialog.show(this, getResources().getString(R.string.progressDialogTitle), getResources().getString(R.string.progressDialogMessage) , true);
				
				new CountDownTimer(10000, 100) {

				     public void onTick(long millisUntilFinished) {
//			    	 	String url_login = Utilities.loginMember2;
//						JSONObject json = jsonParser.getJSONFromUrl(url_login);
//						Log.d("CHECK", url_login);
				    	 myProfile.clearDataShared();
						myProfile.createDataShared2(txtName.getText().toString(),
								txtEmail.getText().toString(),
								txtPhone.getText().toString(),
								txtAddress.getText().toString(),
								txtBirthdate.getText().toString(),
								txtSIMExpired.getText().toString(),
								txtPN.getText().toString(),
								txtVB.getText().toString(),
								txtVT.getText().toString(),
								txtVY.getText().toString(),
								txtCN.getText().toString(),
								txtEN.getText().toString(),
								txtSIMExpired2.getText().toString(),
								txtPN3.getText().toString(),
								txtIN.getText().toString(),
								txtPPF.getText().toString(),
								txtPPT.getText().toString(),
								txtCover.getText().toString()
								);
				     }
				     public void onFinish() {
				    	 Utilities.progress.dismiss();
				    	 new SaveLocalNewMember().execute();
				    	 //jika berhasil maka akan direct ke home,
				    	 // ini belum ada tektok ke server, dan dianggap berhasil dulu
				    	 
				    	 /*
				    	  * Taty ~ 12 Agustus
				    	  * Harus simpan preferences disini
				    	  */
//				    	Utilities.giveIntent = new Intent(getApplicationContext(), AllActivity.class);
//						Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//						startActivity(Utilities.giveIntent);
//						finish();
				     }
				  }.start();
			}
			
			
		}
		
		private class SaveLocalNewMember extends AsyncTask<Void, Void, String>{

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				dialog.setVisibility(View.VISIBLE);
			}
			
			@Override
			protected String doInBackground(Void... params) {
				
				try
				{
					Log.d("test", txtBirthdate.getText().toString());
				}
				catch (Exception e) 
				{
					Utilities.response = "";
					Log.d("CACHE-PROFILE2", "ERROR "+e.getMessage());
				}
				
				return Utilities.response;
			}
			
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
				super.onPostExecute(result);
				dialog.setVisibility(View.GONE);
				
				Log.d("Profile2", result);
				if (myProfile.checkShared() == true)
				{
					// have cache
					HashMap<String, String> myProfileGetData = myProfile.getDataShared2();
					
					name = myProfileGetData.get(ProfileSession.MY_NAME);
					email = myProfileGetData.get(ProfileSession.MY_EMAIL);
					telephoneNumber = myProfileGetData.get(ProfileSession.TELEPHONE_NUMBER);
					homeAddress = myProfileGetData.get(ProfileSession.HOME_ADDRESS);
					DOB = myProfileGetData.get(ProfileSession.MY_DOB);
					
					simExpiredDate = myProfileGetData.get(ProfileSession.SIM_EXPIRED_DATE);
					policeNumber = myProfileGetData.get(ProfileSession.POLICE_NUMBER);
					vehicleBrand = myProfileGetData.get(ProfileSession.VEHICLE_BRAND);
					vehicleType = myProfileGetData.get(ProfileSession.VEHICLE_TYPE);
					vehicleYear = myProfileGetData.get(ProfileSession.VEHICLE_YEAR);
					
					chassisNumber = myProfileGetData.get(ProfileSession.CHASSIS_NUMBER);
					engineNumber = myProfileGetData.get(ProfileSession.ENGINE_NUMBER);
					stnkExpiredDate = myProfileGetData.get(ProfileSession.STNK_EXPIRED_DATE);
					policyNumber = myProfileGetData.get(ProfileSession.POLICY_NUMBER);
					insuranceName = myProfileGetData.get(ProfileSession.INSURANCE_NAME);
					
					policyPeriodFrom = myProfileGetData.get(ProfileSession.POLICY_PERIOD_FROM);
					policyPeriodTo = myProfileGetData.get(ProfileSession.POLICY_PERIOD_TO);
					coverage = myProfileGetData.get(ProfileSession.MY_COVERAGE);
				}
				
				Intent giveIntent = new Intent(getApplicationContext(), Profile1Activity.class);
				giveIntent.putExtra("txtName", name);
				giveIntent.putExtra("txtEmail", email);
				giveIntent.putExtra("txtPhone", telephoneNumber);
				giveIntent.putExtra("txtHome", homeAddress);
				
				giveIntent.putExtra("txtDOB", DOB);
				giveIntent.putExtra("txtSIM", simExpiredDate);
				giveIntent.putExtra("txtPN", policeNumber);
				giveIntent.putExtra("txtVB", vehicleBrand);
				
				giveIntent.putExtra("txtVT", vehicleType);
				giveIntent.putExtra("txtVY", vehicleYear);
				giveIntent.putExtra("txtCN", chassisNumber);
				giveIntent.putExtra("txtEN", engineNumber);
				
				giveIntent.putExtra("txtSTNK", stnkExpiredDate);
				giveIntent.putExtra("txtPolicyNumber", policyNumber);
				giveIntent.putExtra("txtInsurance", insuranceName);
				giveIntent.putExtra("txtPPF", policyPeriodFrom);

				giveIntent.putExtra("txtPPT", policyPeriodTo);
				giveIntent.putExtra("txtCover", coverage);
				startActivityForResult(giveIntent, 0);
			}	
		}
		
		
		@Override
		protected Dialog onCreateDialog(int id) {
			if (id == DATE_DIALOG_ID) {
				// set date picker as current date
				   return new DatePickerDialog(this, datePickerListener, 
				                 year, month,day);
			}
			else if (id == DATE_DIALOG_ID2) {
				// set date picker as current date
				   return new DatePickerDialog(this, datePickerListener2, 
				                 year, month,day);
			}
			else if (id == DATE_DIALOG_ID3) {
				// set date picker as current date
				   return new DatePickerDialog(this, datePickerListener3, 
				                 year, month,day);
			}
			else if (id == DATE_DIALOG_ID4) {
				// set date picker as current date
				   return new DatePickerDialog(this, datePickerListener4, 
				                 year, month,day);
			}
			else if (id == DATE_DIALOG_ID5) {
				// set date picker as current date
				   return new DatePickerDialog(this, datePickerListener5, 
				                 year, month,day);
			}
			return null;
		}
	 
		private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
	 
			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;
	 
				// set selected date into EditText
				txtBirthdate.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
	 
				// set selected date into datepicker also
				dpResultBirth.init(year, month, day, null);
	 
			}
		};
		
		private DatePickerDialog.OnDateSetListener datePickerListener2 = new DatePickerDialog.OnDateSetListener() {
			 
			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;
	 
				// set selected date into EditText
				txtSIMExpired.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
	 
				// set selected date into datepicker also
				dpResultBirth.init(year, month, day, null);
	 
			}
		};
		
		private DatePickerDialog.OnDateSetListener datePickerListener3 = new DatePickerDialog.OnDateSetListener() {
			 
			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;
	 
				// set selected date into EditText
				txtSIMExpired2.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
	 
				// set selected date into datepicker also
				dpResultBirth.init(year, month, day, null);
	 
			}
		};
		
		private DatePickerDialog.OnDateSetListener datePickerListener4 = new DatePickerDialog.OnDateSetListener() {
			 
			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;
	 
				// set selected date into EditText
				txtPPF.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
	 
				// set selected date into datepicker also
				dpResultBirth.init(year, month, day, null);
	 
			}
		};
		
		private DatePickerDialog.OnDateSetListener datePickerListener5 = new DatePickerDialog.OnDateSetListener() {
			 
			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;
	 
				// set selected date into EditText
				txtPPT.setText(new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" "));
	 
				// set selected date into datepicker also
				dpResultBirth.init(year, month, day, null);
	 
			}
		};
		
}
