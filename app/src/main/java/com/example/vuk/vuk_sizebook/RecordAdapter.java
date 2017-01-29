package com.example.vuk.vuk_sizebook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Vuk on 1/28/2017.
 */

/** Source from where RecordAdapter class is based from
https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
 **/

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

        tvName.setText(record.getName());
        tvBust.setText(record.getBust());

        return convertView;

    }
}
