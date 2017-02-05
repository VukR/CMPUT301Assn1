package com.example.vuk.vuk_sizebook;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vuk on 1/22/2017.
 */
public class RecordTest {

    //checking if method getName, setName works for Records.
    @Test

    public void testSetGetName(){
        String name = "A NAME";
        Record record = new Record();
        record.setName(name);
        assertTrue("Name is not equal", name.equals(record.getName()));
    }

    //checking if method getBust, setBust works for Records.
    @Test

    public void testSetGetBust(){
        String bust = "A Bust";
        Record record = new Record();
        record.setBust(bust);
        assertTrue("Bust is not equal", bust.equals(record.getBust()));
    }

    //checking if method getChest, setChest works for Records.
    @Test

    public void testSetGetChest(){
        String chest = "A Chest";
        Record record = new Record();
        record.setChest(chest);
        assertTrue("Chest is not equal", chest.equals(record.getChest()));
    }

    //checking if method getWaist, setWaist works for Records.
    @Test

    public void testSetGetWaist(){
        String waist = "A Waist";
        Record record = new Record();
        record.setWaist(waist);
        assertTrue("Waist is not equal", waist.equals(record.getWaist()));
    }

    //checking if method getInseam, setInseam works for Records.
    @Test

    public void testSetGetInseam(){
        String inseam = "A Inseam";
        Record record = new Record();
        record.setInseam(inseam);
        assertTrue("Inseam is not equal", inseam.equals(record.getInseam()));
    }

    //checking if method getNeck, setNeck works for Records.
    @Test

    public void testSetGetNeck(){
        String neck = "A Neck";
        Record record = new Record();
        record.setNeck(neck);
        assertTrue("Neck is not equal", neck.equals(record.getNeck()));
    }

    //checking if method getHip, setHip works for Records.
    @Test

    public void testSetGetHip(){
        String hip = "A Hip";
        Record record = new Record();
        record.setHip(hip);
        assertTrue("Neck is not equal", hip.equals(record.getHip()));
    }

    //checking if method getComment, setComment works for Records.
    @Test

    public void testSetGetComment(){
        String comment = "A comment";
        Record record = new Record();
        record.setComment(comment);
        assertTrue("Neck is not equal", comment.equals(record.getComment()));
    }

    //checking if method getDate, setDate works for Records.
    @Test

    public void testSetGetDate(){
        String date = "A Date";
        Record record = new Record();
        record.setDate(date);
        assertTrue("Neck is not equal", date.equals(record.getDate()));
    }

}