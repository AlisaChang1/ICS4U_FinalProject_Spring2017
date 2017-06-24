package com.example.alisa.quickcare;

/**
 * Created by patli on 2017-06-23.
 */

public class RiceCounterActivity {
    private int riceCounter;

    public RiceCounterActivity(int riceCounter_1)
    {
        riceCounter = riceCounter_1;
    }

    /**
     * Getter method for getRiceCounter, Returns the value of riceCounter
     * @return
     */
    public int getRiceCounter(){
        return riceCounter;
    }
}
