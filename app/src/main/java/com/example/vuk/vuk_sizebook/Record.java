package com.example.vuk.vuk_sizebook;

import java.io.Serializable;

/**
 * Created by Vuk on 1/22/2017.
 */

public class Record implements Serializable {
    protected String name;

//    public Record(String name){
//        this.name = name;
//    }

    public Record(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
