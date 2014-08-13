package com.aab.otocare;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aab.otocare.adapter.KnowledgeAdapter;
import com.aab.otocare.adapter.ViewPagerAdapter;
import com.aab.otocare.model.KnowledgeModel;

public class KnowledgeActivity extends Activity {

	ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;
    
    private ListView lvKnowledge;
	private ArrayList<KnowledgeModel> listKnowledge;
	private KnowledgeModel knowMod;
	String idKnowAc, urlImgKnowAc, nameKnowAc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_knowledge);
		TextView txtTitle;
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(R.string.title_activity_knowledge);
		
		/*
		 * View Pager Start
		 */
		viewPager = (ViewPager) findViewById(R.id.pager);
		
		 // Generate sample data
        rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
 
        country = new String[] { "Slide 1", "Slide 2", "Slide 3",
                "Slide 4", "Slide 5", "Slide 6", "Slide 7", "Slide 8",
                "Slide 9", "Slide 10" };
 
        population = new String[] { "100", "200",
                "300", "400", "500", "600",
                "700", "800", "900", "1000" };
 
        flag = new int[] { R.drawable.slide1, R.drawable.slide2,
                R.drawable.slide3, R.drawable.slide4,
                R.drawable.slide5, R.drawable.slide6, R.drawable.slide7,
                R.drawable.slide1, R.drawable.slide2, R.drawable.slide3 };
 
        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(KnowledgeActivity.this, rank, country, population, flag);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
        /*
         * View Pager End
         */
        
        /*
         * List View Start
         */
        
        lvKnowledge = (ListView)findViewById(R.id.lvKnowledge);
        listKnowledge = new ArrayList<KnowledgeModel>();
        
        for (int i = 0; i < 3; i++)
		{
			idKnowAc = "" + i;
			nameKnowAc = "Name Know " + i;
			urlImgKnowAc = "Img Know " + i;
			knowMod = new KnowledgeModel(idKnowAc, urlImgKnowAc, nameKnowAc);
			listKnowledge.add(knowMod);
		}
        
        if(listKnowledge.isEmpty())
        {
        	Toast.makeText(KnowledgeActivity.this, "List Knowledge is Empty", Toast.LENGTH_LONG).show();
        }
        else
        {
        	KnowledgeAdapter adapterKnow = new KnowledgeAdapter(KnowledgeActivity.this, listKnowledge);
        	lvKnowledge.setAdapter(adapterKnow);
        	lvKnowledge.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					String myIdKnow = listKnowledge.get(position).getNameKnow();
					Log.d("Knowledge", "ID : " + myIdKnow);
					Toast.makeText(KnowledgeActivity.this, "ID :" + myIdKnow, Toast.LENGTH_LONG).show();
				}
        		
			});
        	
        }
        
        /*
         * List View End
         */
	}
}
