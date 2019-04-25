package com.example.hellopanda.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hellopanda.R;

public class ProgressFragment extends Fragment {

    View myFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_progress, container, false);

        //TO DO: get highest score and replace in "Hi" -> String.valueOf(score);


        TextView highestScore = (TextView)myFragment.findViewById(R.id.highestScore);
        highestScore.setText("Hi");

        //if visibility is 0
        //
        //TO DO: if score is = ___

        return myFragment;
    }
}
