package com.example.alisa.quickcare;

import android.widget.TextView;

/**
 * Created by Alisa on 2017-06-12.
 */



public class Account {
    private int cash;

    public Account (int cash1){
        cash = cash1;
    }

    public int getCash(){
        return cash;
    }

    public void addOne(){
        cash++;
    }

    public void buyCarrots(){
        cash = cash - 10;
    }

    public void buyRice(){
        cash = cash - 5;
    }

    public void buyCake(){
        cash = cash - 2;
    }

    public void buyChicken(){
        cash = cash - 20;
    }


}
