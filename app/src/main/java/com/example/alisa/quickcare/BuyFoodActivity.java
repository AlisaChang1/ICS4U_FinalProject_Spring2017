package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class BuyFoodActivity extends AppCompatActivity implements View.OnClickListener{

    int cash = 100;
    Account one = new Account(cash);
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

        buttonChicken.setOnClickListener(this);
        buttonRice.setOnClickListener(this);
        buttonCarrots.setOnClickListener(this);
        buttonCake.setOnClickListener(this);
        buttonBack5.setOnClickListener(this);

        moneyCount = (TextView)findViewById(R.id.moneyCount);

        moneyCount.setText("$: " + one.getCash());
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRice:
                one.buyRice();
                updateMoney();
                break;
            case R.id.buttonCarrots:
                one.buyCarrots();
                updateMoney();
                break;
            case R.id.buttonCake:
                one.buyCake();
                updateMoney();
                break;
            case R.id.buttonChicken:
                one.buyChicken();
                updateMoney();
                break;
            case R.id.buttonBack5:
                Intent intent = new Intent(this, GameActivity.class);
                startActivity(intent);
                onPause();
                break;
        }
    }

    public void updateMoney () {
        moneyCount.setText("$: " + one.getCash());
    }






    /*@Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, FoodActivity.class);
        startActivity(i);
    }*/
}
