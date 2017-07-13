package com.example.choi.memo_homework;

import java.lang.ref.SoftReference;

/**
 * Created by choi on 2017. 3. 28..
 */

public class data {
    private String text;

    public data(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
