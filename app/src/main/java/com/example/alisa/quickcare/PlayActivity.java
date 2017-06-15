package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    int cash = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Button buttonJump = (Button)findViewById(R.id.buttonJump);
        Button buttonBack2 = (Button)findViewById(R.id.buttonBack2);
        TextView moneyCount = (TextView)findViewById(R.id.moneyCount);

        buttonJump.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        Account one = new Account(cash);
        moneyCount.setText("$: " + one.getCash());


    }


    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
