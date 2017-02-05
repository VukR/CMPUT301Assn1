package com.example.vuk.vuk_sizebook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**http://stackoverflow.com/questions/308122/simple-regular-expression-for-a-decimal-with-a-precision-of-2
 * How to make the regex
 */

/*
    AddRecordActivity is screen that appears when user wants to create a new Record
    AddRecordActivity returns newly created Records to MainActivity through the use of intents.
    AddRecordActivity error checks user input to make sure the name field is always included and that
    numbers are only decimals to 1 decimal place.

 */

public class AddRecordActivity extends AppCompatActivity {

    private EditText nameEdit, dateEdit, neckEdit, inseamEdit, bustEdit, waistEdit, commentEdit, chestEdit, hipEdit;
    private Record newRecord;
    private String regexStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        //regexStr =  "^([0-9]+(\\.[0-9]{1})?)?$";
        //correct decimal input format
        regexStr =  "^(\\d*\\.\\d{1})?$";

        Button completeButton = (Button) findViewById(R.id.completeRecordButton);

        final EditText[] editTextArray = new EditText[]{
            nameEdit = (EditText) findViewById(R.id.addNameText),
            dateEdit = (EditText) findViewById(R.id.addDateText),
            neckEdit = (EditText) findViewById(R.id.addNeckText),
            inseamEdit = (EditText) findViewById(R.id.addInseamText),
            bustEdit = (EditText) findViewById(R.id.addBustText),
            waistEdit = (EditText) findViewById(R.id.addWaistText),
            chestEdit = (EditText) findViewById(R.id.addChestText),
            hipEdit = (EditText) findViewById(R.id.addHipText),
            commentEdit = (EditText) findViewById(R.id.addCommentText),
        };

        /**
         * http://stackoverflow.com/questions/17808373/popup-datepicker-for-edittext
         * DatePicker copied from here
         */
        //date calendar for user to pick from
        dateEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddRecordActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        dateEdit.setText(selectedyear + "-" + (selectedmonth + 1) +  "-" + selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });

        //submitting record button, performs error check on input fields before results are returned to MainActivity using intents
        completeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

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
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result", newRecord);
                    setResult(RESULT_OK, returnIntent);
                    finish();

                }
            }
        });

    }

    //error checks all input fields at once
    public Boolean errorCheck(EditText[] editTextArray){

        Integer error = 0;
        for (int i = 0; i < editTextArray.length; i++){
            if(i == 0 ){
                if(editTextArray[i].getText().toString().equals("")){
                    editTextArray[i].setError("Name is a mandatory field");
                    error = 1;
                }
            }

            //no need to check comment and date fields
            else if(i == 8 | i == 1){

            }
            else if(!editTextArray[i].getText().toString().trim().matches(regexStr)){
                editTextArray[i].setError("Measurement must be to one 1 decimal place");
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