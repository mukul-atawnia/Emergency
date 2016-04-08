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
public class Women_Adapter extends ArrayAdapter{

    List list=new ArrayList();

    public Women_Adapter(Context context, int resource)
    {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {

        return this.list.size();
    }

    static class DataHandler
    {
        TextView org;
        TextView phoneNumber;
    }

    @Override
    public Object getItem(int position) {

        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        DataHandler dataHandler;
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.women_row,parent,false);
            dataHandler=new DataHandler();
            dataHandler.org=(TextView)row.findViewById(R.id.name_of_organisation);
            dataHandler.phoneNumber=(TextView)row.findViewById(R.id.phone_number_of_organization);
            row.setTag(dataHandler);
        }
        else
        {
            dataHandler=(DataHandler)row.getTag();
        }

        Women_Row_Layout women_row_layoutt;
        women_row_layoutt=(Women_Row_Layout)this.getItem(position);

        dataHandler.org.setText(women_row_layoutt.getOrganizations());
        dataHandler.phoneNumber.setText(women_row_layoutt.getPhone_numbers());

        return row;
    }
}
