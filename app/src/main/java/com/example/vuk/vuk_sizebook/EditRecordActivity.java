package com.example.vuk.vuk_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditRecordActivity extends AppCompatActivity {

    private Button completeButton;

    private EditText nameEdit;

    private Record editRecord, newRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        completeButton = (Button)findViewById(R.id.editSubmitButton);
        nameEdit = (EditText)findViewById(R.id.editNameText);

        editRecord = (Record) getIntent().getSerializableExtra("edit");
        createEditSetup(editRecord);

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEdit.getText().toString().equals("")) {
                    Log.d("EditRecordActivity", "name is empty in Edit Record");
                    nameEdit.setError("Name is a mandatory field");
                }

                else if(!nameEdit.getText().toString().equals("")){
                    newRecord = new Record();
                    newRecord.setName(nameEdit.getText().toString());
                    //newRecord.setBust(bustEdit.getText().toString());
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("Edit Result", newRecord);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
            }
        });
    }

    public void createEditSetup(Record editRecord){
        nameEdit.setText(editRecord.getName());
    }
}
