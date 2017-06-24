package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FoodOptionActivity extends AppCompatActivity {

    public int carrotCounter = 0, cakeCounter = 0, riceCounter = 0, chickenCounter = 0;

    RiceCounterActivity rice;
    ChickenCounterActivity chicken;
    CakeCounterActivity cake;
    CarrotCounterActivity carrot;


    private String buyFoodString_Rice;
    private String buyFoodString_Cake;
    private String buyFoodString_Carrots;
    private String buyFoodString_Chicken;


    //SharedPreferences Variables for Food
    private SharedPreferences sharedPref_BuyFoodChicken;
    private SharedPreferences sharedPref_BuyFoodRice;
    private SharedPreferences sharedPref_BuyFoodCarrot;
    private SharedPreferences sharedPref_BuyFoodCake;

    //Static Variable for buyFood
    private static final String Prefs_BuyRice = "mySavedGameFile_BuyRice";
    private static final String Prefs_BuyCarrot = "mySavedGameFile_BuyCarrots";
    private static final String Prefs_BuyCake = "mySavedGameFile_BuyCake";
    private static final String Prefs_BuyChicken = "mySavedGameFile_BuyChicken";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_option);

        Button buttonBuyFood = (Button)findViewById(R.id.buttonBuyFood);
        Button buttonFeed = (Button)findViewById(R.id.buttonFeed);
        Button buttonBack = (Button)findViewById(R.id.buttonBack6);

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
        carrotCounter = sharedPref_BuyFoodCarrot.getInt(buyFoodString_Carrots, 0);
        carrot = new CarrotCounterActivity(carrotCounter);



        buttonBuyFood.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBuyFoodActivity();
            }
        });

        buttonFeed.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFeedActivity();
            }
        });

        buttonBack.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               goToGameActivity();
            }
        });

    }
    /**
     *gotoFeedActivity will change the activity to the FoodActivity once the Food button is clicked
     */
    private void goToFeedActivity()
    {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }
    /**
     *goToBuyFoodActivity will change to BuyFoodActivity once the buttonBuyFood is clicked
     */
    private void goToBuyFoodActivity()
    {
        Intent intent = new Intent(this, BuyFoodActivity.class);
        startActivity(intent);
    }

    /**
     *gotoGameActivity will change the GameActivity once the buttonBack is clicked
     */
    private void goToGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

}
