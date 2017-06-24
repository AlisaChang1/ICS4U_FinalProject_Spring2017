package com.example.alisa.quickcare;

/**
 * Created by patli on 2017-06-23.
 */

public class CakeCounterActivity {
    private int cakeCounter;

    /**
     * Constructor: Sets the cakeCounter equal to the variable placed in the parameters
     * @param cakeCounter_1 cakeCounter_1 is the current value of the current cakeCounter
     */
    public CakeCounterActivity(int cakeCounter_1)
    {
        cakeCounter = cakeCounter_1;
    }

    /**
     * Getter method for getCakeCounter, Returns the value of cakeCounter
     * @return
     */
    public int getCakeCounter(){
        return cakeCounter;
    }

}
