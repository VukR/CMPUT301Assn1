package com.example.vuk.vuk_sizebook;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vuk on 1/26/2017.
 */
public class RecordListTest {

    @Test
    public void testRecordList(){
        String name = "VUK";
        Record record = new Record();
        record.setName(name);

        RecordList recordList = new RecordList();
        recordList.addRecord(record);
        assertTrue("Name is not equal", name.equals(recordList.getStudent().getName()));

    }
}