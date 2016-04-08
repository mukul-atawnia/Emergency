package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by ramesh kumar on 11-10-2015.
 */
public class Shelter extends Activity {

    String shelter_organization[],shelter_numbers[];
    Women_Adapter women_adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_list);

        listView=(ListView)findViewById(R.id.women_list);
        shelter_organization=getResources().getStringArray(R.array.shelter);
        shelter_numbers=getResources().getStringArray(R.array.shelter_phone);

        int i=0;
        women_adapter=new Women_Adapter(getApplicationContext(),R.layout.women_row);
        listView.setAdapter(women_adapter);

        for(String organizations: shelter_organization)
        {

            Women_Row_Layout women_row_layout=new Women_Row_Layout(organizations,shelter_numbers[i]);
            women_adapter.add(women_row_layout);
            i++;
        }
    }
}
