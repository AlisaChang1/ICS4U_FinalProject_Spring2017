package com.example.alisa.quickcare;

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
        if(cash >= 10){
            cash = cash - 10;
        }

    }

    public void buyRice(){
        if(cash >= 5) {
            cash = cash - 5;
        }
    }

    public void buyCake(){
        if(cash >= 2){
            cash = cash - 2;
        }
    }

    public void buyChicken(){
        if (cash >= 20){
            cash = cash - 20;
        }
    }

}
