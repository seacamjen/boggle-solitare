package com.epicodus.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.playButton) Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPlayButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v==mPlayButton){
            Intent intent = new Intent(MainActivity.this, GameplayActivity.class);
            startActivity(intent);
        }
    }
}
