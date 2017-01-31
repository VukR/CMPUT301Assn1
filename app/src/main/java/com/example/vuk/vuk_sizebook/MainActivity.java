package com.example.vuk.vuk_sizebook;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    protected RecordList recordList;
    private ListView listView;
    private RecordAdapter adapter;

//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addRecordButton);
        listView = (ListView) findViewById(R.id.recordListView);
        recordList = new RecordList();
        updateTextView(recordList);
        adapter = new RecordAdapter(this, recordList.getRecordList());
        listView.setAdapter(adapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddRecordActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        /** skeleton of how my longclicklistener was set up
         * http://stackoverflow.com/questions/23195208/how-to-pop-up-a-dialog-to-confirm-delete-when-user-long-press-on-the-list-item
         **/
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {

                final int position = pos;
                final Record record = recordList.getRecordList().get(pos);

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Record Options");
                alert.setMessage("Choose an option please");

                alert.setPositiveButton("Edit Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editRecord(record, position, recordList);
                        //recordList.deleteRecord(record);
                        //adapter.notifyDataSetChanged();
                        Log.d("TEST 4", "Edit Record Button Was Clicked");
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("Delete Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("TEST 4", "Delete Record Button Was Clicked");
                        recordList.deleteRecord(record);
                        dialog.dismiss();
                        adapter.notifyDataSetChanged();
                        updateTextView(recordList);
                    }
                });

                alert.setNeutralButton("View Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("TEST 4", "Cancel Record Button Was Clicked");
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


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void editRecord(Record record, int position, RecordList recordList){
        Intent intent = new Intent(MainActivity.this, EditRecordActivity.class);
//        Bundle extras = new Bundle();
//        extras.putSerializable
        intent.putExtra("editRecord", record);
        intent.putExtra("editPosition", position);
        intent.putExtra("editRecordList", recordList);
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //RecordList recordList;
        Record returnRecord;
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                returnRecord = (Record) data.getSerializableExtra("result");
                recordList.addRecord(returnRecord);

//                for (int i = 0; i < recordList.size(); i++){
//                    Log.d("updating of listview", recordList.getStudent(i).getName() + " is item " + i);
//                }

                //RecordAdapter adapter = new RecordAdapter(this, recordList.getRecordList());
                //ListView listView = (ListView) findViewById(R.id.recordListView);
                //listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                updateTextView(recordList);

            }
            else {
                Log.d("test4", "fucked up returning to main activity");
            }
        }
        else if (requestCode == 1){
            if(resultCode == RESULT_OK) {
                recordList = (RecordList) data.getSerializableExtra("Edit Result");
                //returnRecord = (Record) data.getSerializableExtra("Edit Result");
                //Log.d("return Record", returnRecord.getName());
                //recordList.addRecord(returnRecord);
                //adapter.notifyDataSetChanged();
                adapter = new RecordAdapter(this, recordList.getRecordList());
                listView.setAdapter(adapter);
                updateTextView(recordList);
            }
        }
    }

    public void updateTextView(RecordList recordList){
        TextView textView = (TextView) findViewById(R.id.totalRecordTextView);
        textView.setText(getString(R.string.record_count, recordList.size()));
    }

//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    public Action getIndexApiAction() {
//        Thing object = new Thing.Builder()
//                .setName("Main Page") // TODO: Define a title for the content shown.
//                // TODO: Make sure this auto-generated URL is correct.
//                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//                .build();
//        return new Action.Builder(Action.TYPE_VIEW)
//                .setObject(object)
//                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//                .build();
//    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
//    }
}
