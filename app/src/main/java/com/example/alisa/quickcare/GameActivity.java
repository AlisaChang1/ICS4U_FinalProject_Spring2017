package com.example.alisa.quickcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.alisa.quickcare.R.id.moneyCount;

public class GameActivity extends AppCompatActivity{

    private int cash = 100;
    int sleep = 0;
    private int energyAmount = 0;

    private String cashString;
    private String sleepString;
    private String foodString;

    //Classes Variables
    SleepBarActivity rest;
    Account one;
    EnergyBarActivity energy;


    //Textview Variables
    TextView moneyCount;
    TextView textSleep;
    TextView energyBar;

    //Static Variables
    //Static Variables save files for Sleep bar:
    private static final String Prefs_sleep = "mySavedGameFile_sleep";
    private SharedPreferences sharedPref_sleep;

    //Static Variables save files for Cash bar
    private static final String Prefs = "mySavedGameFile";
    private SharedPreferences sharedPref;

    //Static Variables save files for Energy Bar:
    private SharedPreferences sharedPref_Food;
    private static final String Prefs_food = "mySaveGameFileFood";

    //Button changing frames animation variables
    public static ImageView poorguy;
    public int current_image;
    private int next_image;
    int[] images = {R.drawable.poorman, R.drawable.duringworkout2, R.drawable.postworkout};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button buttonFood = (Button)findViewById(R.id.buttonFood);
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        Button buttonBed = (Button)findViewById(R.id.buttonBed);
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

        //change frame image
        poorguy = (ImageView)findViewById((R.id.mainpoorman));
        changeImage();

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

    /**
     *gotoFoodActivity method will change the activity to FoodOptionActivity once the buttonBack4 is clicked
     */
    private void goToFoodActivity()
    {
        Intent intent = new Intent(this, FoodOptionActivity.class);
        startActivity(intent);
    }


    /**
     *gotoPlayActivity method will change the activity to PlayActivity once the buttonPLay is clicked
     */
    private void goToPlayActivity()
    {

        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);

    }
    /**
     *gotoBedActivity method will change the activity to BedActivity once the buttonBed is clicked
     */
    private void goToBedActivity()
    {
        Intent intent = new Intent(this, BedActivity.class);
        startActivity(intent);

    }

    /**
     *changeImage method is so that when the energyAmount and the sleep amount are at a certain level
     * the image will be changed.
     */
    private void changeImage (){
        if (energyAmount > 80 && sleep > 80) {
            current_image = current_image + 2;
            current_image = current_image % images.length;
            poorguy.setImageResource(images[current_image]);
        } else if (energyAmount > 50 && sleep > 50) {
            current_image = current_image + 1;
            current_image = current_image % images.length;
            poorguy.setImageResource(images[current_image]);
        } else {
            current_image = R.drawable.poorman;
        }
    }

}
