package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener{

    private int cash = 100;
    private String cashString;
    Account one;
    private SharedPreferences sharedPref;
    private static final String Prefs = "mySavedGameFile";

    EnergyBarActivity energy = new EnergyBarActivity();
    BuyFoodActivity food = new BuyFoodActivity();
    TextView energyBar, moneyCount, carrotNum, cakeNum, riceNum, chickenNum;
    Button buttonFood1, buttonFood2, buttonFood3, buttonFood4, buttonBack3;

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
        energyBar = (TextView)findViewById(R.id.energyBar);
        carrotNum = (TextView)findViewById(R.id.carrotNum);
        cakeNum = (TextView)findViewById(R.id.cakeNum);
        riceNum = (TextView)findViewById(R.id.riceNum);
        chickenNum = (TextView)findViewById(R.id.chickenNum);

        buttonFood1.setOnClickListener(this);
        buttonFood2.setOnClickListener(this);
        buttonFood3.setOnClickListener(this);
        buttonFood4.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);


        //Initialize the cash variables
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cashString = getString(R.string.money);
        cash = sharedPref.getInt(cashString, 0);
        one = new Account(cash);

        moneyCount.setText(cashString + ":" + one.getCash());
        energyBar.setText("" + energy);
        carrotNum.setText("" + Integer.toString(food.buyCarrots()));
        riceNum.setText("" + Integer.toString(food.buyRice()));
        chickenNum.setText("" + Integer.toString(food.buyChicken()));
        cakeNum.setText("" + Integer.toString(food.buyCake()));

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonFood1:
                energy.setEnergyChicken();
                chickenNum.setText("" + food.feedChicken());
                updateEnergy();
                break;
            case R.id.buttonFood2:
                energy.setEnergyCarrots();
                carrotNum.setText("" + food.feedCarrots());
                updateEnergy();
                break;
            case R.id.buttonFood3:
                energy.setEnergyRice();
                riceNum.setText("" + food.feedRice());
                updateEnergy();
                break;
            case R.id.buttonFood4:
                energy.setEnergyCake();
                cakeNum.setText("" + food.feedCake());
                updateEnergy();
                break;
            case R.id.buttonBack3:
                Intent i = new Intent(this, FoodOptionActivity.class);
                startActivity(i);
                break;
        }
    }

    public void updateEnergy () {
        energyBar.setText("Energy: " + energy.getEnergy());
    }

}
