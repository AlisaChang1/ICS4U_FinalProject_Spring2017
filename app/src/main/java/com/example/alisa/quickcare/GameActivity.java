package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.alisa.quickcare.R.id.moneyCount;

public class GameActivity extends AppCompatActivity{

    int cash = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button buttonFood = (Button)findViewById(R.id.buttonFood);
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        Button buttonBed = (Button)findViewById(R.id.buttonBed);
        TextView moneyCount = (TextView)findViewById(R.id.moneyCount);

        Account one = new Account(cash);
        moneyCount.setText("$: " + one.getCash());

        // need to convert the widget string to an int, than add the ints than convert them both back to an int


        buttonFood.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFoodActivity();
            }
        });

        buttonPlay.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPlayActivity();
            }
        });

        buttonBed.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBedActivity();
            }
        });
    }

    private void goToFoodActivity()
    {
        Intent intent = new Intent(this, FoodOptionActivity.class);
        startActivity(intent);
    }

    private void goToPlayActivity()
    {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);

    }

    private void goToBedActivity()
    {
        Intent intent = new Intent(this, BedActivity.class);
        startActivity(intent);

    }




}
