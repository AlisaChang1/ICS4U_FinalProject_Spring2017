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
    TextView energyBar;
    TextView moneyCount;
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

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonFood1:
                energy.setEnergyChicken();
                updateEnergy();
                break;
            case R.id.buttonFood2:
                energy.setEnergyCarrots();
                updateEnergy();
                break;
            case R.id.buttonFood3:
                energy.setEnergyRice();
                updateEnergy();
                break;
            case R.id.buttonFood4:
                energy.setEnergyCake();
                updateEnergy();
                break;
            case R.id.buttonBack3:
                Intent i = new Intent(this, FoodOptionActivity.class);
                startActivity(i);
                break;
        }
    }

    public void updateEnergy () {
        energyBar.setText("" + energy.getEnergy());
    }

}
