package com.mukulatawnia.emergency2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class SQLite_Database extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite__database);
    }

    public void addNewContact(View view)
    {
        Intent intent=new Intent(this,NewContactActivity.class);
        startActivity(intent);
    }

    public void viewContact(View view)
    {
        Intent intent=new Intent(this,DataListActivity.class);
        startActivity(intent);

    }

    public void searchContact(View view)
    {
        Intent intent=new Intent(this,Contact_Search.class);
        startActivity(intent);
    }

    public void updateContact(View view)
    {
        Intent intent=new Intent(this,Contact_Update.class);
        startActivity(intent);
    }


}
