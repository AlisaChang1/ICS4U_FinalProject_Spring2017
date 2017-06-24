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
    public int carrotCounter = 0, cakeCounter = 0, riceCounter = 0, chickenCounter = 0;
    Account one;
    RiceCounterActivity rice;
    ChickenCounterActivity chicken;
    CakeCounterActivity cake;
    CarrotCounterActivity carrot;

    private String cashString;
    private String buyFoodString_Rice;
    private String buyFoodString_Cake;
    private String buyFoodString_Carrots;
    private String buyFoodString_Chicken;


    //SharedPreferences Variables for Food
    private SharedPreferences sharedPref;
    private SharedPreferences sharedPref_BuyFoodChicken;
    private SharedPreferences sharedPref_BuyFoodRice;
    private SharedPreferences sharedPref_BuyFoodCarrot;
    private SharedPreferences sharedPref_BuyFoodCake;
    private SharedPreferences.Editor editor;
    private SharedPreferences.Editor editor_buyRice;
    private SharedPreferences.Editor editor_buyCarrot;
    private SharedPreferences.Editor editor_buyCake;
    private SharedPreferences.Editor editor_buyChicken;

    //Static Variables for Cash
    private static final String key = "newCash";
    private static final String key_Rice = "newCash";
    private static final String key_Carrot = "newCash";
    private static final String key_Cake = "newCash";
    private static final String key_Chicken = "newCash";
    private static final String Prefs = "mySavedGameFile";

    //Static Variable for buyFood
    private static final String Prefs_BuyRice = "mySavedGameFile_BuyRice";
    private static final String Prefs_BuyCarrot = "mySavedGameFile_BuyCarrots";
    private static final String Prefs_BuyCake = "mySavedGameFile_BuyCake";
    private static final String Prefs_BuyChicken = "mySavedGameFile_BuyChicken";


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

        //Initialize the buyFood variables
        sharedPref_BuyFoodRice = getSharedPreferences(Prefs_BuyRice, MODE_PRIVATE);
        buyFoodString_Rice = getString(R.string.buyRice);
        riceCounter = sharedPref_BuyFoodRice.getInt(buyFoodString_Rice, 0);
        rice = new RiceCounterActivity(riceCounter);


        sharedPref_BuyFoodChicken = getSharedPreferences(Prefs_BuyChicken, MODE_PRIVATE);
        buyFoodString_Chicken = getString(R.string.buyChicken);
        chickenCounter = sharedPref_BuyFoodChicken.getInt(buyFoodString_Chicken, 0);
        chicken = new ChickenCounterActivity(chickenCounter);


        sharedPref_BuyFoodCake = getSharedPreferences(Prefs_BuyCake, MODE_PRIVATE);
        buyFoodString_Cake = getString(R.string.buyCake);
        cakeCounter = sharedPref_BuyFoodCake.getInt(buyFoodString_Cake, 0);
        cake = new CakeCounterActivity(cakeCounter);

        sharedPref_BuyFoodCarrot= getSharedPreferences(Prefs_BuyCarrot, MODE_PRIVATE);
        buyFoodString_Carrots= getString(R.string.buyCarrots);
        chickenCounter = sharedPref_BuyFoodChicken.getInt(buyFoodString_Chicken, 0);
        carrot = new CarrotCounterActivity(carrotCounter);

        buttonRice.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyRice();
                SaveInt(key, cash);
                SaveRice(key_Rice, riceCounter);
                updateMoney();
                LoadInt();
                LoadRice();

            }
        });

        buttonCarrots.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyCarrots();
                SaveInt(key, cash);
                SaveCarrot(key_Carrot, carrotCounter);
                updateMoney();
                LoadInt();
                LoadCarrot();
            }
        });

        buttonCake.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyCake();
                SaveInt(key, cash);
                SaveCake(key_Cake, cakeCounter);
                updateMoney();
                LoadInt();
                LoadCake();
            }
        });

        buttonChicken.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyChicken();
                SaveInt(key, cash);
                SaveChicken(key_Chicken, chickenCounter);
                updateMoney();
                LoadInt();
                LoadChicken();
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
        sharedPref_BuyFoodCake.edit().putInt(buyFoodString_Cake, cakeCounter).apply();
        sharedPref_BuyFoodCarrot.edit().putInt(buyFoodString_Carrots, carrotCounter).apply();
        sharedPref_BuyFoodChicken.edit().putInt(buyFoodString_Chicken, chickenCounter).apply();
        sharedPref_BuyFoodRice.edit().putInt(buyFoodString_Rice, riceCounter).apply();

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

    public void feedChicken(){
        if (chickenCounter >= 1){
            chickenCounter--;
        }
    }

    public void feedCake(){
        if (cakeCounter >= 1){
            cakeCounter--;
        }
    }

    public void feedRice(){
        if (riceCounter >= 1){
            riceCounter--;
        }
    }

    public void feedCarrots(){
        if (carrotCounter >= 1){
            carrotCounter--;
        }
    }

    public int getChicken(){
        return chickenCounter;
    }

    public int getCarrots(){
        return carrotCounter;
    }

    public int getRice(){
        return riceCounter;
    }

    public int getCake(){
        return cakeCounter;
    }


    private void goToFoodOptionActivity()
    {
        Intent intent = new Intent(this, FoodOptionActivity.class);
        startActivity(intent);
    }

    public void SaveInt(String key, int value){
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        sharedPref_BuyFoodCake = getSharedPreferences(Prefs_BuyCake, MODE_PRIVATE);
        editor = sharedPref.edit();
        editor_buyCake = sharedPref_BuyFoodCake.edit();
        editor.putInt(key, cash);
        editor.apply();
    }

    public void SaveRice(String key, int value){
        sharedPref_BuyFoodRice = getSharedPreferences(Prefs_BuyRice, MODE_PRIVATE);
        editor_buyRice = sharedPref_BuyFoodRice.edit();
        editor_buyRice.putInt(key_Rice, riceCounter);
        editor_buyRice.apply();
    }

    public void SaveCarrot(String key, int value){
        sharedPref_BuyFoodCarrot = getSharedPreferences(Prefs_BuyCarrot, MODE_PRIVATE);
        editor_buyCarrot = sharedPref_BuyFoodCarrot.edit();
        editor_buyCarrot.putInt(key_Carrot, carrotCounter);
        editor_buyCarrot.apply();
    }

    public void SaveChicken(String key, int value){
        sharedPref_BuyFoodChicken = getSharedPreferences(Prefs_BuyChicken, MODE_PRIVATE);
        editor_buyChicken = sharedPref_BuyFoodChicken.edit();
        editor_buyChicken.putInt(key_Chicken, chickenCounter);
        editor_buyChicken.apply();
    }

    public void SaveCake(String key, int value){
        sharedPref_BuyFoodCake = getSharedPreferences(Prefs_BuyCake, MODE_PRIVATE);
        editor_buyCake = sharedPref_BuyFoodCake.edit();
        editor_buyCake.putInt(key_Cake, cakeCounter);
        editor_buyCake.apply();
    }

    public void LoadInt(){
        SharedPreferences sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cash = sharedPref.getInt(key , 0);
        moneyCount.setText("$: " + String.valueOf(cash));
        editor.apply();
    }

    public void LoadRice(){
        SharedPreferences sharedPref_BuyFoodRice = getSharedPreferences(Prefs_BuyRice, MODE_PRIVATE);
        riceCounter = sharedPref_BuyFoodRice.getInt(key_Rice, 0);
        editor_buyRice.apply();
    }

    public void LoadCarrot(){
        SharedPreferences sharedPref_BuyFoodCarrot = getSharedPreferences(Prefs_BuyCarrot, MODE_PRIVATE);
        carrotCounter = sharedPref_BuyFoodCarrot.getInt(key_Carrot, 0);
        editor_buyCarrot.apply();
    }

    public void LoadChicken(){
        SharedPreferences sharedPref_BuyFoodChicken = getSharedPreferences(Prefs_BuyChicken, MODE_PRIVATE);
        chickenCounter = sharedPref_BuyFoodChicken.getInt(key_Chicken, 0);
        editor_buyChicken.apply();
    }

    public void LoadCake(){
        SharedPreferences sharedPref_BuyFoodCake = getSharedPreferences(Prefs_BuyCake, MODE_PRIVATE);
        cakeCounter = sharedPref_BuyFoodCake.getInt(key_Cake, 0);
        editor_buyCake.apply();
    }
}
