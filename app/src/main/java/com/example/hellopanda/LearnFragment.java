package com.example.hellopanda;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

public class LearnFragment extends Fragment implements View.OnClickListener {

    View myFragment;

    public static LearnFragment newInstance() {
        LearnFragment learnFragment = new LearnFragment();
        return learnFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_learn, container, false);
        //GridLayout outerGrid = (GridLayout) myFragment.findViewById(R.id.outerGrid);

        CardView basics = myFragment.findViewById(R.id.basics);
        CardView food = myFragment.findViewById(R.id.food);
        CardView animals = myFragment.findViewById(R.id.animals);
        CardView nature = myFragment.findViewById(R.id.nature);
        CardView colours = myFragment.findViewById(R.id.colours);

        basics.setOnClickListener(this);
        food.setOnClickListener(this);
        animals.setOnClickListener(this);
        nature.setOnClickListener(this);
        colours.setOnClickListener(this);

        return myFragment;
    }

    //Source code with the help of: https://www.youtube.com/watch?v=VUPM387qyrw&t=12s
    //private void setSingleEvent(GridLayout outerGrid) {
        //Loop all child item of Main Grid
      //  for (int i = 0; i < outerGrid.getChildCount(); i++) {
            //All child item is CardView -> so we just cast object to CardView
         //   CardView cardView = (CardView) outerGrid.getChildAt(i);
         //   final int finalI = i;
         //   cardView.setOnClickListener(new View.OnClickListener() {
            //    @Override
               // public void onClick(View view) {
                 //   Intent intent = new Intent(getContext(), LearnBasicsFragment.class); //change Home.class to new page with flashcards
               //     intent.putExtra("info", "This is activity from card item index  " + finalI);
             //       startActivity(intent);
  //              }
//
      //      });
    //    }


    //Source: https://stackoverflow.com/questions/32700818/how-to-open-a-fragment-on-button-click-from-a-fragment-in-android
    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.basics:
                fragment = new LearnBasicsFragment();
                replaceFragment(fragment);
                break;
            case R.id.food:
                fragment = new LearnFoodFragment();
                replaceFragment(fragment);
                break;
            case R.id.animals:
                fragment = new LearnAnimalsFragment();
                replaceFragment(fragment);
                break;
            case R.id.nature:
                fragment = new LearnNatureFragment();
                replaceFragment(fragment);
                break;
            case R.id.colours:
                fragment = new LearnColoursFragment();
                replaceFragment(fragment);
                break;
        }


    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.learnFragmentFrame, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
