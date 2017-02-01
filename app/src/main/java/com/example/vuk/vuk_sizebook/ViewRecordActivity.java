package com.example.vuk.vuk_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewRecordActivity extends AppCompatActivity {

    private TextView nameView, dateView, neckView, bustView, chestView, waistView, hipView, inseamView, commentView;
    private Record viewRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        nameView= (TextView)findViewById(R.id.textViewName);
        neckView= (TextView)findViewById(R.id.textViewNeck);
        bustView= (TextView)findViewById(R.id.textViewBust);
        chestView= (TextView)findViewById(R.id.textViewChest);
        waistView= (TextView)findViewById(R.id.textViewWaist);
        hipView= (TextView)findViewById(R.id.textViewHip);
        inseamView= (TextView)findViewById(R.id.textViewInseam);
        commentView= (TextView)findViewById(R.id.textViewComment);

        viewRecord = (Record) getIntent().getSerializableExtra("view");

        nameView.setText("Name: " + viewRecord.getName() + "");
        neckView.setText("Neck: " + viewRecord.getNeck() + " inches");
        bustView.setText("Bust: " + viewRecord.getBust() + "inches");
        chestView.setText("Chest: " + viewRecord.getChest() + "inches");
        waistView.setText("Waist: " + viewRecord.getWaist() + "inches");
        hipView.setText("Hip: " + viewRecord.getHip() + "inches");
        inseamView.setText("Inseam: " + viewRecord.getInseam() + "inches");
        commentView.setText("Comment: " + viewRecord.getComment() + "");

    }
}
