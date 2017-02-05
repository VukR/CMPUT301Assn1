package com.example.vuk.vuk_sizebook;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Vuk on 1/26/2017.
 */
public class RecordListTest {

    //adds a record to a RecordList and check it
    @Test
    public void testAddRecordList(){
        String name = "VUK";
        Record record = new Record();
        record.setName(name);

        RecordList recordList = new RecordList();
        recordList.addRecord(record);
        assertTrue("Name is not equal", name.equals(recordList.getRecord(0).getName()));

    }

    //adds Record and checks that list size is one, deletes record checks that list size is 0
    @Test
    public void testDeleteRecordList() {
        String name = "VUK";
        Record record = new Record();
        record.setName(name);

        RecordList recordList = new RecordList();
        recordList.addRecord(record);
        assertTrue("Size is not 1", recordList.size() == 1);
        recordList.deleteRecord(record);
        assertTrue("Size is not 0", recordList.size() == 0);
    }

    //adds record, checks size of record to be 1
    @Test
    public void testSizeRecordList() {
        Record record = new Record();
        RecordList recordList = new RecordList();
        recordList.addRecord(record);
        assertTrue("Size is not 1", recordList.size() == 1);
    }

    //getting the proper record out of a list
    @Test
    public void testGetRecordRecordList() {
        String name = "VUK";
        Record record = new Record();
        record.setName(name);
        RecordList recordList = new RecordList();
        recordList.addRecord(record);
        assertTrue("Name is not equal", name.equals(recordList.getRecord(0).getName()));
    }

    //check to make sure getRecordList does return the proper recordlist.
    @Test
    public void testGetRecordListRecordList() {
        Record record = new Record();
        RecordList recordList = new RecordList();
        recordList.addRecord(record);
        ArrayList <Record> recordList1 = recordList.getRecordList();
        assertTrue("List not equal", recordList.getRecordList() == recordList1 );
    }
}