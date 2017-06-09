package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Button buttonFood1 = (Button)findViewById(R.id.buttonFood1);
        Button buttonFood2 = (Button)findViewById(R.id.buttonFood2);
        Button buttonFood3 = (Button)findViewById(R.id.buttonFood3);
        Button buttonFood4 = (Button)findViewById(R.id.buttonFood4);
        Button buttonBack3 = (Button)findViewById(R.id.buttonBack3);

        buttonFood1.setOnClickListener(this);
        buttonFood2.setOnClickListener(this);
        buttonFood3.setOnClickListener(this);
        buttonFood4.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, BuyFoodActivity.class);
        startActivity(i);

        i = new Intent(this, GameActivity.class);
        startActivity(i);
    }

}
