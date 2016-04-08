package com.mukulatawnia.emergency2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HospitalsList extends Activity {


    ListView listView;
    String names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivity);
        listView = (ListView) findViewById(R.id.mylist);
        names = getResources().getStringArray(R.array.hospitals);
        ArrayAdapter<String> myarrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(myarrayadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), HospitalAddress.class);
                i.putExtra("Position", position);
                startActivity(i);
            }
        });
    }

}
