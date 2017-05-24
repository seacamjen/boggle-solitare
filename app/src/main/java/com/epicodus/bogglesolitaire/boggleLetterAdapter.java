package com.epicodus.bogglesolitaire;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BoggleLetterAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Character> mLetters;

    public BoggleLetterAdapter(Context context, ArrayList<Character> letters){
        this.mContext = context;
        this.mLetters = letters;
    }

    @Override
    public int getCount() {
        return mLetters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null){
            gridView = inflater.inflate(R.layout.boggle_letter_grid_item, null);

            TextView letterView = (TextView) gridView.findViewById(R.id.grid_item_letter);
            letterView.setText(String.valueOf(mLetters.get(position)));
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }

}
