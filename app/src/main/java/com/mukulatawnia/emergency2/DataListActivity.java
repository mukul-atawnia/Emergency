package com.mukulatawnia.emergency2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class DataListActivity extends ActionBarActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    Contact_ListDataAdapter contact_listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);

        listView=(ListView)findViewById(R.id.list_view);
        contact_listDataAdapter=new Contact_ListDataAdapter(getApplicationContext(),R.layout.contact_row_layout);
        listView.setAdapter(contact_listDataAdapter);

        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();

        cursor=userDbHelper.getInformation(sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            do{
                String name,mob,email;
                name=cursor.getString(0);
                mob=cursor.getString(1);
                email=cursor.getString(2);
                Contact_DataProvider contact_dataProvider=new Contact_DataProvider(name,mob,email);
                contact_listDataAdapter.add(contact_dataProvider);

            }while (cursor.moveToNext());
        }
    }


}
