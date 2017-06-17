package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener{

    int cash = 100;
    EnergyBarActivity energy = new EnergyBarActivity();
    TextView energyBar;
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
        TextView moneyCount = (TextView)findViewById(R.id.moneyCount);
        energyBar = (TextView)findViewById(R.id.energyBar);

        buttonFood1.setOnClickListener(this);
        buttonFood2.setOnClickListener(this);
        buttonFood3.setOnClickListener(this);
        buttonFood4.setOnClickListener(this);


        Account one = new Account(cash);
        moneyCount.setText("$: " + one.getCash());

        energyBar.setText("" + energy);



//        buttonBack3.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                goToFoodOptionActivity();
//            }
//        });
    }
//    private void goToFoodOptionActivity(){
//        Intent intent = new Intent(this, FoodOptionActivity.class);
//        startActivity(intent);
//    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonFood1:
                energy.setEnergyChicken();
                updateEnergy();
                break;
            case R.id.buttonBack2:
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
                Intent i = new Intent(this, PlayActivity.class);
                startActivity(i);
                break;

        }
    }

    public void updateEnergy () {
        energyBar.setText("" + energy.getEnergy());
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
