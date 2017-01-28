package com.example.vuk.vuk_sizebook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    protected RecordList recordList;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addRecordButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddRecordActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, 0);
//                if(requestCode == 0){
//                }


            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //RecordList recordList;
        Record returnRecord;
        if (requestCode == 0) {
            Log.d("test 5", "the resultCode ia " + resultCode);
            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("result");
//                Log.d("test3", "In main activity name returned is " + result);
                returnRecord = (Record) data.getSerializableExtra("result");
                Log.d("test3", "In main activity name returned is " + returnRecord.getName());
                recordList = new RecordList();
                recordList.addRecord(returnRecord);
                Log.d("test6", "The first record from Tecord array us " + recordList.getStudent().getName());

                RecordAdapter adapter = new RecordAdapter(this, recordList.getRecordList());
                ListView listView = (ListView) findViewById(R.id.recordListView);
                listView.setAdapter(adapter);

                //recordList.get(0);
                //Log.d("test6", "recordList first item is " + recordList[0].getName());
            } else {
                Log.d("test4", "fucked up returning to main activity");
            }
        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
