package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class BuyFoodActivity extends AppCompatActivity implements View.OnClickListener{

    private int cash = 100;
    private String cashString;
    Account one;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    //Static Variables
    private static final String key = "newCash";
    private static final String Prefs = "mySavedGameFile";


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

        buttonChicken.setOnClickListener(this);
        buttonRice.setOnClickListener(this);
        buttonCarrots.setOnClickListener(this);
        buttonCake.setOnClickListener(this);
        buttonBack5.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRice:
                one.buyRice();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
                break;
            case R.id.buttonCarrots:
                one.buyCarrots();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
                break;
            case R.id.buttonCake:
                one.buyCake();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
                break;
            case R.id.buttonChicken:
                one.buyChicken();
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
                break;
            case R.id.buttonBack5:
                Intent intent = new Intent(this, FoodOptionActivity.class);
                startActivity(intent);
                onPause();
                break;
        }
    }

    public void updateMoney () {
        moneyCount.setText("$: " + one.getCash());
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
