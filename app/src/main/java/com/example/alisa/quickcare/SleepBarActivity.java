package com.example.alisa.quickcare;

/**
 * Created by Alisa on 2017-06-23.
 */

public class SleepBarActivity {
    public int sleep;
    public SleepBarActivity(){
        sleep = 0;
    }

    public void setSleep(){
        sleep += 5;
    }

    public void setExercise(){
        sleep--;
    }

    public int getSleep(){
        return sleep;
    }
}
