package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Women extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.women_layout);
    }

    public void distressFunction(View view)
    {

        Intent intent=new Intent(this,Distress.class);
        startActivity(intent);
    }

    public void counsellingFunction(View view)
    {


        Intent intent=new Intent(this,Counselling.class);
        startActivity(intent);
    }

    public void shelterFunction(View view)
    {

        Intent intent=new Intent(this,Shelter.class);
        startActivity(intent);

    }

    public void legalFunction(View view)
    {

        Intent intent=new Intent(this,Legal_Aid.class);
        startActivity(intent);

    }
}
