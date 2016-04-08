package com.mukulatawnia.emergency2;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewContactActivity extends Activity {

    EditText ContactName,ContactMobile,ContactEmail;
    Context context;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcontact);
        ContactName=(EditText)findViewById(R.id.name);
        ContactMobile=(EditText)findViewById(R.id.phone);
        ContactEmail=(EditText)findViewById(R.id.email);
    }

    public void newContact(View view)
    {
        context=this;
        String name=ContactName.getText().toString();
        String mob=ContactMobile.getText().toString();
        String email=ContactEmail.getText().toString();
        userDbHelper=new UserDbHelper(context);
        sqLiteDatabase=userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(name,mob,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"DATA SAVED",Toast.LENGTH_LONG).show();
        userDbHelper.close();
    }
}
