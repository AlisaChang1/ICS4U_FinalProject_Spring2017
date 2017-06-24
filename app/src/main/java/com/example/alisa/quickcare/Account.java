package com.example.alisa.quickcare;

/**
 * Created by Alisa on 2017-06-12.
 */


public class Account {
    private int cash;

    /**
     * Constructor (Purpose is to create an instance to store the cash value)
     * @param cash1 cash1 is the current value of cash
     */
    public Account (int cash1){
        cash = cash1;
    }

    /**
     * Getter method for getCash, returns the value of cash
     * @return
     */
    public int getCash(){
        return cash;
    }

}
