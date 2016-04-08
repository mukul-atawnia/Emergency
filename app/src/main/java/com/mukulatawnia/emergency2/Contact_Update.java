package com.mukulatawnia.emergency2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Contact_Update extends ActionBarActivity {

    TextView text_update;
    EditText New_Name,New_Mob,New_Email,Search_Name;
    Button UpdateButton;
    String SearchName;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__update);
        text_update=(TextView)findViewById(R.id.text_update);
        Search_Name=(EditText)findViewById(R.id.search_name);
        New_Name=(EditText)findViewById(R.id.update_name);
        New_Mob=(EditText)findViewById(R.id.update_mob);
        New_Email=(EditText)findViewById(R.id.update_email);
        UpdateButton=(Button)findViewById(R.id.update_contact);
        text_update.setVisibility(View.GONE);
        New_Name.setVisibility(View.GONE);
        New_Mob.setVisibility(View.GONE);
        New_Email.setVisibility(View.GONE);
        UpdateButton.setVisibility(View.GONE);

    }

    public void searchContact(View view)
    {
        SearchName=Search_Name.getText().toString();
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getReadableDatabase();
        Cursor cursor=userDbHelper.getContact(SearchName,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String NewMobile=cursor.getString(0);
            String NewEmail=cursor.getString(1);
            String NewName=SearchName;
            New_Mob.setText(NewMobile);
            New_Email.setText(NewEmail);
            New_Name.setText(NewName);
            text_update.setVisibility(View.VISIBLE);
            New_Name.setVisibility(View.VISIBLE);
            New_Mob.setVisibility(View.VISIBLE);
            New_Email.setVisibility(View.VISIBLE);
            UpdateButton.setVisibility(View.VISIBLE);
        }
    }

    public void updateInformation(View view)
    {
        userDbHelper=new UserDbHelper(getApplicationContext());
        sqLiteDatabase=userDbHelper.getWritableDatabase();
        String name,email,mobile;
        name=New_Name.getText().toString();
        email=New_Email.getText().toString();
        mobile=New_Mob.getText().toString();
        int a=userDbHelper.updateInformation(SearchName,name,mobile,email,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),a+" contact updated",Toast.LENGTH_LONG).show();
        finish();
    }


}
