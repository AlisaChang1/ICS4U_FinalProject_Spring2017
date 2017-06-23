package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class BuyFoodActivity extends AppCompatActivity{

    private int cash = 100;
    private String cashString;
    Account one;
    private SharedPreferences sharedPref;
    private SharedPreferences saveFood;
    private SharedPreferences.Editor editor;

    //Static Variables
    private static final String key = "newCash";
    private static final String Prefs = "mySavedGameFile";
    public int carrotCounter = 0, cakeCounter = 0, riceCounter = 0, chickenCounter = 0;


    //XML Variables
    TextView moneyCount;
    Button buttonRice, buttonCarrots, buttonCake, buttonChicken, buttonBack5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_food);
        buttonChicken = (Button)findViewById(R.id.buttonChicken);
        buttonRice = (Button)findViewById(R.id.buttonRice);
        buttonCarrots = (Button)findViewById(R.id.buttonCarrots);
        buttonCake = (Button)findViewById(R.id.buttonCake);
        buttonBack5 = (Button)findViewById(R.id.buttonBack5);
        moneyCount = (TextView)findViewById(R.id.moneyCount);


        //Initialize the cash variables
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cashString = getString(R.string.money);
        cash = sharedPref.getInt(cashString, 0);
        one = new Account(cash);
        moneyCount.setText(cashString + ":" + one.getCash());

        buttonRice.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyRice();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
            }
        });

        buttonCarrots.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyCarrots();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
            }
        });

        buttonCake.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyCake();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
            }
        });

        buttonChicken.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyChicken();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
            }
        });

        buttonBack5.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFoodOptionActivity();
            }
        });


    }

    @Override
    protected void onPause(){
        super.onPause();
        sharedPref.edit().putInt(cashString, cash).apply();
    }

    public void updateMoney () {
        moneyCount.setText("$: " + one.getCash());
    }

    public int buyCarrots(){
        if(cash >= 10){
            cash = cash - 10;
            carrotCounter++;
        }
        return carrotCounter;

    }

    public int buyRice(){
        if(cash >= 5) {
            cash = cash - 5;
            riceCounter++;
        }
        return riceCounter;
    }

    public int buyCake(){
        if(cash >= 2){
            cash = cash - 2;
            cakeCounter++;
        }
        return cakeCounter;
    }

    public int buyChicken(){
        if (cash >= 20){
            cash = cash - 20;
            chickenCounter++;
        }
        return chickenCounter;
    }

    public int feedChicken(){
        if (chickenCounter >= 1){
            chickenCounter--;
        }
        return chickenCounter;
    }

    public int feedCake(){
        if (cakeCounter >= 1){
            cakeCounter--;
        }
        return cakeCounter;
    }

    public int feedRice(){
        if (riceCounter >= 1){
            riceCounter--;
        }
        return riceCounter;
    }

    public int feedCarrots(){
        if (carrotCounter >= 1){
            carrotCounter--;
        }
        return carrotCounter;
    }


    private void goToFoodOptionActivity()
    {
        Intent intent = new Intent(this, FoodOptionActivity.class);
        startActivity(intent);
    }

    public void SaveInt(String key, int value){
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putInt(key, cash);
        editor.apply();
    }

    public void LoadInt(){
        SharedPreferences sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cash = sharedPref.getInt(key , 0);
        moneyCount.setText("$: " + String.valueOf(cash));
        editor.apply();
    }
}
