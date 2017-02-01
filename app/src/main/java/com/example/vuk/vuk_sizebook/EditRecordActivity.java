package com.example.vuk.vuk_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class EditRecordActivity extends AppCompatActivity {

    private Button completeButton;

    private EditText nameEdit, inseamEdit, bustEdit, waistEdit, chestEdit, neckEdit, hipEdit, commentEdit;
            //dateEdit;

    private Record editRecord, newRecord;

    private int positionRecord;

    private RecordList editRecordList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        completeButton = (Button)findViewById(R.id.editSubmitButton);
        nameEdit = (EditText)findViewById(R.id.editNameText);
        //dateEdit = (EditText) findViewById(R.id.addDateText);
        neckEdit = (EditText)findViewById(R.id.editNeckText);
        inseamEdit = (EditText) findViewById(R.id.editInseamText);
        bustEdit = (EditText) findViewById(R.id.editBustText);
        waistEdit = (EditText) findViewById(R.id.editWaistText);
        chestEdit = (EditText) findViewById(R.id.editChestText);
        hipEdit = (EditText) findViewById(R.id.editHipText);
        commentEdit = (EditText) findViewById(R.id.editCommentText);

        editRecord = (Record) getIntent().getSerializableExtra("editRecord");
        positionRecord = getIntent().getIntExtra("editPosition", 0);
        editRecordList = (RecordList) getIntent().getSerializableExtra("editRecordList");


        createEditSetup(editRecord);

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEdit.getText().toString().equals("")) {
                    nameEdit.setError("Name is a mandatory field");
                }

                else if(!nameEdit.getText().toString().equals("")){
                    newRecord = new Record();
                    newRecord.setName(nameEdit.getText().toString());
                    //newRecord.setDate(dateEdit.getText().toString());
                    newRecord.setNeck(neckEdit.getText().toString());
                    newRecord.setBust(bustEdit.getText().toString());
                    newRecord.setChest(chestEdit.getText().toString());
                    newRecord.setWaist(waistEdit.getText().toString());
                    newRecord.setHip(hipEdit.getText().toString());
                    newRecord.setInseam(inseamEdit.getText().toString());
                    newRecord.setComment(commentEdit.getText().toString());

                    editRecordList.getRecordList().set(positionRecord, newRecord);
                    Intent returnIntent = new Intent();
                    //returnIntent.putExtra("Edit Result", newRecord);
                    returnIntent.putExtra("Edit Result", editRecordList);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
            }
        });

    }

    public void createEditSetup(Record editRecord){
        nameEdit.setText(editRecord.getName());
        //dateEdit.setText(editRecord.getDate());
        neckEdit.setText(editRecord.getNeck());
        inseamEdit.setText(editRecord.getInseam());
        bustEdit.setText(editRecord.getBust());
        waistEdit.setText(editRecord.getWaist());
        chestEdit.setText(editRecord.getChest());
        hipEdit.setText(editRecord.getHip());
        commentEdit.setText(editRecord.getComment());
    }

}
