package com.aab.otocare.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aab.otocare.R;
import com.aab.otocare.model.LocationModel;

public class LocationAdapter extends BaseAdapter{

	Context locationContext;
	ArrayList<LocationModel> listLocation;
	int count;
	
	public LocationAdapter(Context locationContext, ArrayList<LocationModel> listLocation) {
		this.locationContext = locationContext;
		this.listLocation = listLocation;
		this.count = listLocation.size();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	static class ViewHolder{
		ImageView imgCatLoc;
		TextView txtIdCatLoc, txtNameCatLoc;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View locationView = convertView;
		ViewHolder locationHolder = null;
		
		if(locationView == null)
		{
			LayoutInflater inflaterLocation = (LayoutInflater) locationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			locationView = inflaterLocation.inflate(R.layout.item_location, null);
			
			locationHolder = new ViewHolder();
			locationHolder.txtIdCatLoc = (TextView) locationView.findViewById(R.id.txtIdCatLoc);
			locationHolder.imgCatLoc = (ImageView) locationView.findViewById(R.id.imgCatLoc);
			locationHolder.txtNameCatLoc = (TextView) locationView.findViewById(R.id.txtNameCatLoc);
			locationView.setTag(locationHolder);
		}
		else
		{
			locationHolder = (ViewHolder)locationView.getTag();
		}
		
		locationHolder.txtNameCatLoc.setText(listLocation.get(position).getNameLoc());
		return locationView;
	}

}
