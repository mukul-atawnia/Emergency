package com.mukulatawnia.emergency2;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Maps gps;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void policeFunction(View view)
    {
        Intent intent=new Intent(this,Police.class);
        startActivity(intent);

    }

    public void hospitalsFunction(View view)
    {
        Intent intent=new Intent(this,HospitalsList.class);
        startActivity(intent);
    }

    public void sqliteDatabase(View view)
    {
        Intent intent=new Intent(this,SQLite_Database.class);
        startActivity(intent);
    }

    public void womenFunction(View view)
    {
        Intent intent=new Intent(this,Women.class);
        startActivity(intent);
    }

    public void mapFunction(View view)
    {
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public void gpsFunction(View view)
    {

        gps=new Maps(MainActivity.this);

        if(gps.canGetLocation())
        {
            double latitude=gps.getLatitude();
            double longitude=gps.getLongitude();

            Toast.makeText(getApplicationContext(), "Your Location is: \n Lat: " + latitude + "\n Lon: " + longitude, Toast.LENGTH_LONG).show();

        }
        else
        {
            gps.showSettingsAlert();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
