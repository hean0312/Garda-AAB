package com.aab.otocare.session;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.aab.otocare.AllActivity;

@SuppressLint("CommitPrefEdits")
public class ProfileSession {
	// Shared Preferences
	SharedPreferences pref;
	
	// Editor for Shared preferences
	Editor editor;
	
	// Context
	Context _context;
	
	// Shared pref mode
	int PRIVATE_MODE = 0;
	
	// Sharedpref file name
	private static final String PREF_NAME = "AABPref";
	
	// All Shared Preferences Keys
	private static final String IS_LOGIN = "isLogin";
	
	//(make variable public to access from outside)
	public static final String KEY_RESULT = "myResult";
	
	// spesial
	
	public static final String MY_NAME = "name";
	public static final String MY_EMAIL = "email";
	public static final String TELEPHONE_NUMBER = "telephoneNumber";
	public static final String HOME_ADDRESS = "homeAddress";
	public static final String MY_DOB = "DOB";
	
	public static final String SIM_EXPIRED_DATE = "simExpiredDate";
	public static final String POLICE_NUMBER = "policeNumber";
	public static final String VEHICLE_BRAND = "vehicleBrand";
	public static final String VEHICLE_TYPE = "vehicleType";
	public static final String VEHICLE_YEAR = "vehicleYear";
	
	public static final String CHASSIS_NUMBER = "chassisNumber";
	public static final String ENGINE_NUMBER = "engineNumber";
	public static final String STNK_EXPIRED_DATE = "stnkExpiredDate";
	public static final String POLICY_NUMBER = "policyNumber";
	public static final String INSURANCE_NAME = "insuranceName";
	

	public static final String POLICY_PERIOD_FROM = "policyPeriodFrom";
	public static final String POLICY_PERIOD_TO = "policyPeriodTo";
	public static final String MY_COVERAGE = "coverage";
	
	// spesial
	
	// Constructor
	public ProfileSession(Context context){
		this._context = context;
		pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}
		
	public void createDataShared (String myResult)
	{
		editor.putBoolean(IS_LOGIN, true);
		editor.putString(KEY_RESULT, myResult);
		editor.commit();
	}
	
	public void createDataShared2 (String name, String email, 
			String telephoneNumber, String homeAddress, 
			String DOB, String simExpiredDate, String policeNumber, 
			String vehicleBrand, String vehicleType, String vehicleYear, 
			String chassisNumber, String engineNumber, String stnkExpiredDate,
			String policyNumber, String insuranceName, String policyPeriodFrom, 
			String policyPeriodTo, String coverage)
	{
		editor.putBoolean(IS_LOGIN, true);
		editor.putString(MY_NAME, name);
		editor.putString(MY_EMAIL, email);
		editor.putString(TELEPHONE_NUMBER, telephoneNumber);
		editor.putString(HOME_ADDRESS, homeAddress);
		editor.putString(MY_DOB, DOB);
		
		editor.putString(SIM_EXPIRED_DATE, simExpiredDate);
		editor.putString(POLICE_NUMBER, policeNumber);
		editor.putString(VEHICLE_BRAND, vehicleBrand);
		editor.putString(VEHICLE_TYPE, vehicleType);
		editor.putString(VEHICLE_YEAR, vehicleYear);
		
		editor.putString(CHASSIS_NUMBER, chassisNumber);
		editor.putString(ENGINE_NUMBER, engineNumber);
		editor.putString(STNK_EXPIRED_DATE, stnkExpiredDate);
		editor.putString(POLICY_NUMBER, policyNumber);
		editor.putString(INSURANCE_NAME, insuranceName);
		
		editor.putString(POLICY_PERIOD_FROM, policyPeriodFrom);
		editor.putString(POLICY_PERIOD_TO, policyPeriodTo);
		editor.putString(MY_COVERAGE, coverage);
		
		editor.commit();
	}
	
	/**
	 * Get stored session data
	 * */
	public HashMap<String, String> getDataShared2(){
		HashMap<String, String> myData = new HashMap<String, String>();
		myData.put(MY_NAME, pref.getString(MY_NAME, null));
		myData.put(MY_EMAIL, pref.getString(MY_EMAIL, null));
		myData.put(TELEPHONE_NUMBER, pref.getString(TELEPHONE_NUMBER, null));
		myData.put(HOME_ADDRESS, pref.getString(HOME_ADDRESS, null));
		myData.put(MY_DOB, pref.getString(SIM_EXPIRED_DATE, null));
		
		myData.put(SIM_EXPIRED_DATE, pref.getString(SIM_EXPIRED_DATE, null));
		myData.put(POLICE_NUMBER, pref.getString(POLICE_NUMBER, null));
		myData.put(VEHICLE_BRAND, pref.getString(VEHICLE_BRAND, null));
		myData.put(VEHICLE_TYPE, pref.getString(VEHICLE_TYPE, null));
		myData.put(VEHICLE_YEAR, pref.getString(VEHICLE_YEAR, null));
		
		myData.put(CHASSIS_NUMBER, pref.getString(CHASSIS_NUMBER, null));
		myData.put(ENGINE_NUMBER, pref.getString(ENGINE_NUMBER, null));
		myData.put(STNK_EXPIRED_DATE, pref.getString(STNK_EXPIRED_DATE, null));
		myData.put(POLICY_NUMBER, pref.getString(POLICY_NUMBER, null));
		myData.put(INSURANCE_NAME, pref.getString(POLICY_PERIOD_FROM, null));
		
		myData.put(POLICY_PERIOD_FROM, pref.getString(POLICY_PERIOD_FROM, null));
		myData.put(POLICY_PERIOD_TO, pref.getString(POLICY_PERIOD_TO, null));
		myData.put(MY_COVERAGE, pref.getString(MY_COVERAGE, null));
		
		return myData;
	}
	
	/**
	 * Get stored session data
	 * */
	public HashMap<String, String> getDataShared(){
		HashMap<String, String> myData = new HashMap<String, String>();
		myData.put(KEY_RESULT, pref.getString(KEY_RESULT, null));
		return myData;
	}
	
	/**
	 * Clear session details
	 * */
	public void logoutUser(){
		// Clearing all data from Shared Preferences
		editor.clear();
		editor.commit();
		
		// After logout redirect user to Loing Activity
		Intent i = new Intent(_context, AllActivity.class);
		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		// Staring Login Activity
		_context.startActivity(i);

	}
	
	public boolean haveDataShared()
	{
		return pref.getBoolean(IS_LOGIN, false);
	}
	
	public boolean checkShared()
	{
		if (this.haveDataShared() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clearDataShared(){
		// Clearing all data from Shared Preferences
		editor.clear();
		editor.commit();
	}
	
	
	/**
	 * Quick check for login
	 * **/
	// Get Login State
	public boolean isLoggedIn(){
		return pref.getBoolean(IS_LOGIN, false);
	}

}
