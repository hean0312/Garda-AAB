package com.aab.otocare.helper;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class Utilities {
	
	public static Intent giveIntent;
	public static Intent takeIntent;
	public static ProgressDialog progress;
	
	public static String urlBase = "http://bolehnego.com/aab/";
	public static String loginMember = "http://bolehnego.com/aab/loginotocare.php";
	public static String loginMember2 = "http://bolehnego.com/aab/loginotocare2.php";
	
	public static String response = "";
			
	public static int interval = 5000;
	
	public static String goToGeocoder(Activity mContext, double lat, double lng) throws IOException{
		List<Address> almt;
		String alamat = null;
		//StringBuilder sb = new StringBuilder();
		try {
			Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
			almt = geocoder.getFromLocation(lat, lng, 5);
			if (almt.size() > 0 && almt !=null) {
				
				Address almtSkrng = almt.get(0);
				//String admin_area = sb.append(almtSkrng.getAdminArea()).toString();
				//String postalcode = sb.append(almtSkrng.getPostalCode()).toString();
				if (almtSkrng.getAddressLine(0).equals(null)||almtSkrng.getAddressLine(0).equals("")) {
					alamat = almtSkrng.getFeatureName();
				} 
				alamat = almtSkrng.getAddressLine(0)+" "+almtSkrng.getAdminArea();
			}else{
				alamat = "";
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			alamat = "";
			Log.e("Utilities", e.getMessage());
		}
		
		return alamat;
	}
	
	public static String jarak(String distance){
		String d = "";
		
		double m = Math.floor(Double.parseDouble(distance));
		
		if (m < 1) {
			d = m + " m";
		} else {
			d = m + " km";
		}
		
		return d;
	}
	
	public static void makeCall(Activity activity, String number){
		if (!number.equals("")) {
			Intent i_call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
			activity.startActivity(i_call);
		} 
	}
	
	public static void makeEmail(Activity activity, String email) {
		// TODO Auto-generated method stub
		Intent intent_email = new Intent(Intent.ACTION_SEND);
		intent_email.setData(Uri.parse("mail:"));
		intent_email.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
		intent_email.putExtra(Intent.EXTRA_SUBJECT, "Sent from Garda otoCare Mobile");
		intent_email.setType("message/rfc822");
		activity.startActivity(intent_email);
	}
	
	public static void makeWeb(Activity activity, String url){
		if (!url.equals("")) {
			
			if (!url.contains("http://")) {
				url = "http://"+url;
			}
			
			Uri uri = Uri.parse(url);
			Intent i = new Intent(Intent.ACTION_VIEW, uri);
			activity.startActivity(i);
		}
	}
	
	public static void errorMsg(Context context){
		Toast.makeText(context, "Sorry, something not right / no internet connection", Toast.LENGTH_SHORT).show();
	}	
	
	public static void errorMsgCustom(Context context, String message, int length){
		switch (length) {
		case 1:
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			break;

		case 10:
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
			break;
			
		default:
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			break;
		}
	}	
	
}
