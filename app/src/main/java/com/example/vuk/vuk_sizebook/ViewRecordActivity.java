package com.example.vuk.vuk_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewRecordActivity extends AppCompatActivity {

    private TextView nameView;
    private Record viewRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        nameView= (TextView)findViewById(R.id.textViewName);

        viewRecord = (Record) getIntent().getSerializableExtra("view");
        nameView.setText(viewRecord.getName());
    }
}
