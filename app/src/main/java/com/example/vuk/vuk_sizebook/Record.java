package com.example.vuk.vuk_sizebook;

import java.io.Serializable;

/**
 * Created by Vuk on 1/22/2017.
 */

public class Record implements Serializable {
    private String name;
    private String bust;
    private String chest;
    private String waist;
    private String inseam;

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
}
