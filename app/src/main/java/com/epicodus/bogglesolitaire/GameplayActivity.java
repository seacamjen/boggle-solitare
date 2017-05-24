package com.epicodus.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.util.concurrent.ThreadLocalRandom.current;

public class GameplayActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind (R.id.wordSubmitText) Button mWordSubmitText;
    @Bind (R.id.answerText) EditText mAnswerText;
    GridView gridView;
    private Character[] allLetters = new Character[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private Character[] vowels = new Character[] {'A', 'E', 'I', 'O', 'U', 'Y'};
    private ArrayList<Character> currentLetterSet= new ArrayList<>();
    private ArrayList<String> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        currentLetterSet = generateLetters();
        ButterKnife.bind(this);
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new BoggleLetterAdapter(this, currentLetterSet));
        mWordSubmitText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String word = mAnswerText.getText().toString();
        if (isValidWordInLetterSet(word, currentLetterSet) && !results.contains(word.toUpperCase())) {
           results.add(word.toUpperCase());
            for(int i=0; i<results.size(); i++){
                Log.d("result", results.get(i));
            }
        } else {
            Toast.makeText(GameplayActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<Character> generateLetters(){
        ArrayList<Character> output = new ArrayList<>();
        for (int i =0; i<6; i++){
            int randomNum = current().nextInt(0,allLetters.length);
            output.add(allLetters[randomNum]);
        }
        for(int i=0; i<2; i++){
            int randomNum = current().nextInt(0,vowels.length);
            output.add(vowels[randomNum]);
        }
        return output;
    }

    public boolean isValidWordInLetterSet(String word, ArrayList<Character> originalLetterSet){
        ArrayList<Character> letterSet = (ArrayList) originalLetterSet.clone();
        boolean returnVal = false;
        if(word.length()<3 || word.length()>8){
            returnVal =  false;
        } else{
            word = word.toUpperCase();
            int originalLetterSetSize = letterSet.size();
            for(int i=0; i<word.length(); i++){
                Character test = word.charAt(i);
                if(letterSet.contains(word.charAt(i))){
                    int letterMatchIndex = letterSet.indexOf(word.charAt(i));
                    letterSet.remove(letterMatchIndex);
                    if(originalLetterSetSize - word.length() == letterSet.size()){
                        returnVal = true;
                    }
                } else if (!letterSet.contains(word.charAt(i))){
                    returnVal = false;
                } else {
                    returnVal = false;
                }
            }
        }
        return returnVal;
    }
}
