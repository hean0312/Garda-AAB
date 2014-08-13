package com.aab.otocare.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aab.otocare.R;
import com.aab.otocare.helper.ImageLoader;
import com.aab.otocare.model.LocationDetailsModel;

public class LocationDetailsAdapter extends BaseAdapter{

	Context locDetailsContext;
	ArrayList<LocationDetailsModel> listLocDetails;
	int count;
	ImageLoader loader;
	
	public LocationDetailsAdapter (Context locDetailsContext, ArrayList<LocationDetailsModel> listLocDetails) {
		this.locDetailsContext = locDetailsContext;
		this.listLocDetails = listLocDetails;
		this.count = listLocDetails.size();
		
		loader = new ImageLoader(locDetailsContext);
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
        TextView txtIDPlace, txtNamePlace, txtAddressPlace, txtPhonePlace, txtWebsitePlace, txtJumRating, txtTotRating, txtJumReview, txtLastReview;
        ImageView imgPicPlace, imgPicMarker;
        RatingBar ratingBarPlace;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View locDetailsView = convertView;
		ViewHolder locDetailsHolder = null;
		if(locDetailsView == null)
		{
			LayoutInflater inflaterLocDetails = (LayoutInflater) locDetailsContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			locDetailsView = inflaterLocDetails.inflate(R.layout.item_location_details, null);
			
			locDetailsHolder = new ViewHolder();
			locDetailsHolder.txtIDPlace = (TextView)locDetailsView.findViewById(R.id.txtIdPlace);
			locDetailsHolder.txtNamePlace = (TextView)locDetailsView.findViewById(R.id.txtNamePlace);
			locDetailsHolder.txtAddressPlace = (TextView)locDetailsView.findViewById(R.id.txtAddressPlace);
			locDetailsHolder.txtPhonePlace = (TextView)locDetailsView.findViewById(R.id.txtPhonePlace);
			locDetailsHolder.txtWebsitePlace = (TextView)locDetailsView.findViewById(R.id.txtWebsitePlace);
			locDetailsHolder.txtJumRating = (TextView)locDetailsView.findViewById(R.id.txtJumRating);
			locDetailsHolder.txtJumReview = (TextView)locDetailsView.findViewById(R.id.txtJumReview);
			locDetailsHolder.txtLastReview = (TextView)locDetailsView.findViewById(R.id.txtLastReview);
			locDetailsHolder.imgPicMarker = (ImageView)locDetailsView.findViewById(R.id.imgPicMarker);
			locDetailsHolder.imgPicPlace = (ImageView)locDetailsView.findViewById(R.id.imgPicPlace);
			locDetailsHolder.ratingBarPlace = (RatingBar)locDetailsView.findViewById(R.id.ratingBarPlace);
			locDetailsView.setTag(locDetailsHolder);
		}
		else
		{
			locDetailsHolder = (ViewHolder)locDetailsView.getTag();
		}
		
		locDetailsHolder.txtIDPlace.setText(listLocDetails.get(position).getIdPlace());
		locDetailsHolder.txtNamePlace.setText(listLocDetails.get(position).getNamePlace());
		locDetailsHolder.txtAddressPlace.setText(listLocDetails.get(position).getAddressPlace());
		locDetailsHolder.txtPhonePlace.setText(listLocDetails.get(position).getPhonePlace());
		locDetailsHolder.txtWebsitePlace.setText(listLocDetails.get(position).getWebsitePlace());
		locDetailsHolder.txtJumRating.setText(listLocDetails.get(position).getJumRating());
		locDetailsHolder.txtJumReview.setText(listLocDetails.get(position).getJumReview() + " reviews");
		locDetailsHolder.txtLastReview.setText(Html.fromHtml("&quot;" + listLocDetails.get(position).getLastReview() + "&quot;"));
		locDetailsHolder.ratingBarPlace.setRating(Float.parseFloat(listLocDetails.get(position).getTotRating()));
		
		if (listLocDetails.get(position).getPicPlace().equals("null") || listLocDetails.get(position).getPicPlace().equals(null) || listLocDetails.get(position).getPicPlace().equals(""))
		{
			
		}
		else
		{
			loader.DisplayImage(listLocDetails.get(position).getPicPlace(), locDetailsHolder.imgPicPlace, 0);
		}
		
		
		return locDetailsView;

	}

}
