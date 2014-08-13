package com.aab.medicare;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aab.medicare.helper.HTTPRequest;
import com.aab.medicare.helper.JSONParser;
import com.aab.medicare.helper.Utilities;

public class ProfileForgotActivity extends Activity {

	EditText txtCompany, txtNPK, txtBirthdate2;
	String valCompany, valNPK, valBirthdate2;
	
	JSONParser jsonParser = new JSONParser();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_forgot);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_profile_forgot);
		
		txtCompany = (EditText)findViewById(R.id.txtCompany);
		txtNPK = (EditText)findViewById(R.id.txtNPK);
		txtBirthdate2 = (EditText)findViewById(R.id.txtBirthdate2);
		
		valCompany = txtCompany.getText().toString();
		valNPK = txtNPK.getText().toString();
		valBirthdate2 = txtBirthdate2.getText().toString();
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
	}
	
	public void onClickProfileForgot(View v)
	{
		int id = v.getId();
		if (id == R.id.btnSubmit) {
			
			Utilities.progress = ProgressDialog.show(this, getResources().getString(R.string.progressDialogTitle), getResources().getString(R.string.progressDialogMessage) , true);
			
			new CountDownTimer(10000, 100) {

		     public void onTick(long millisUntilFinished) {
				String url_login = Utilities.registerMember2+"?company=company21&npk=npk21&birthdate=birthdate21";
//				JSONObject json = jsonParser.getJSONFromUrl(url_login);
//				Log.d("CHECK", url_login);
				ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
				postParameters.add(new BasicNameValuePair("company", valCompany));
	            postParameters.add(new BasicNameValuePair("npk", valNPK));
	            postParameters.add(new BasicNameValuePair("birthdate", valBirthdate2));
	            
	            try {
	            	Utilities.response = HTTPRequest.executeHttpGet(url_login);
//		            response = HTTPRequest.executeHttpPost(Utilities.registerMember2, postParameters);
					Log.d("CHECK-FORGOT", Utilities.response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
		     public void onFinish() {
		    	 Utilities.progress.dismiss();
		    	 
		    	 //jika berhasil maka akan direct ke home,
		    	 // ini belum ada tektok ke server, dan dianggap berhasil dulu
		    	 
		    	Utilities.giveIntent = new Intent(getApplicationContext(), ProfileDetailsActivity.class);
				Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(Utilities.giveIntent);
				finish();
		     }
		  }.start();
		}
	}
}
