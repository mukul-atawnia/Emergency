package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class Distress extends Activity {

    String distress_organization[],distress_numbers[];
    Women_Adapter women_adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_list);

        listView=(ListView)findViewById(R.id.women_list);
        distress_organization=getResources().getStringArray(R.array.distress);
        distress_numbers=getResources().getStringArray(R.array.distress_phone);

        int i=0;

        women_adapter=new Women_Adapter(getApplicationContext(),R.layout.women_row);
        listView.setAdapter(women_adapter);

        for(String organizations: distress_organization)
        {

            Women_Row_Layout women_row_layout=new Women_Row_Layout(organizations,distress_numbers[i]);
            women_adapter.add(women_row_layout);
            i++;
        }
    }
}
