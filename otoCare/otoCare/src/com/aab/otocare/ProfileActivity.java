package com.aab.otocare;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.aab.otocare.helper.ConnectionDetector;
import com.aab.otocare.helper.Utilities;
import com.aab.otocare.session.ProfileSession;

public class ProfileActivity extends Activity {
	ProfileSession myProfile;
	ProgressBar dialog;
	JSONArray arrLogin;
	JSONObject objMember;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		dialog = (ProgressBar) findViewById(R.id.pd_splash_indicator);
		
		myProfile = new ProfileSession(getApplicationContext());
		
		Utilities.progress = ProgressDialog.show(this, getResources().getString(R.string.progressDialogTitle), getResources().getString(R.string.progressDialogMessage) , true);
		
		new CountDownTimer(10000, 100) {

		     public void onTick(long millisUntilFinished) {
		    	if (myProfile.checkShared() == true)
		 		{
		 			new CacheCheckLoginOto().execute();
		 		}
		 		else
		 		{
		 			Utilities.giveIntent = new Intent(getApplicationContext(), ProfileRegistrationActivity.class);
		 			startActivity(Utilities.giveIntent);
		 		}
		     }
		     public void onFinish() {
		    	 Utilities.progress.dismiss();
		     }
		  }.start();
		  
		
	}
	
	private class CacheCheckLoginOto extends AsyncTask<Void, Void, String>{

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
				if (myProfile.checkShared() == true)
				{
					// have cache
					HashMap<String, String> myProfileGetData = myProfile.getDataShared();
					
					Utilities.response = myProfileGetData.get(ProfileSession.KEY_RESULT);
					
					if(Utilities.response == null)
					{
						Log.d("CACHE-PROFILE1", "NULL");
					}
				}
				else
				{
					Utilities.response = "";
				}
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
		if (result.equals(""))
			{
				Utilities.errorMsg(getApplicationContext());
				Log.d("Profile1", result);
			}
			else
			{
				fetchResponse(result);
				Log.d("Profile2", result);
			}
		}	
	}
	
	public void fetchResponse(String response){
		try {
			
			if (ConnectionDetector.haveInternet2(getApplicationContext()))
			{
				myProfile.clearDataShared();
				myProfile.createDataShared(response);
			}
			else
			{
				myProfile.createDataShared(response);
			}
			
			arrLogin = new JSONArray(response);
			if (arrLogin.length()>0)
			{
				Intent giveIntent = new Intent(getApplicationContext(), Profile1Activity.class);
				for(int i = 0; i < arrLogin.length(); i++)
				{
					objMember = arrLogin.getJSONObject(i);
					
					giveIntent.putExtra("txtName", objMember.getString("Name"));
					giveIntent.putExtra("txtEmail", objMember.getString("Email"));
					giveIntent.putExtra("txtPhone", objMember.getString("TelephoneNumber"));
					giveIntent.putExtra("txtHome", objMember.getString("HomeAddress"));
					
					giveIntent.putExtra("txtDOB", objMember.getString("DOB"));
					giveIntent.putExtra("txtSIM", objMember.getString("SIMExpiredDate"));
					giveIntent.putExtra("txtPN", objMember.getString("PoliceNumber"));
					giveIntent.putExtra("txtVB", objMember.getString("VehicleBrand"));
					
					giveIntent.putExtra("txtVT", objMember.getString("VehicleType"));
					giveIntent.putExtra("txtVY", objMember.getString("VehicleYear"));
					giveIntent.putExtra("txtCN", objMember.getString("ChassisNumber"));
					giveIntent.putExtra("txtEN", objMember.getString("EngineNumber"));
					
					giveIntent.putExtra("txtSTNK", objMember.getString("STNKExpiredDate"));
					giveIntent.putExtra("txtPolicyNumber", objMember.getString("PolicyNumber"));
					giveIntent.putExtra("txtInsurance", objMember.getString("InsuranceName"));
					giveIntent.putExtra("txtPPF", objMember.getString("PolicyPeriodFrom"));

					giveIntent.putExtra("txtPPT", objMember.getString("PolicyPeriodTo"));
					giveIntent.putExtra("txtCover", objMember.getString("Coverage"));
					
				}
				
				
				giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivityForResult(giveIntent, 0);
				finish();
			}
			else
			{
				
			}
		}
		catch (Exception e) {
			Utilities.errorMsgCustom(getApplicationContext(), e.getMessage(), 1);
		}
	}
}
