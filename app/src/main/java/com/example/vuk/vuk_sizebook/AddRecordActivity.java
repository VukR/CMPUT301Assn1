package com.example.vuk.vuk_sizebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import java.io.Serializable;

public class AddRecordActivity extends AppCompatActivity {

    private Button completeButton;

    private EditText nameEdit, dateEdit, neckEdit, inseamEdit,bustEdit, waistEdit, commentEdit, chestEdit, hipEdit;

    private Record newRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        completeButton = (Button)findViewById(R.id.completeRecordButton);
        nameEdit = (EditText)findViewById(R.id.addNameText);
//        dateEdit = (EditText) findViewById(R.id.addDateText);
//        neckEdit = (EditText) findViewById(R.id.addNeckText);
        inseamEdit = (EditText) findViewById(R.id.addInseamText);
        bustEdit = (EditText) findViewById(R.id.addBustText);
        waistEdit = (EditText) findViewById(R.id.addWaistText);
        chestEdit = (EditText) findViewById(R.id.addChestText);
//        hipEdit = (EditText) findViewById(R.id.addHipText);
//        commentEdit = (EditText) findViewById(R.id.addCommentText);

        completeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (nameEdit.getText().toString().equals("")) {
                    Log.d("test", "name is empty");
                    nameEdit.setError("Name is a mandatory field");
                }
                else if(!nameEdit.getText().toString().equals("")){
                    newRecord = new Record();
                    newRecord.setName(nameEdit.getText().toString());
                    //newRecord.setDate(dateEdit.getText().toString());
                    newRecord.setBust(bustEdit.getText().toString());
                    newRecord.setChest(chestEdit.getText().toString());
                    newRecord.setWaist(waistEdit.getText().toString());
                    newRecord.setInseam(inseamEdit.getText().toString());
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result", newRecord);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }

            }
        });

    }


}
