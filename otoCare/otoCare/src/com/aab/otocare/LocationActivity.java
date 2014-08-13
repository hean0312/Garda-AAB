package com.aab.otocare;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aab.otocare.adapter.LocationAdapter;
import com.aab.otocare.model.LocationModel;

public class LocationActivity extends Activity {

	private ListView lvLocation;
	private ArrayList<LocationModel> listLocation;
	private LocationModel locMod;
	String idLocAc, urlImgLocAc, nameLocAc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_location);
		
		 lvLocation = (ListView)findViewById(R.id.lvLocation);
	        listLocation = new ArrayList<LocationModel>();
	        
	        for (int i = 0; i < 3; i++)
			{
				idLocAc = "" + i;
				nameLocAc = "Name loc " + i;
				urlImgLocAc = "Img loc " + i;
				locMod = new LocationModel(idLocAc, urlImgLocAc, nameLocAc);
				listLocation.add(locMod);
			}
	        
	        if(listLocation.isEmpty())
	        {
	        	Toast.makeText(LocationActivity.this, "List Location is Empty", Toast.LENGTH_LONG).show();
	        }
	        else
	        {
	        	LocationAdapter adapterloc = new LocationAdapter(LocationActivity.this, listLocation);
	        	lvLocation.setAdapter(adapterloc);
	        	lvLocation.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						String myNameLoc = listLocation.get(position).getNameLoc();
						Log.d("Location", "Name : " + myNameLoc);
						Toast.makeText(LocationActivity.this, "Name :" + myNameLoc, Toast.LENGTH_LONG).show();
						
						Intent giveIntent = new Intent(LocationActivity.this, LocationDetailsActivity.class);
						giveIntent.putExtra("valChoice", 1);
						startActivityForResult(giveIntent, 0);
					}
	        		
				});
	        	
	        }
	        
	        /*
	         * List View End
	         */
	}
}
