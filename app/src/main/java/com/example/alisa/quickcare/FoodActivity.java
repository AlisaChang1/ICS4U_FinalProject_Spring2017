package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FoodActivity extends AppCompatActivity{

    int cash = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Button buttonFood1 = (Button)findViewById(R.id.buttonFood1);
        Button buttonFood2 = (Button)findViewById(R.id.buttonFood2);
        Button buttonFood3 = (Button)findViewById(R.id.buttonFood3);
        Button buttonFood4 = (Button)findViewById(R.id.buttonFood4);
        Button buttonBack3 = (Button)findViewById(R.id.buttonBack3);
        TextView moneyCount = (TextView)findViewById(R.id.moneyCount);

          Account one = new Account(cash);
        moneyCount.setText("$: " + one.getCash());



        buttonBack3.setOnClickListener (new View.OnClickListener() {
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
        i = new Intent(this, BuyFoodActivity.class);
        startActivity(i);

        i = new Intent(this, GameActivity.class);
        startActivity(i);
    }*/
}
