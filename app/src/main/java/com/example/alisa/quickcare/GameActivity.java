package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.bitmap;
import static com.example.alisa.quickcare.R.id.moneyCount;

public class GameActivity extends AppCompatActivity{

    CanvasAnimation canvasAnimation;

    private int cash = 100;
    private String cashString;
    Account one;
    TextView moneyCount;

    private static final String Prefs = "mySavedGameFile";
    private static final String key = "newCash";
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button buttonFood = (Button)findViewById(R.id.buttonFood);
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        Button buttonBed = (Button)findViewById(R.id.buttonBed);
        moneyCount = (TextView)findViewById(R.id.moneyCount);

        //Initialize the cash variables
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cashString = getString(R.string.money);
        cash = sharedPref.getInt(cashString, 0);
        one = new Account(cash);
        moneyCount.setText(cashString + ":" + one.getCash());

        canvasAnimation = new CanvasAnimation(this);
        setContentView(canvasAnimation);

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
