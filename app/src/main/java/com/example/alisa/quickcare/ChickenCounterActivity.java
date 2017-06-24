package com.example.alisa.quickcare;

/**
 * Created by patli on 2017-06-23.
 */

public class ChickenCounterActivity {
    private int chickenCounter;

    /**
     *Constructor: Sets the chickenCounter equal to the variables placed in the parameters
     * @param chickenCounter_1 chickenCounter_1 is equal to the chickenCounter.
     */
    public ChickenCounterActivity(int chickenCounter_1)
    {
        chickenCounter = chickenCounter_1;
    }

    /**
     * Getter method for getChickenCounter, Returns the value of chickenCounter
     * @return
     */
    public int getChickenCounter(){
        return chickenCounter;
    }

}
