package com.aab.medicare;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.aab.medicare.adapter.ReminderAdapter;
import com.aab.medicare.helper.Utilities;
import com.aab.medicare.model.ReminderModel;

public class ReminderActivity extends Activity {

	private ListView lvReminder;
	private ArrayList<ReminderModel> listReminder;
	private ReminderModel remindMod;
	String idRemindAc, nameRemindAc, descRemindAc;
	
	String[] nameListReminder={"Cataflam","Pregancy Control","Ovulation Control"};
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * remember : ada bagian history, layout dibuat terpisah, 
	 * tapi script lebih baik gabung aja 
	 * jadi satu di script ReminderActivity.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder);
		
		lvReminder = (ListView)findViewById(R.id.lvReminder);
		listReminder = new ArrayList<ReminderModel>();
		for (int i = 0; i < 3; i++)
		{
			idRemindAc = "" + i;
			nameRemindAc = "Name Reminder " + i;
			descRemindAc = "Desc Reminder " + i;
			remindMod = new ReminderModel(idRemindAc, nameListReminder[i], descRemindAc);
			listReminder.add(remindMod);
			
		}
		
		if(listReminder.isEmpty())
		{
			Toast.makeText(ReminderActivity.this, "List Reminder is Empty", Toast.LENGTH_LONG).show();
		}
		else
		{
			ReminderAdapter adapterRemind = new ReminderAdapter(ReminderActivity.this, listReminder);
			lvReminder.setAdapter(adapterRemind);
			
			lvReminder.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					
					String myIdRemind = listReminder.get(position).getIdRemind();
					Log.d("Reminder", "ID : " + myIdRemind);
					Toast.makeText(ReminderActivity.this, "ID :" + myIdRemind, Toast.LENGTH_LONG).show();
					
					Utilities.giveIntent = new Intent(getApplicationContext(), ReminderDetailsActivity.class);
					Utilities.giveIntent.putExtra("id_reminder", myIdRemind);
					startActivityForResult(Utilities.giveIntent, 0);
					
				}
				
			});
		}
	}
	
	
	/*
	 * public void onClickReminder (View v)
	 
	{
		int id = v.getId();
		if (id == R.id.btnNewReminder) {
			Utilities.giveIntent = new Intent(getApplicationContext(), ReminderNewListActivity.class);
			Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(Utilities.giveIntent);
		} else if (id == R.id.ll_reminder_medical_control) {
			Utilities.giveIntent = new Intent(getApplicationContext(), MedicalControlActivity.class);
			Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(Utilities.giveIntent);
		} else if (id == R.id.ll_reminder_ovulation_period) {
			Utilities.giveIntent = new Intent(getApplicationContext(), OvulationPeriodActivity.class);
			Utilities.giveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(Utilities.giveIntent);
		}
	}
	*/
}