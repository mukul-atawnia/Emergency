package com.mukulatawnia.emergency2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Contact_Search extends ActionBarActivity {

    EditText Search_Name;
    TextView Display_Email,Display_Mob;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__search);
        Search_Name=(EditText)findViewById(R.id.search_name);
        Display_Email=(TextView)findViewById(R.id.display_email);
        Display_Mob=(TextView)findViewById(R.id.display_mob);
        Display_Email.setVisibility(View.GONE);
        Display_Mob.setVisibility(View.GONE);

    }


    public  void searchContact(View view)
    {

        search_name=Search_Name.getText().toString();
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        Cursor cursor=userDbHelper.getContact(search_name,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String MOBILE=cursor.getString(0);
            String EMAIL=cursor.getString(1);
            Display_Mob.setText(MOBILE);
            Display_Email.setText(EMAIL);
            Display_Email.setVisibility(View.VISIBLE);
            Display_Mob.setVisibility(View.VISIBLE);
        }
    }

    public void deleteContact(View view)
    {

        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact Deleted",Toast.LENGTH_LONG).show();

    }


}
