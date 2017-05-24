package com.epicodus.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private String[] allLetters = new String[] {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private String[] vowels = new String[] {"A", "E", "I", "O", "U", "Y"};
    private ArrayList<String> currentLetterSet= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentLetterSet = generateLetters();
    }

    public ArrayList<String> generateLetters(){
        ArrayList<String> output = new ArrayList<>();
        for (int i =0; i<6; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0,allLetters.length);
            output.add(allLetters[randomNum]);
        }
        for(int i=0; i<2; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0,vowels.length);
            output.add(vowels[randomNum]);
        }
        return output;
    }


}
