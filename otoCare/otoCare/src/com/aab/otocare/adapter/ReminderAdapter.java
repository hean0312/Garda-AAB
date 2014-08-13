package com.aab.otocare.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aab.otocare.R;
import com.aab.otocare.model.ReminderModel;

public class ReminderAdapter extends BaseAdapter {

	Context remindContext;
	ArrayList<ReminderModel> listReminder;
	int count;

	public ReminderAdapter (Context remindContext, ArrayList<ReminderModel> listReminder) {
		this.remindContext = remindContext;
		this.listReminder = listReminder;
		this.count = listReminder.size();
		
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View remindView = convertView;
		ViewHolder remindHolder = null;
		
		if(remindView == null)
		{
			LayoutInflater inflaterRemind = (LayoutInflater) remindContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			remindView = inflaterRemind.inflate(R.layout.item_reminder, null);
			remindHolder = new ViewHolder();
			remindHolder.txtIdRemind = (TextView)remindView.findViewById(R.id.txtIdRemind);
			remindHolder.txtNameRemind = (TextView)remindView.findViewById(R.id.txtNameRemind);
			remindHolder.txtDescRemind = (TextView)remindView.findViewById(R.id.txtDescRemind);
			remindView.setTag(remindHolder);
		}
		else
		{
			remindHolder = (ViewHolder)remindView.getTag();
		}
		
		remindHolder.txtIdRemind.setText(listReminder.get(position).getIdRemind());
		remindHolder.txtNameRemind.setText(listReminder.get(position).getNameRemind());
		remindHolder.txtDescRemind.setText(listReminder.get(position).getDescRemind());
		
		return remindView;
	}
	
	static class ViewHolder{
		TextView txtIdRemind, txtNameRemind, txtDescRemind;
	}

}
