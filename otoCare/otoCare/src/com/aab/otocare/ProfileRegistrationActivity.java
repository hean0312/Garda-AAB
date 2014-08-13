package com.aab.otocare;

//import com.aab.otocare.helper.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.aab.otocare.helper.ConnectionDetector;
import com.aab.otocare.helper.HTTPRequest;
import com.aab.otocare.helper.Utilities;
import com.aab.otocare.model.MemberModel;
import com.aab.otocare.session.ProfileSession;

public class ProfileRegistrationActivity extends Activity implements OnCheckedChangeListener{	
	
	EditText txtEngine, txtChassis;
	String valNoEngine, valNoChassis;
	ProgressBar dialog;
	boolean running = true;
	boolean valSwitch = false;
	JSONArray arrLogin;
	JSONObject objMember;
	private MemberModel member;
	
	ProfileSession myProfile;
	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_registration);
	
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile_registration);
		
		txtEngine = (EditText)findViewById(R.id.txt_engine_number);
		txtChassis = (EditText)findViewById(R.id.txt_chassis_number);
		dialog = (ProgressBar) findViewById(R.id.pd_splash_indicator);
		myProfile = new ProfileSession(getApplicationContext());
		
		if (ConnectionDetector.haveInternet2(getApplicationContext()))
		{
			Utilities.errorMsgCustom(getApplicationContext(), "Yes, there's Connection Internet", 1);
		}
		else
		{
			Utilities.errorMsgCustom(getApplicationContext(), "Load Data Offline", 1);
			if (myProfile.checkShared() == true)
			{
				new CacheCheckLoginOto().execute();
			}
			else
			{
				Utilities.errorMsgCustom(getApplicationContext(), "No Data Offline", 1);
			}
		}
		
        Switch s = (Switch) findViewById(R.id.onOff);
        if (s != null)
        {
            s.setOnCheckedChangeListener(this);
        }
	}
		 
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       Toast.makeText(this, "Monitored switch is " + (isChecked ? "on" : "off"),
               Toast.LENGTH_SHORT).show();
       
       if(isChecked == true)
       {
    	   valSwitch = true;
    	   txtEngine.setText("");
    	   txtChassis.setText("");
    	   txtEngine.setEnabled(false);
    	   txtChassis.setEnabled(false);
    	   txtEngine.setFocusable(false);
    	   txtChassis.setFocusable(false);
    	   
       }
       else
       {
    	   valSwitch = false;
    	   txtEngine.setEnabled(true);
    	   txtChassis.setEnabled(true);
    	   txtEngine.setFocusableInTouchMode(true);
    	   txtChassis.setFocusableInTouchMode(true);
    	   txtEngine.requestFocus();
       }
       
    }

	public void onClickRegister (View v)
	{
		int id = v.getId();
		
		if (id == R.id.btnSubmitRegister) {
			if(valSwitch == true)
			{
				Utilities.giveIntent = new Intent(getApplicationContext(), ProfileNonCustomerActivity.class);
				Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(Utilities.giveIntent);
				finish();
			}
			else
			{
				if (ConnectionDetector.haveInternet2(getApplicationContext()))
				{
					Utilities.errorMsgCustom(getApplicationContext(), "Yes, there's Connection Internet", 1);
					new CheckLoginOto().execute();
				}
				else
				{
					Utilities.errorMsgCustom(getApplicationContext(), "Load Data Offline", 1);
					if (myProfile.checkShared() == true)
					{
						new CacheCheckLoginOto().execute();
					}
					else
					{
						Utilities.errorMsgCustom(getApplicationContext(), "No Data Offline", 1);
					}
				}
				
				
				txtEngine.setText("");
				txtChassis.setText("");
			}
			
		}
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
	
	private class CheckLoginOto extends AsyncTask<Void, Void, String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url_login = "http://bolehnego.com/aab/loginotocare2.php?noMesin=123&noRangka=123";
			ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
			postParameters.add(new BasicNameValuePair("noMesin", valNoEngine));
            postParameters.add(new BasicNameValuePair("noRangka", valNoChassis));
            
            
            try {
            	Utilities.response = HTTPRequest.executeHttpGet(url_login);
//            	response = HTTPRequest.executeHttpPost(Utilities.loginMember, postParameters);
				Log.d("CHECK-PROFILE-REGISTER", Utilities.response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.d("CHECK-PROFILE-REGISTER2", Utilities.response);
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
					
					member = new MemberModel(objMember.getString("Name"),
							objMember.getString("Email"),
							objMember.getString("TelephoneNumber"),
							objMember.getString("HomeAddress"),
							objMember.getString("DOB"),
							objMember.getString("SIMExpiredDate"),
							objMember.getString("PoliceNumber"),
							objMember.getString("VehicleBrand"),
							objMember.getString("VehicleType"),
							objMember.getString("VehicleYear"),
							objMember.getString("ChassisNumber"),
							objMember.getString("EngineNumber"),
							objMember.getString("STNKExpiredDate"),
							objMember.getString("PolicyNumber"),
							objMember.getString("InsuranceName"),
							objMember.getString("PolicyPeriodFrom"),
							objMember.getString("PolicyPeriodTo"),
							objMember.getString("Coverage"));
					
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
				
				startActivityForResult(giveIntent, 0);
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
