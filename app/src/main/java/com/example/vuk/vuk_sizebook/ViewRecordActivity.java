package com.example.vuk.vuk_sizebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewRecordActivity extends AppCompatActivity {

    private TextView nameView, dateView, neckView, bustView, chestView, waistView, hipView, inseamView, commentView;
    private Record viewRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        nameView= (TextView)findViewById(R.id.textViewName);
        dateView = (TextView)findViewById(R.id.textViewDate);
        neckView= (TextView)findViewById(R.id.textViewNeck);
        bustView= (TextView)findViewById(R.id.textViewBust);
        chestView= (TextView)findViewById(R.id.textViewChest);
        waistView= (TextView)findViewById(R.id.textViewWaist);
        hipView= (TextView)findViewById(R.id.textViewHip);
        inseamView= (TextView)findViewById(R.id.textViewInseam);
        commentView= (TextView)findViewById(R.id.textViewComment);

        viewRecord = (Record) getIntent().getSerializableExtra("view");

        //nameView.setText("Name: " + viewRecord.getName() + "");
        nameView.setText(getString(R.string.record_name_view, viewRecord.getName()));
        dateView.setText(getString(R.string.record_date_view, viewRecord.getDate()));

        if(viewRecord.getNeck().equals("")){
            neckView.setText(getString(R.string.record_neck_view1));
        }
        else {
            //neckView.setText("Neck: " + viewRecord.getNeck() + " inches");
            neckView.setText(getString(R.string.record_neck_view, viewRecord.getNeck()));
        }

        if(viewRecord.getBust().equals("")){
            bustView.setText(getString(R.string.record_bust_view1));
        }
        else {
            //bustView.setText("Bust: " + viewRecord.getBust() + "inches");
            bustView.setText(getString(R.string.record_bust_view, viewRecord.getBust()));
        }

        if(viewRecord.getChest().equals("")){
            chestView.setText(getString(R.string.record_chest_view1));
        }
        else {
            //chestView.setText("Chest: " + viewRecord.getChest() + "inches");
            chestView.setText(getString(R.string.record_chest_view, viewRecord.getChest()));
        }

        if(viewRecord.getWaist().equals("")){
            waistView.setText(getString(R.string.record_waist_view1));
        }
        else {
            //waistView.setText("Waist: " + viewRecord.getWaist() + "inches");
            waistView.setText(getString(R.string.record_waist_view, viewRecord.getWaist()));
        }

        if(viewRecord.getHip().equals("")){
            hipView.setText(getString(R.string.record_hip_view1));
        }
        else {
            //hipView.setText("Hip: " + viewRecord.getHip() + "inches");
            hipView.setText(getString(R.string.record_hip_view, viewRecord.getHip()));
        }

        if(viewRecord.getInseam().equals("")){
            hipView.setText(getString(R.string.record_inseam_view1));
        }
        else {
            //inseamView.setText("Inseam: " + viewRecord.getInseam() + "inches");
            inseamView.setText(getString(R.string.record_inseam_view, viewRecord.getInseam()));
        }

        //commentView.setText("Comment: " + viewRecord.getComment() + "");
        inseamView.setText(getString(R.string.record_comment_view, viewRecord.getComment()));

    }
}
