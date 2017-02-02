package com.example.vuk.vuk_sizebook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vuk on 1/22/2017.
 */

public class Record implements Serializable {
    private String name;
    private String bust;
    private String chest;
    private String waist;
    private String inseam;
    //private Date date;
    private String date;
    private String neck;
    private String hip;
    private String comment;

    public Record(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBust(String bust){
        this.bust = bust;
    }

    public String getBust(){
        return bust;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getChest() {
        return chest;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getWaist() {
        return waist;
    }

    public void setInseam(String inseam) {
        this.inseam = inseam;
    }

    public String getInseam() {
        return inseam;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getNeck() {
        return neck;
    }

    public void setHip(String hip) {
        this.hip = hip;
    }

    public String getHip() {
        return hip;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
