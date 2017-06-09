package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuyFoodActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_food);
        Button buttonChicken = (Button)findViewById(R.id.buttonChicken);
        Button buttonRice = (Button)findViewById(R.id.buttonRice);
        Button buttonCarrots = (Button)findViewById(R.id.buttonCarrots);
        Button buttonCake = (Button)findViewById(R.id.buttonCake);
        Button buttonBack5 = (Button)findViewById(R.id.buttonBack5);

        buttonChicken.setOnClickListener(this);
        buttonRice.setOnClickListener(this);
        buttonCarrots.setOnClickListener(this);
        buttonCake.setOnClickListener(this);
        buttonBack5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, FoodActivity.class);
        startActivity(i);
    }
}
