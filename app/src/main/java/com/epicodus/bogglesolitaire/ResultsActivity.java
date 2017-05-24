package com.epicodus.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {
    @Bind(R.id.resultsDisplay) ListView mResultsDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);
        Log.d("resultsPage", "Oh hi there!");
        Intent intent = getIntent();
        ArrayList<String> results = intent.getStringArrayListExtra("results");
        for(int i=0; i<results.size(); i++){
            Log.d("retrievedResults", results.get(i));
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, results);
        mResultsDisplay.setAdapter(adapter);

    }
}
