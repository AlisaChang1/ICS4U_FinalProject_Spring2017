package com.example.alisa.quickcare;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(this);

        //Play background music
        backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.music1);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
    }


    @Override
    public void onClick(View v) {
        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
