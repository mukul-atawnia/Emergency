package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class Police extends Activity {

    ListView listView;
    String station_names[];
    String phone_numbers[];
    PoliceAdapter policeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_stations_list);
        listView=(ListView)findViewById(R.id.policestation_list);
        station_names=getResources().getStringArray(R.array.police_stations);
        phone_numbers=getResources().getStringArray(R.array.police_numbers);

        int i=0;
        policeAdapter=new PoliceAdapter(getApplicationContext(),R.layout.police_row_layout);
        listView.setAdapter(policeAdapter);
        for(String places: station_names)
        {
            PoliceRow policeRowsLayout=new PoliceRow(places,phone_numbers[i]);
            policeAdapter.add(policeRowsLayout);
            i++;
        }

    }
}
