package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FoodActivity extends AppCompatActivity{

    //Initialize private Variables

    //Int Variables
    private int cash = 100;
    int sleep = 0;
    private int energyAmount = 0;
    public int carrotCounter = 0, cakeCounter = 0, riceCounter = 0, chickenCounter = 0;

    //String Variables
    private String cashString;
    private String sleepString;
    private String foodString;
    private String buyFoodString_Rice;
    private String buyFoodString_Cake;
    private String buyFoodString_Carrots;
    private String buyFoodString_Chicken;


    //Classes Variables
    Account one;
    SleepBarActivity rest;
    RiceCounterActivity rice;
    ChickenCounterActivity chicken;
    CakeCounterActivity cake;
    CarrotCounterActivity carrot;
    EnergyBarActivity energy;

    //XML Variables
    TextView energyBar, moneyCount, carrotNum, cakeNum, riceNum, chickenNum, textSleep;
    Button buttonFood1, buttonFood2, buttonFood3, buttonFood4, buttonBack3;

    //Initialize Static Variables For Money
    private SharedPreferences sharedPref;
    private static final String Prefs = "mySavedGameFile";

    //Static Variables save files for Sleep bar:
    private static final String Prefs_sleep = "mySavedGameFile_sleep";
    private static final String key_sleep = "newSleep";
    private SharedPreferences sharedPref_sleep;

    //Initialize Static Variables For Food (energy).
    private SharedPreferences sharedPref_Food;
    private static final String key_Food = "newFood";
    private static final String Prefs_food = "mySaveGameFileFood";
    private SharedPreferences.Editor editor;


    //SharedPreferences Variables for Food
    private SharedPreferences sharedPref_BuyFoodChicken;
    private SharedPreferences sharedPref_BuyFoodRice;
    private SharedPreferences sharedPref_BuyFoodCarrot;
    private SharedPreferences sharedPref_BuyFoodCake;
    private SharedPreferences.Editor editor_buyRice;
    private SharedPreferences.Editor editor_buyCarrot;
    private SharedPreferences.Editor editor_buyCake;
    private SharedPreferences.Editor editor_buyChicken;

    //Static Variables for Food
    private static final String key_Rice = "newCash";
    private static final String key_Carrot = "newCash";
    private static final String key_Cake = "newCash";
    private static final String key_Chicken = "newCash";

    //Static Variable for buyFood
    private static final String Prefs_BuyRice = "mySavedGameFile_BuyRice";
    private static final String Prefs_BuyCarrot = "mySavedGameFile_BuyCarrots";
    private static final String Prefs_BuyCake = "mySavedGameFile_BuyCake";
    private static final String Prefs_BuyChicken = "mySavedGameFile_BuyChicken";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        buttonFood1 = (Button)findViewById(R.id.buttonFood1);
        buttonFood2 = (Button)findViewById(R.id.buttonFood2);
        buttonFood3 = (Button)findViewById(R.id.buttonFood3);
        buttonFood4 = (Button)findViewById(R.id.buttonFood4);
        buttonBack3 = (Button)findViewById(R.id.buttonBack3);
        moneyCount = (TextView)findViewById(R.id.moneyCount);
        textSleep = (TextView)findViewById(R.id.textSleep);
        energyBar = (TextView)findViewById(R.id.energyBar);
        carrotNum = (TextView)findViewById(R.id.carrotNum);
        cakeNum = (TextView)findViewById(R.id.cakeNum);
        riceNum = (TextView)findViewById(R.id.riceNum);
        chickenNum = (TextView)findViewById(R.id.chickenNum);

        //Initialize the variables need to save information for money
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cashString = getString(R.string.money);
        cash = sharedPref.getInt(cashString, 0);
        one = new Account(cash);
        moneyCount.setText(cashString + ":" + one.getCash());

        //Initialize the variables need to save information for food energy.
        sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        foodString = getString(R.string.Energy);
        energyAmount = sharedPref_Food.getInt(foodString, 0);
        energy = new EnergyBarActivity(energyAmount);
        energyBar.setText(foodString +": " + energy.getEnergy());

        //Initialize the sleep save variables
        sharedPref_sleep = getSharedPreferences(Prefs_sleep, MODE_PRIVATE);
        sleepString = getString(R.string.Sleep);
        sleep = sharedPref_sleep.getInt(sleepString, 0);
        rest = new SleepBarActivity(sleep);
        textSleep.setText(sleepString + ": " + rest.getSleep());

        //Initialize the buyFood variables
        sharedPref_BuyFoodRice = getSharedPreferences(Prefs_BuyRice, MODE_PRIVATE);
        buyFoodString_Rice = getString(R.string.buyRice);
        riceCounter = sharedPref_BuyFoodRice.getInt(buyFoodString_Rice, 0);
        rice = new RiceCounterActivity(riceCounter);
        riceNum.setText(buyFoodString_Rice + ": " + rice.getRiceCounter());


        sharedPref_BuyFoodChicken = getSharedPreferences(Prefs_BuyChicken, MODE_PRIVATE);
        buyFoodString_Chicken = getString(R.string.buyChicken);
        chickenCounter = sharedPref_BuyFoodChicken.getInt(buyFoodString_Chicken, 0);
        chicken = new ChickenCounterActivity(chickenCounter);
        chickenNum.setText(buyFoodString_Chicken + ": " + chicken.getChickenCounter());


        sharedPref_BuyFoodCake = getSharedPreferences(Prefs_BuyCake, MODE_PRIVATE);
        buyFoodString_Cake = getString(R.string.buyCake);
        cakeCounter = sharedPref_BuyFoodCake.getInt(buyFoodString_Cake, 0);
        cake = new CakeCounterActivity(cakeCounter);
        cakeNum.setText(buyFoodString_Cake + ": " + cake.getCakeCounter());


        sharedPref_BuyFoodCarrot= getSharedPreferences(Prefs_BuyCarrot, MODE_PRIVATE);
        buyFoodString_Carrots= getString(R.string.buyCarrots);
        carrotCounter = sharedPref_BuyFoodCarrot.getInt(buyFoodString_Carrots, 0);
        carrot = new CarrotCounterActivity(carrotCounter);
        carrotNum.setText(buyFoodString_Carrots + ": " + carrot.getCarrotCounter());


        buttonFood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnergyChicken();
                SaveIntFood(key_Food, energyAmount);
                SaveChicken(key_Chicken, chickenCounter);
                updateEnergy();
                //updateFoodAmount();
                LoadIntFood();
                LoadChicken();
            }
        });

        buttonFood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnergyCarrots();
                SaveIntFood(key_Food, energyAmount);
                SaveCarrot(key_Carrot, carrotCounter);
                updateEnergy();
                //updateFoodAmount();
                LoadIntFood();
                LoadCarrot();
            }
        });

        buttonFood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnergyRice();
                SaveIntFood(key_Food, energyAmount);
                SaveRice(key_Rice, riceCounter);
                updateEnergy();
                //updateFoodAmount();
                LoadIntFood();
                LoadRice();
            }
        });

        buttonFood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnergyCake();
                SaveIntFood(key_Food, energyAmount);
                SaveCake(key_Cake, cakeCounter);
                updateEnergy();
                //updateFoodAmount();
                LoadIntFood();
                LoadCake();
            }
        });

        buttonBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFoodOptionActivity();
            }
        });

    }

    public void updateEnergy () {
        energyBar.setText(foodString +": " + energy.getEnergy());
    }

    /*public void updateFoodAmount(){
        riceNum.setText(buyFoodString_Rice + ": " + rice.getRiceCounter());
        chickenNum.setText(buyFoodString_Chicken + ": " + chicken.getChickenCounter());
        cakeNum.setText(buyFoodString_Cake + ": " + cake.getCakeCounter());
        carrotNum.setText(buyFoodString_Carrots + ": " + carrot.getCarrotCounter());
    }*/

    @Override
    protected void onPause(){
        super.onPause();
        sharedPref_Food.edit().putInt(foodString, energyAmount).apply();
        sharedPref_BuyFoodCake.edit().putInt(buyFoodString_Cake, cakeCounter).apply();
        sharedPref_BuyFoodCarrot.edit().putInt(buyFoodString_Carrots, carrotCounter).apply();
        sharedPref_BuyFoodRice.edit().putInt(buyFoodString_Rice, riceCounter).apply();
        sharedPref_BuyFoodChicken.edit().putInt(buyFoodString_Chicken, chickenCounter).apply();
    }

    private void goToFoodOptionActivity()
    {

        Intent intent = new Intent(this, FoodOptionActivity.class);
        startActivity(intent);

    }

    public void SaveIntFood(String key_Food, int value){
        sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        editor = sharedPref_Food.edit();
        editor.putInt(key_Food, energyAmount);
        editor.apply();
    }

    public void LoadIntFood(){
        SharedPreferences sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        energyAmount = sharedPref_Food.getInt(key_Food, 0);
        energyBar.setText("Energy: " + String.valueOf(energyAmount));
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

    public void LoadRice(){
        SharedPreferences sharedPref_BuyFoodRice = getSharedPreferences(Prefs_BuyRice, MODE_PRIVATE);
        riceCounter = sharedPref_BuyFoodRice.getInt(key_Rice, 0);
        riceNum.setText("Rice: " + String.valueOf(riceCounter));
        editor_buyRice.apply();
    }

    public void LoadCarrot(){
        SharedPreferences sharedPref_BuyFoodCarrot = getSharedPreferences(Prefs_BuyCarrot, MODE_PRIVATE);
        carrotCounter = sharedPref_BuyFoodCarrot.getInt(key_Carrot, 0);
        carrotNum.setText("Carrots: " + String.valueOf(carrotCounter));
        editor_buyCarrot.apply();
    }

    public void LoadChicken(){
        SharedPreferences sharedPref_BuyFoodChicken = getSharedPreferences(Prefs_BuyChicken, MODE_PRIVATE);
        chickenCounter = sharedPref_BuyFoodChicken.getInt(key_Chicken, 0);
        chickenNum.setText("Chicken: " + String.valueOf(chickenCounter));
        editor_buyChicken.apply();
    }

    public void LoadCake(){
        SharedPreferences sharedPref_BuyFoodCake = getSharedPreferences(Prefs_BuyCake, MODE_PRIVATE);
        cakeCounter = sharedPref_BuyFoodCake.getInt(key_Cake, 0);
        cakeNum.setText("Cake: " + String.valueOf(cakeCounter));
        editor_buyCake.apply();
    }

    public void setEnergyCake() {
        if (energyAmount <= 95 && cakeCounter > 0) {
            cakeCounter--;
            energyAmount += 5;
        }else if (cakeCounter == 0){
            Toast.makeText(getApplicationContext(), "You have no more food of this type!", Toast.LENGTH_SHORT).show();
        }
    }

    public void setEnergyCarrots() {
        if (energyAmount <= 90 && carrotCounter > 0) {
            carrotCounter--;
            energyAmount += 10;
        }else if (carrotCounter == 0){
            Toast.makeText(getApplicationContext(), "You have no more food of this type!", Toast.LENGTH_SHORT).show();
        }
    }

    public void setEnergyRice() {
        if (energyAmount <= 80 && riceCounter > 0) {
            riceCounter--;
            energyAmount += 20;
        }else if (riceCounter == 0){
            Toast.makeText(getApplicationContext(), "You have no more food of this type!", Toast.LENGTH_SHORT).show();
        }
    }

    public void setEnergyChicken() {
        if (energyAmount <= 50 && chickenCounter > 0) {
            chickenCounter--;
            energyAmount += 50;
        }else if (chickenCounter == 0){
            Toast.makeText(getApplicationContext(), "You have no more food of this type!", Toast.LENGTH_SHORT).show();
        }
    }

}
