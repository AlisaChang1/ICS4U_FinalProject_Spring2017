package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BedActivity extends AppCompatActivity implements View.OnClickListener{

    int cash = 100;
    TextView textSleep;
    SleepBarActivity rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed);
        Button buttonLights = (Button)findViewById(R.id.buttonLights);
        Button buttonBack4 = (Button)findViewById(R.id.buttonBack4);
        buttonLights.setOnClickListener(this);
        buttonBack4.setOnClickListener(this);

        textSleep = (TextView)findViewById(R.id.textSleep);
        rest = new SleepBarActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBack4:
                Intent i;
                i = new Intent(this, GameActivity.class);
                startActivity(i);
                break;
            case R.id.buttonLights:
                rest.setSleep();
                updateSleep();

        }
    }
    public void updateSleep () {
        textSleep.setText("Sleep: : " + rest.getSleep());
    }
}
