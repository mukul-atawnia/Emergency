package com.mukulatawnia.emergency2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class PoliceAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public PoliceAdapter(Context context, int resource)
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
        TextView places;
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
            row=inflater.inflate(R.layout.police_row_layout,parent,false);
            dataHandler=new DataHandler();
            dataHandler.places=(TextView)row.findViewById(R.id.police_station_place);
            dataHandler.phoneNumber=(TextView)row.findViewById(R.id.police_station_number);
            row.setTag(dataHandler);
        }
        else
        {
            dataHandler=(DataHandler)row.getTag();
        }

        PoliceRow police_rows_layout;
        police_rows_layout=(PoliceRow)this.getItem(position);

        dataHandler.places.setText(police_rows_layout.getPolice_stations_places());
        dataHandler.phoneNumber.setText(police_rows_layout.getNumbers());

        return row;
    }
}
