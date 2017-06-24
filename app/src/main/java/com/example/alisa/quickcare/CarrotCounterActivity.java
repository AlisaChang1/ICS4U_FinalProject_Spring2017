package com.example.alisa.quickcare;

/**
 * Created by patli on 2017-06-23.
 */

public class CarrotCounterActivity {

    private int carrotCounter;

    /**
     *Constructor: Sets the carrotCounter equal to the variables placed in the parameters
     * @param carrotCounter_1 carrotCounter_1 is equal to the carrotCounter.
     */
    public CarrotCounterActivity(int carrotCounter_1){
        carrotCounter = carrotCounter_1;
    }


    /**
     * Getter method for getCarrotCounter, Returns the value of carrotCounter
     * @return
     */
    public int getCarrotCounter(){
        return carrotCounter;
    }

}
