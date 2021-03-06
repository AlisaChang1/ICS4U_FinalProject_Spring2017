package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BedActivity extends AppCompatActivity {

    //Initializes Variables
    //Int Variables
    private int cash = 100;
    int sleep = 0;
    private int energyAmount = 0;

    //String Variables
    private String cashString;
    private String sleepString;
    private String foodString;

    //Textview Variables
    TextView moneyCount;
    TextView textSleep;
    TextView energyBar;

    //Classes Variables
    SleepBarActivity rest;
    Account one;
    EnergyBarActivity energy;


    //Static Variables
    private static final String Prefs_sleep = "mySavedGameFile_sleep";
    private static final String key_sleep = "newSleep";
    private SharedPreferences sharedPref_sleep;
    private SharedPreferences.Editor editor_sleep;


    //Static Variables
    //Static Variables save files for Cash bar:
    private static final String Prefs = "mySavedGameFile";
    private static final String key = "newCash";
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    //Static Variables save files for Energy Bar:
    private SharedPreferences sharedPref_Food;
    private static final String key_Food = "newFood";
    private static final String Prefs_food = "mySaveGameFileFood";

    //button changing animation frames variables
    private static ImageView sleepingguy;
    public static Button buttonLight;
    private int current_image;
    int[] images = {R.drawable.armsdown, R.drawable.sleeping};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed);
        Button buttonLights = (Button)findViewById(R.id.buttonLights);
        Button buttonBack4 = (Button)findViewById(R.id.buttonBack4);
        moneyCount = (TextView)findViewById(R.id.moneyCount);
        textSleep = (TextView)findViewById(R.id.textSleep);
        energyBar = (TextView)findViewById(R.id.energyBar);

        //Initialize the variables need to save information for food energy.
        sharedPref_Food = getSharedPreferences(Prefs_food, MODE_PRIVATE);
        foodString = getString(R.string.Energy);
        energyAmount = sharedPref_Food.getInt(foodString, 0);
        energy = new EnergyBarActivity(energyAmount);
        energyBar.setText(foodString +": " + energy.getEnergy());

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

        buttonClick();

        buttonLights.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSleep();
                SaveSleep(key_sleep, sleep);
                updateSleep();
                LoadSleep();

                //animation frames update
//                if (rest.getSleep() < 50) {
                current_image++;
                current_image = current_image % images.length;
                sleepingguy.setImageResource(images[current_image]);
//                } else if (rest.getSleep() >= 50){
//                    current_image = R.drawable.armsdown;
//                }
            }
        });

        buttonBack4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGameActivity();
            }
        });

    }

    /**
     *OnPause Method which makes sure that the activity is paused not destoryed
     * </P>
     * The code in the onPause method is to insure that the information is saved
     * When the activity is paused.
     */
    @Override
    protected void onPause(){
        super.onPause();
        sharedPref_sleep.edit().putInt(sleepString, sleep).apply();
    }
    /**
     *update Method will update the textView in order to make sure that it has the latest values.
     */
    public void updateSleep () {
        textSleep.setText(sleepString + ": " + rest.getSleep());
    }

    public void setSleep(){
        if(sleep <= 96){
            sleep += 4;
        }
    }

    /**
     *gotoGameActivity method will change the activity to GameActivity once the buttonBack2 is clicked
     */
    private void goToGameActivity()
    {

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

    /**
     *SaveSleep method will save the variables related to sleep and store them to be used for later.
     */
    public void SaveSleep(String key_sleep, int value){
        sharedPref_sleep = getSharedPreferences(Prefs_sleep, MODE_PRIVATE);
        editor_sleep = sharedPref_sleep.edit();
        editor_sleep.putInt(key_sleep, sleep);
        editor_sleep.apply();
    }

    /**
     *LoadSleep method will Load the variables related to sleep
     */
    public void LoadSleep(){
        SharedPreferences sharedPref_sleep = getSharedPreferences(Prefs_sleep, MODE_PRIVATE);
        sleep = sharedPref_sleep.getInt(key_sleep, 0);
        textSleep.setText("Sleep: " + String.valueOf(sleep));
        editor_sleep.apply();
    }

    /**
     *buttonClick method will register if a button within the method is clicked.
     */
    public void buttonClick () {
        sleepingguy = (ImageView)findViewById((R.id.armnsdownman));
        buttonLight=(Button)findViewById((R.id.buttonLights));
    }
}
