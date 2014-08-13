package com.aab.medicare.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aab.medicare.R;
import com.aab.medicare.model.KnowledgeModel;

public class KnowledgeAdapter extends BaseAdapter{

	Context knowContext;
	ArrayList<KnowledgeModel> listKnowledge;
	int count;
	
	public KnowledgeAdapter(Context knowContext, ArrayList<KnowledgeModel> listKnowledge) {
		this.knowContext = knowContext;
		this.listKnowledge = listKnowledge;
		this.count = listKnowledge.size();
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
		ImageView imgKnow;
		TextView txtIdKnow, txtNameKnow;
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View knowView = convertView;
		ViewHolder knowHolder = null;
		
		if(knowView == null)
		{
			LayoutInflater inflaterKnow = (LayoutInflater) knowContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			knowView = inflaterKnow.inflate(R.layout.item_knowledge, null);
			
			knowHolder = new ViewHolder();
			knowHolder.txtIdKnow = (TextView)knowView.findViewById(R.id.txtIdKnow);
			knowHolder.imgKnow = (ImageView)knowView.findViewById(R.id.imgKnow);
			knowHolder.txtNameKnow = (TextView)knowView.findViewById(R.id.txtNameKnow);
			knowView.setTag(knowHolder);
		}
		else
		{
			knowHolder = (ViewHolder) knowView.getTag();
		}
		
		knowHolder.txtNameKnow.setText(listKnowledge.get(position).getNameKnow());
		
		return knowView;
	}

}
