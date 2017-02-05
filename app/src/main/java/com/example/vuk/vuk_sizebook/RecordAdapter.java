package com.example.vuk.vuk_sizebook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vuk on 1/28/2017.
 */

/** Source from where RecordAdapter class is based from
https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
 **/

/*
    RecordAdapter class is what is used to bridge our data source (Array of records) to be displayed in the
    adapter view (listview located in MainActivity).
    RecordAdapter allows for customization of how the data is displayed inside the listview
 */

public class RecordAdapter extends ArrayAdapter<Record> {

    public RecordAdapter(Context context, ArrayList<Record> records){
        super(context, 0, records);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Record record = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_record, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.nameText);
        TextView tvBust = (TextView) convertView.findViewById(R.id.bustText);
        TextView tvChest = (TextView) convertView.findViewById(R.id.chestText);
        TextView tvWaist = (TextView) convertView.findViewById(R.id.waistText);
        TextView tvInseam = (TextView) convertView.findViewById(R.id.inseamText);

        //if text is empty, then it doesn't display the result in the listview
        tvName.setText(record.getName());

        if(record.getBust().equalsIgnoreCase("")){
            tvBust.setVisibility(View.GONE);
        }
        else {
            tvBust.setText("Bust: " + record.getBust() + " inches");
        }

        if(record.getChest().equalsIgnoreCase("")){
            tvChest.setVisibility(View.GONE);
        }
        else {
            tvChest.setText("Chest: " + record.getChest() + " inches");
        }

        if(record.getWaist().equalsIgnoreCase("")){
            tvWaist.setVisibility(View.GONE);
        }
        else {
            tvWaist.setText("Waist: " + record.getWaist() + " inches");
        }

        if(record.getInseam().equalsIgnoreCase("")){
            tvInseam.setVisibility(View.GONE);
        }
        else {
            tvInseam.setText("Inseam: " + record.getInseam() + " inches");
        }

        return convertView;

    }
}
