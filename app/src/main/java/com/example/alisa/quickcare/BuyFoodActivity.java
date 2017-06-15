package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class BuyFoodActivity extends AppCompatActivity {

    int cash = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_food);
        Button buttonChicken = (Button)findViewById(R.id.buttonChicken);
        //buttonChicken.setOnClickListener(this);
        Button buttonRice = (Button)findViewById(R.id.buttonRice);
        Button buttonCarrots = (Button)findViewById(R.id.buttonCarrots);
        Button buttonCake = (Button)findViewById(R.id.buttonCake);
        Button buttonBack5 = (Button)findViewById(R.id.buttonBack5);

        TextView moneyCount = (TextView)findViewById(R.id.moneyCount);

        Account one = new Account(cash);
        moneyCount.setText("$: " + one.getCash());

        buttonBack5.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFoodOptionActivity();
            }
        });
    }

    private void goToFoodOptionActivity(){
        Intent intent = new Intent(this, FoodOptionActivity.class);
        startActivity(intent);
    }





    /*@Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, FoodActivity.class);
        startActivity(i);
    }*/
}
