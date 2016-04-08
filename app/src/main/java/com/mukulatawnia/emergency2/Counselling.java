package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by ramesh kumar on 11-10-2015.
 */
public class Counselling extends Activity {
    String counselling_organization[],counselling_numbers[];
    Women_Adapter women_adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_list);

        listView=(ListView)findViewById(R.id.women_list);
        counselling_organization=getResources().getStringArray(R.array.counselling);
        counselling_numbers=getResources().getStringArray(R.array.counselling_phone);

        int i=0;
        women_adapter=new Women_Adapter(getApplicationContext(),R.layout.women_row);
        listView.setAdapter(women_adapter);

        for(String organizations: counselling_organization)
        {

            Women_Row_Layout women_row_layout=new Women_Row_Layout(organizations,counselling_numbers[i]);
            women_adapter.add(women_row_layout);
            i++;
        }
    }
}
