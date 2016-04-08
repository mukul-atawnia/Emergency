package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HospitalAddress extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent=getIntent();
        textView=(TextView)findViewById(R.id.address_of_hospital);
        int temp=intent.getIntExtra("Position",0);

        String add[]=getResources().getStringArray(R.array.addresses);
        String addr;
        addr=add[temp];
        textView.setText(addr);
    }
}
