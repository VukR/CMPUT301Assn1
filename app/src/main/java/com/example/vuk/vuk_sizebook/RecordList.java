package com.example.vuk.vuk_sizebook;

import java.util.ArrayList;

/**
 * Created by Vuk on 1/22/2017.
 */

public class RecordList {
    protected ArrayList<Record> recordList;

    public RecordList(){
        recordList = new ArrayList<Record>();
    }

    public void addRecord(Record record){
        recordList.add(record);
    }

    public Record getStudent(){
        return recordList.get(0);
    }

    public ArrayList<Record> getRecordList(){
        return recordList;
    }

//    public Record getStudent(Integer pos){
//        return recordList.get(pos);
//    }
}
