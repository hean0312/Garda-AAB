package com.aab.otocare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationDetailsDirectionActivity extends Activity {

	// Google Map
    private GoogleMap googleMap;
    Double latitude, longitude;
    String namePlace;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_details_direction);
		
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_location_details_direction);
		
		Intent takeIntent = getIntent();
		namePlace = takeIntent.getStringExtra("tempat");
		latitude = takeIntent.getDoubleExtra("latitude", 0);
		longitude = takeIntent.getDoubleExtra("longitude", 0);
		
		try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	/**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            else
            {
            	googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(namePlace).snippet(""));
            	googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude),30));
            	googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
            }
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
    
}
