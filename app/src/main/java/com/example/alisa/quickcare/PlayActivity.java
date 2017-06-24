package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    //Initializes Variables
    //Int Variables
    private int cash = 100;
    int sleep = 0;
    private int energyAmount = 0;

    //String Variables
    private String cashString;
    private String sleepString;
    private String foodString;

    //TextView Variables
    TextView moneyCount;
    TextView textSleep;
    TextView energyBar;


    //Classes Variables
    SleepBarActivity rest;
    Account one;
    EnergyBarActivity energy;

    //Static Variables
    //Static Variables save files for Cash bar:
    private static final String Prefs = "mySavedGameFile";
    private static final String key = "newCash";
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    //Static Variables
    //Static Variables save files for Sleep bar:
    private static final String Prefs_sleep = "mySavedGameFile_sleep";
    private static final String key_sleep = "newSleep";
    private SharedPreferences sharedPref_sleep;
    private SharedPreferences.Editor editor_sleep;


    //Static Variables save files for Energy Bar:
    private SharedPreferences sharedPref_Food;
    private static final String key_Food = "newFood";
    private static final String Prefs_food = "mySaveGameFileFood";
    private SharedPreferences.Editor editor_Energy;

    //Image to button variables
    private static ImageView workoutguy;
    public static Button buttonJump1;
    private int current_image;
    int[] images = {R.drawable.preworkout, R.drawable.duringworkout,
            R.drawable.duringworkout2, R.drawable.postworkout};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //Links variables with elements in the xml files.
        Button buttonJump = (Button)findViewById(R.id.buttonJump);
        Button buttonBack2 = (Button)findViewById(R.id.buttonBack2);
        moneyCount = (TextView)findViewById(R.id.moneyCount);
        textSleep = (TextView)findViewById(R.id.textSleep);
        energyBar = (TextView)findViewById(R.id.energyBar);

        //Initialize the cash variables
        sharedPref = getSharedPreferences(Prefs, MODE_PRIVATE);
        cashString = getString(R.string.money);
        cash = sharedPref.getInt(cashString, 0);
        one = new Account(cash);
        moneyCount.setText(cashString + ":" + one.getCash());

        //Initialize the sleep save variables
        sharedPref_sleep = getSharedPreferences(Prefs_sleep, MODE_PRIVATE);
        sleepString = getString(R.string.Sleep);
        sleep = sharedPref_sleep.getInt(sleepString, 0);
        rest = new SleepBarActivity(sleep);
        textSleep.setText(sleepString + ": " + rest.getSleep());

        //Initialize the variables need to save information for food energy.
        sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        foodString = getString(R.string.Energy);
        energyAmount = sharedPref_Food.getInt(foodString, 0);
        energy = new EnergyBarActivity(energyAmount);
        energyBar.setText(foodString +": " + energy.getEnergy());
        final Button buttonOneTime = (Button)findViewById(R.id.buttonOneTime);
        buttonOneTime.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                energyAmount = 100;
                SaveInt(key, cash);
                LoadInt();
                energyBar.setText("Energy: " + String.valueOf(energyAmount));
                buttonOneTime.setEnabled(false);
            }
        });

        buttonClick();

        buttonBack2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGameActivity();
            }
        });

        buttonJump.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workOut();
            }
        });

        buttonOneTime.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                energyAmount = 100;
                buttonOneTime.setEnabled(false);
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        sharedPref.edit().putInt(cashString, cash).apply();
        sharedPref_sleep.edit().putInt(sleepString, sleep).apply();
        sharedPref_Food.edit().putInt(foodString, energyAmount).apply();
    }


    public void updateMoney () {
        moneyCount.setText("$: " + one.getCash());
    }

    private void goToGameActivity()
    {

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

    public void workOut() {
        if (sleep >= 2 && energyAmount >= 3) {
            cash++;
            subtractSleep();
            subtractEnergy();
            SaveInt(key, cash);
            SaveSleep(key_sleep, sleep);
            SaveIntFood(key_Food, energyAmount);
            updateMoney();
            LoadInt();
            LoadSleep();
            LoadIntFood();

            //image animation frames update
            current_image++;
            current_image=current_image % images.length;
            workoutguy.setImageResource(images[current_image]);
        } else {
            Toast.makeText(getApplicationContext(), "You don't have enough energy or sleep to continue! ", Toast.LENGTH_SHORT).show();
        }
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

    public void SaveSleep(String key_sleep, int value){
        sharedPref_sleep = getSharedPreferences(Prefs_sleep, MODE_PRIVATE);
        editor_sleep = sharedPref_sleep.edit();
        editor_sleep.putInt(key_sleep, sleep);
        editor_sleep.apply();
    }

    public void LoadSleep(){
        SharedPreferences sharedPref_sleep = getSharedPreferences(Prefs_sleep, MODE_PRIVATE);
        sleep = sharedPref_sleep.getInt(key_sleep, 0);
        textSleep.setText("Sleep: " + String.valueOf(sleep));
        editor_sleep.apply();
    }

    public void subtractSleep(){
        if(sleep >= 2){
            sleep -= 2;
        }
    }

    public void SaveIntFood(String key_Food, int value){
        sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        editor_Energy = sharedPref_Food.edit();
        editor_Energy.putInt(key_Food, energyAmount);
        editor_Energy.apply();
    }

    public void LoadIntFood(){
        SharedPreferences sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        energyAmount = sharedPref_Food.getInt(key_Food, 0);
        energyBar.setText("Energy: " + String.valueOf(energyAmount));
        editor_Energy.apply();
    }

    public void subtractEnergy(){
        if(energyAmount >= 0){
            energyAmount -= 4;
        }
    }

    public void buttonClick () {
        workoutguy = (ImageView)findViewById((R.id.preworkoutman));
        buttonJump1=(Button)findViewById((R.id.buttonJump));
    }
}
