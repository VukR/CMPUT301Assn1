package com.example.vuk.vuk_sizebook;

import java.io.Serializable;

/**
 * Created by Vuk on 1/22/2017.
 */

public class Record implements Serializable {
    protected String name;
    protected String bust;

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
}
