package com.example.alisa.quickcare;

/**
 * Created by patli on 2017-06-23.
 */

public class RiceCounterActivity {
    private int carrotCounter;

    public RiceCounterActivity(int carrotCounter_1)
    {
        carrotCounter = carrotCounter_1;
    }

    public int getRiceCounter(){
        return carrotCounter;
    }
}
