package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    //Initializes Variables
    private int cash = 100;
    private String cashString;
    Account one;
    TextView moneyCount;


    //Static Variables
    private static final String Prefs = "mySavedGameFile";
    private static final String key = "newCash";
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //Links variables with elements in the xml files.
        Button buttonJump = (Button)findViewById(R.id.buttonJump);
        Button buttonBack2 = (Button)findViewById(R.id.buttonBack2);
        moneyCount = (TextView)findViewById(R.id.moneyCount);

        //Initialize the cash variables
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cashString = getString(R.string.money);
        cash = sharedPref.getInt(cashString, 0);
        one = new Account(cash);
        moneyCount.setText(cashString + ":" + one.getCash());

        buttonJump.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cash ++;
                SaveInt(key, cash);
                updateMoney();
                LoadInt();
            }
        });

        buttonBack2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGameActivity();
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        sharedPref.edit().putInt(cashString, cash).apply();
    }

    public void updateMoney () {
        moneyCount.setText("$: " + one.getCash());
    }

    private void goToGameActivity()
    {

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

    public void SaveInt(String key, int value){
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putInt(key, cash);
        editor.apply();
    }

    public void LoadInt(){
        SharedPreferences sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cash = sharedPref.getInt(key , 0);
        moneyCount.setText("$: " + String.valueOf(cash));
        editor.apply();
    }
}
