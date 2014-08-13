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

import com.aab.medicare.helper.HTTPRequest;
import com.aab.medicare.helper.JSONParser;
import com.aab.medicare.helper.Utilities;

public class LoginActivity extends Activity {
	
	EditText txtCard, txtBirthdate;
	String valCard, valBirthdate;
	LinearLayout ll_first, ll_next;
	
	JSONParser jsonParser = new JSONParser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		txtCard = (EditText)findViewById(R.id.txtCard);
		txtBirthdate = (EditText)findViewById(R.id.txtBirthdate);
		
		
		valCard = txtCard.getText().toString();
		valBirthdate = txtBirthdate.getText().toString();
		
		//valCard = "post1-rantz";
		//valBirthdate = "post3-rantz";
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
	}
	
	public void onClickLogin (View v)
	{
		int id = v.getId();
		if (id == R.id.btnNonMember) {
			Utilities.giveIntent = new Intent(getApplicationContext(), AllActivity.class);
			Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(Utilities.giveIntent);
			finish();
		} else if (id == R.id.btnForgot) {
			Utilities.giveIntent = new Intent(getApplicationContext(), ForgotActivity.class);
			Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(Utilities.giveIntent);
			finish();
		}
		else if (id == R.id.btnSubmit2) {
			Utilities.progress = ProgressDialog.show(this, getResources().getString(R.string.progressDialogTitle), getResources().getString(R.string.progressDialogMessage) , true);
			
			new CountDownTimer(10000, 100) {

			     public void onTick(long millisUntilFinished) {
		    	 	String url_login = Utilities.registerMember2+"?card=1234&birthdate=01-01-0001";
//					JSONObject json = jsonParser.getJSONFromUrl(url_login);
//					Log.d("CHECK", url_login);
					ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
					postParameters.add(new BasicNameValuePair("card", valCard));
		            postParameters.add(new BasicNameValuePair("birthdate", valBirthdate));
		            
		            
		            try {
		            	Utilities.response = HTTPRequest.executeHttpGet(url_login);
//			            response = HTTPRequest.executeHttpPost(Utilities.registerMember2, postParameters);
						Log.d("CHECK-LOGIN",Utilities. response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			     }
			     public void onFinish() {
			    	 Utilities.progress.dismiss();
			    	 
			    	 //jika berhasil maka akan direct ke home,
			    	 // ini belum ada tektok ke server, dan dianggap berhasil dulu
			    	 
			    	 /*
			    	  * Taty ~ 12 Agustus
			    	  * Harus simpan preferences disini
			    	  */
			    	Utilities.giveIntent = new Intent(getApplicationContext(), AllActivity.class);
					Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(Utilities.giveIntent);
					finish();
			     }
			  }.start();
		}
		
	}
}
