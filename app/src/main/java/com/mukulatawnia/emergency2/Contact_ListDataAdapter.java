package com.mukulatawnia.emergency2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramesh kumar on 11-10-2015.
 */
public class Contact_ListDataAdapter extends ArrayAdapter {

    List list=new ArrayList();

    public Contact_ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }


    static  class LayoutHandler
    {

        TextView name,mob,email;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {

            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.contact_row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.name=(TextView)row.findViewById(R.id.text_user_name);
            layoutHandler.mob=(TextView)row.findViewById(R.id.text_user_mob);
            layoutHandler.email=(TextView)row.findViewById(R.id.text_user_email);
            row.setTag(layoutHandler);


        }
        else
        {
            layoutHandler=(LayoutHandler)row.getTag();

        }

        Contact_DataProvider contact_dataProvider=(Contact_DataProvider)this.getItem(position);

        layoutHandler.email.setText(contact_dataProvider.getEmail());
        layoutHandler.mob.setText(contact_dataProvider.getMob());
        layoutHandler.name.setText(contact_dataProvider.getName());

        return row;
    }
}
