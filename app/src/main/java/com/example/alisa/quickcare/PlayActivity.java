package com.example.alisa.quickcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    int cash = 100;
    Account one;
    TextView moneyCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Button buttonJump = (Button)findViewById(R.id.buttonJump);
        Button buttonBack2 = (Button)findViewById(R.id.buttonBack2);
        moneyCount = (TextView)findViewById(R.id.moneyCount);

        buttonJump.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        one = new Account(cash);
        moneyCount.setText("$: " + one.getCash());


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonJump:
                one.addOne();
                updateMoney();
                break;
            case R.id.buttonBack2:
                Intent intent = new Intent(this, GameActivity.class);
                startActivity(intent);
                onPause();
                break;
        }
    }

    public void updateMoney () {
        moneyCount.setText("$: " + one.getCash());
    }

    @Override
    public void onPause(){
        super.onPause();
    }



}
