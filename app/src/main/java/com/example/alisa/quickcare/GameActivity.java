package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button buttonFood = (Button)findViewById(R.id.buttonFood);
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        Button buttonBed = (Button)findViewById(R.id.buttonBed);

        buttonFood.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);
        buttonBed.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;

        i = new Intent(this, FoodActivity.class);
        startActivity(i);

        i = new Intent(this, PlayActivity.class);
        startActivity(i);

        i = new Intent(this, BedActivity.class);
        startActivity(i);

    }
}
