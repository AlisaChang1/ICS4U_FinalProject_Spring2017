package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_option);

        Button buttonBuyFood = (Button)findViewById(R.id.buttonBuyFood);
        Button buttonFeed = (Button)findViewById(R.id.buttonFeed);


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
    }

    private void goToFeedActivity()
    {
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    private void goToBuyFoodActivity()
    {
        Intent intent = new Intent(this, BuyFoodActivity.class);
        startActivity(intent);
    }

}
