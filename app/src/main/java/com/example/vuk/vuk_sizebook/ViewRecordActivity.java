package com.example.vuk.vuk_sizebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/*
    ViewRecordActivity displays the chosen records information, regardless if they are empty or given.
    Does not return anything to MainActivity
 */

public class ViewRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        TextView nameView = (TextView) findViewById(R.id.textViewName);
        TextView dateView = (TextView) findViewById(R.id.textViewDate);
        TextView neckView = (TextView) findViewById(R.id.textViewNeck);
        TextView bustView = (TextView) findViewById(R.id.textViewBust);
        TextView chestView = (TextView) findViewById(R.id.textViewChest);
        TextView waistView = (TextView) findViewById(R.id.textViewWaist);
        TextView hipView = (TextView) findViewById(R.id.textViewHip);
        TextView inseamView = (TextView) findViewById(R.id.textViewInseam);
        TextView commentView = (TextView) findViewById(R.id.textViewComment);

        Record viewRecord = (Record) getIntent().getSerializableExtra("view");

        nameView.setText(getString(R.string.record_name_view, viewRecord.getName()));
        dateView.setText(getString(R.string.record_date_view, viewRecord.getDate()));
        commentView.setText(getString(R.string.record_comment_view, viewRecord.getComment()));

        if(viewRecord.getNeck().equals("")){
            neckView.setText(getString(R.string.record_neck_view1));
        }
        else {
            neckView.setText(getString(R.string.record_neck_view, viewRecord.getNeck()));
        }

        if(viewRecord.getBust().equals("")){
            bustView.setText(getString(R.string.record_bust_view1));
        }
        else {
            bustView.setText(getString(R.string.record_bust_view, viewRecord.getBust()));
        }

        if(viewRecord.getChest().equals("")){
            chestView.setText(getString(R.string.record_chest_view1));
        }
        else {
            chestView.setText(getString(R.string.record_chest_view, viewRecord.getChest()));
        }

        if(viewRecord.getWaist().equals("")){
            waistView.setText(getString(R.string.record_waist_view1));
        }
        else {
            waistView.setText(getString(R.string.record_waist_view, viewRecord.getWaist()));
        }

        if(viewRecord.getHip().equals("")){
            hipView.setText(getString(R.string.record_hip_view1));
        }
        else {
            hipView.setText(getString(R.string.record_hip_view, viewRecord.getHip()));
        }

        if(viewRecord.getInseam().equals("")){
            inseamView.setText(getString(R.string.record_inseam_view1));
        }
        else {
            inseamView.setText(getString(R.string.record_inseam_view, viewRecord.getInseam()));
        }

    }
}
