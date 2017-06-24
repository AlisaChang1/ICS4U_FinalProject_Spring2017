package com.example.alisa.quickcare;

/**
 * Created by Alisa on 2017-06-23.
 */

public class SleepBarActivity {
    public int sleep;

    /**
     *Constructor: Sets sleep equal to the variables placed in the parameters
     * @param sleep_1 sleep_1 is equal to the sleep
     */
    public SleepBarActivity(int sleep_1){
        sleep = sleep_1;
    }

    /**
     * Getter method for getsleep, Returns the value of sleep
     * @return
     */
    public int getSleep(){
        return sleep;
    }
}
