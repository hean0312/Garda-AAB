package com.aab.otocare.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {
	private Context _context;
	 
    public ConnectionDetector(Context context){
        this._context = context;
    }
 
    /**
     * Checking for all possible internet providers
     * **/
    public boolean haveInternet1(){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null)
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null)
                  for (int i = 0; i < info.length; i++)
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                          return true;
                      }
 
          }
          return false;
    }
    
    public static boolean haveInternet2(Context context){
		NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
		if (networkInfo==null || !networkInfo.isConnected()) {
			return false;
		} 
		if (networkInfo.isRoaming()) {
			return true;
		}
		
		return true;
    }
    
    @SuppressWarnings("unused")
    public static String basic_get(String url) throws ClientProtocolException, IOException
	{
		String urlFix = Utilities.urlBase+url;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(urlFix);
		HttpResponse response = client.execute(get);
        
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        if(entity != null)
        {
        	
        	//"iso-8859-1"
        	BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
        	
	        StringBuilder sb = new StringBuilder();
	
	        String line = null;
	        while ((line = reader.readLine()) != null)
	        {
	                sb.append(line + "\n");
	        }
	        is.close();
	        return sb.toString();
        }
        else
        {
        	return "entity kosong";
        }
	}
}
