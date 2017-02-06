package com.example.vuk.vuk_sizebook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


/*
    MainActivity is the initial screen that appears on start of the app
    MainActivity links to the AddRecordActivity, EditRecordActivity and ViewRecordActivity through the use of intents
    MainActivity displays the listview of records for the user to view and interact with. MainActivity also updates the current total
    number of records.
    Adding records can be can be access through the addButtonListener
    Editing, deleting and viewing records can be accessed through the longclicklistener dialog

 */

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    protected RecordList recordList;
    private ListView listView;
    private RecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.addRecordButton);
        listView = (ListView) findViewById(R.id.recordListView);
        recordList = new RecordList();

        updateTextView(recordList);

        adapter = new RecordAdapter(this, recordList.getRecordList());
        listView.setAdapter(adapter);

        //on click listener for adding a Record. Launches AddRecordActivity.
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddRecordActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        /** skeleton of how my longclicklistener was set up
         * http://stackoverflow.com/questions/23195208/how-to-pop-up-a-dialog-to-confirm-delete-when-user-long-press-on-the-list-item
         **/

        //onlongclicklistener for dialog options to delete/view/edit records
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {

                final int position = pos;
                final Record record = recordList.getRecordList().get(pos);

                //initialise dialog
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Record Options");
                alert.setMessage("Choose an option please");

                //edit record option, calls editRecord function to begin switching activities
                alert.setPositiveButton("Edit Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editRecord(record, position, recordList);
                        dialog.dismiss();
                    }
                });

                //delete record option, updates listview immediately and saving to file
                alert.setNegativeButton("Delete Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recordList.deleteRecord(record);
                        dialog.dismiss();
                        adapter.notifyDataSetChanged();
                        saveInFile();
                        updateTextView(recordList);
                    }
                });

                //view record option, changes to ViewRecordActivity.
                alert.setNeutralButton("View Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, ViewRecordActivity.class);
                        intent.putExtra("view", record);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });

                alert.show();
                return true;
            }
        });

    }

    //helper function used to change to EditRecordActivity
    public void editRecord(Record record, int position, RecordList recordList){
        Intent intent = new Intent(MainActivity.this, EditRecordActivity.class);
        intent.putExtra("editRecord", record);
        intent.putExtra("editPosition", position);
        intent.putExtra("editRecordList", recordList);
        startActivityForResult(intent, 1);
    }


    //accept returned information from activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Record returnRecord;

        //AddRecordActivity results, updating listview, and saving to file
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                returnRecord = (Record) data.getSerializableExtra("result");
                recordList.addRecord(returnRecord);
                adapter.notifyDataSetChanged();
                saveInFile();
                updateTextView(recordList);

            }
        }
        //EditRecordActivity results, updating listview, and saving to file
        else if (requestCode == 1){
            if(resultCode == RESULT_OK) {
                recordList = (RecordList) data.getSerializableExtra("Edit Result");
                adapter = new RecordAdapter(this, recordList.getRecordList());
                listView.setAdapter(adapter);
                saveInFile();
                updateTextView(recordList);
            }
        }
    }

    //helper function for updating total number of records
    public void updateTextView(RecordList recordList){
        TextView textView = (TextView) findViewById(R.id.totalRecordTextView);
        textView.setText(getString(R.string.record_count, recordList.size()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        recordList = new RecordList();
        loadFromFile();
        adapter = new RecordAdapter(this, recordList.getRecordList());
        listView.setAdapter(adapter);

    }

    /**
        Loading and reading from file, is fro lonely twitter lab example
     */

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2017-01-24 18:19
            Type listType = new TypeToken<ArrayList<Record>>(){}.getType();
            ArrayList<Record> temp = gson.fromJson(in, listType);

            recordList.setLoadRecordList(temp);
            updateTextView(recordList);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(recordList.getRecordList(), out);

            out.flush();

            fos.close();

        } catch (FileNotFoundException e) {
            // TODO: Handle the Exception properly later
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

