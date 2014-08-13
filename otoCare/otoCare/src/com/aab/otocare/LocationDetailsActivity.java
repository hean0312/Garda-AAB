package com.aab.otocare;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aab.otocare.adapter.LocationDetailsAdapter;
import com.aab.otocare.helper.ConnectionDetector;
import com.aab.otocare.helper.JSONParser;
import com.aab.otocare.helper.Utilities;
import com.aab.otocare.model.LocationDetailsModel;

public class LocationDetailsActivity extends Activity {

	private ListView lvLocDetails;
	private ArrayList<LocationDetailsModel>	listLocDetails;
	private LocationDetailsModel Place;
	String idPlace, namePlace, addressPlace, phonePlace, websitePlace, jumRating, totRating, jumReview, lastReview, picPlace, picMarker;
	double longitudePlace, latitudePlace, distance;
	int myChoice;
	TextView txtTitle;
	private ProgressBar dialog;
	boolean running = true;
	
	// Creating JSON Parser object
	JSONParser jp = new JSONParser();
	// JSON node names
	private static final String TAG_NEARME = "nearme";
	JSONArray arrPlace;
	JSONObject objAllPlace, objPlace;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_details);
		
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_location_details);

		dialog = (ProgressBar) findViewById(R.id.pd_splash_indicator);
		
		lvLocDetails = (ListView)findViewById(R.id.lvPlace);
		listLocDetails = new ArrayList<LocationDetailsModel>();
		
		Intent takeIntent = getIntent();
		myChoice = takeIntent.getIntExtra("valChoice", 0);
		
		if (myChoice == 1) {
			if(ConnectionDetector.haveInternet2(LocationDetailsActivity.this))
			{
				new LoadLocDet().execute();
			}
			else
			{
				Utilities.errorMsg(LocationDetailsActivity.this);
			}
		} else {
			Utilities.errorMsgCustom(LocationDetailsActivity.this, "Isi myChoice : " + myChoice, 1);
		}
		
		
		
	}
	
	private class LoadLocDet extends AsyncTask<Void, Void, String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = "nearme_oto.php";
			
			String result = "";
			
			do {
				try {
					result = ConnectionDetector.basic_get(url);
					running = false;
				} catch (Exception e) {
					// TODO: handle exception
					result = "";
					running = false;
					Log.d("otoCare", "LoadLocDet - ERROR "+e.getMessage());
				}
			} while (running);
			
			return result;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			dialog.setVisibility(View.GONE);
			if (result.equals(""))
			{
				Utilities.errorMsg(LocationDetailsActivity.this);
			}
			else
			{
				fetchResponse(result);
			}
		}	
	}
	
	public void fetchResponse(String response){
		try {
			objAllPlace = new JSONObject(response);
			arrPlace = objAllPlace.getJSONArray(TAG_NEARME);
			if (arrPlace != null)
			{
				for(int i = 0; i < arrPlace.length(); i++)
				{
					objPlace = arrPlace.getJSONObject(i);
					Place = new LocationDetailsModel(String.valueOf(i),
							objPlace.getString("tempat"),
							objPlace.getString("alamat"),
							objPlace.getString("tlp"),
							objPlace.getString("website"),
							objPlace.getString("rating"),
							objPlace.getString("jumlah_rating"),
							objPlace.getString("jumlah_reviews"),
							objPlace.getString("isi_reviews"),
							objPlace.getString("gbr_tempat"),
							objPlace.getString("gbr_tempat"),
							Double.valueOf(objPlace.getString("long")),
							Double.valueOf(objPlace.getString("lat")),
							Double.valueOf("1.5"));
					
					listLocDetails.add(Place);
				}
				LocationDetailsAdapter adapterLocDet = new LocationDetailsAdapter(LocationDetailsActivity.this, listLocDetails);
				lvLocDetails.setAdapter(adapterLocDet);
				lvLocDetails.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						final Intent giveIntent = new Intent(LocationDetailsActivity.this, LocationDetailsDirectionActivity.class);
						giveIntent.putExtra("tempat", listLocDetails.get(position).getNamePlace());
						giveIntent.putExtra("latitude", listLocDetails.get(position).getLatitudePlace());
						giveIntent.putExtra("longitude", listLocDetails.get(position).getLongitudePlace());
						startActivityForResult(giveIntent, 0);
						
					}
					
				});
			}
			else
			{
				
			}
		}
		catch (Exception e) {
			Utilities.errorMsgCustom(LocationDetailsActivity.this, e.getMessage(), 1);
		}
	}
}
