package com.example.vuk.vuk_sizebook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;

public class EditRecordActivity extends AppCompatActivity {

    private Button completeButton;

    private EditText nameEdit, inseamEdit, bustEdit, waistEdit, chestEdit, neckEdit, hipEdit, commentEdit, dateEdit;

    private Record editRecord, newRecord;

    private int positionRecord, error;

    private RecordList editRecordList ;

    private String regexStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        completeButton = (Button)findViewById(R.id.editSubmitButton);

        regexStr =  "^([0-9]+(\\.[0-9]{1})?)?$";

        final EditText[] editTextArray = new EditText[]{
                nameEdit = (EditText) findViewById(R.id.editNameText),
                dateEdit = (EditText) findViewById(R.id.editDateText),
                neckEdit = (EditText) findViewById(R.id.editNeckText),
                inseamEdit = (EditText) findViewById(R.id.editInseamText),
                bustEdit = (EditText) findViewById(R.id.editBustText),
                waistEdit = (EditText) findViewById(R.id.editWaistText),
                chestEdit = (EditText) findViewById(R.id.editChestText),
                hipEdit = (EditText) findViewById(R.id.editHipText),
                commentEdit = (EditText) findViewById(R.id.editCommentText),
        };

        editRecord = (Record) getIntent().getSerializableExtra("editRecord");
        positionRecord = getIntent().getIntExtra("editPosition", 0);
        editRecordList = (RecordList) getIntent().getSerializableExtra("editRecordList");


        createEditSetup(editRecord);

        dateEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(EditRecordActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        dateEdit.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (nameEdit.getText().toString().equals("")) {
//                    nameEdit.setError("Name is a mandatory field");
//                }

                //else if(!nameEdit.getText().toString().equals("")){
                if(errorCheck(editTextArray)){
                    newRecord = new Record();
                    newRecord.setName(nameEdit.getText().toString());
                    newRecord.setDate(dateEdit.getText().toString());
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
        dateEdit.setText(editRecord.getDate());
        neckEdit.setText(editRecord.getNeck());
        inseamEdit.setText(editRecord.getInseam());
        bustEdit.setText(editRecord.getBust());
        waistEdit.setText(editRecord.getWaist());
        chestEdit.setText(editRecord.getChest());
        hipEdit.setText(editRecord.getHip());
        commentEdit.setText(editRecord.getComment());
    }

    public Boolean errorCheck(EditText[] editTextArray){

        error = 0;
        for (int i = 0; i < editTextArray.length; i++){
            if(i == 0 ){
                if(editTextArray[i].getText().toString().equals("")){
                    editTextArray[i].setError("Name is a mandatory field");
                    error = 1;
                }
            }

            else if(i == 8 | i == 1){

            }
            else if(!editTextArray[i].getText().toString().trim().matches(regexStr)){
                editTextArray[i].setError("Measurement must be a whole number or up 1 decimal place");
                error = 1;
            }
        }

        if (error == 0){
            return true;
        }

        else{
            return false;
        }
    }

}
//dateEdit.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        DatePickerDialog.onDateSetListener dpd = new DatePickerDialog.OnDateSetListener(){
//
//        }
//        }
//        });
//
//        dateEdit.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        Calendar currentDate = Calendar.getInstance();
//        int year = currentDate.get(Calendar.YEAR);
//        int month = currentDate.get(Calendar.MONTH);
//        int day = currentDate.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePicker
//        }
//        });