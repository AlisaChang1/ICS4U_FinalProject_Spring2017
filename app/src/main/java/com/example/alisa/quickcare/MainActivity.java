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
        Button canvasButton = (Button)findViewById(R.id.canvasButton);
        canvasButton.setOnClickListener(this);

        //Play background music
        backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.sound1);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.canvasButton:
                Intent i = new Intent(this, CanvasAnimation.class);
                startActivity(i);
                break;
            case R.id.buttonStart:
                Intent a = new Intent(this, GameActivity.class);
                startActivity(a);
                break;
        }
    }
}
