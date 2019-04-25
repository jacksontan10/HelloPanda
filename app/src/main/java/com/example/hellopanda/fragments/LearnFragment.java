package com.example.hellopanda.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellopanda.Home;
import com.example.hellopanda.learn.LearnAnimalsFragment;
import com.example.hellopanda.learn.LearnBasicsFragment;
import com.example.hellopanda.learn.LearnColoursFragment;
import com.example.hellopanda.learn.LearnFoodFragment;
import com.example.hellopanda.learn.LearnNatureFragment;
import com.example.hellopanda.R;


public class LearnFragment extends Fragment implements View.OnClickListener, FragmentManager.OnBackStackChangedListener {

    View myFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().addOnBackStackChangedListener(this); //null

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_learn, container, false);

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

    //Source: https://stackoverflow.com/questions/32700818/how-to-open-a-fragment-on-button-click-from-a-fragment-in-android
    @Override
    public void onClick(View view) {
        Fragment fragment;
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
        FragmentTransaction transaction = getFragmentManager().beginTransaction(); //nullpointer
        transaction.replace(R.id.learnFragmentFrame, someFragment);
        transaction.addToBackStack("learnfragment");
        transaction.commit();
    }

    //Source: verboze implementation of back button on https://stackoverflow.com/questions/13086840/actionbar-up-navigation-with-fragments
    public void onBackStackChanged() {
        // enable Up button only if there are entries on the backstack
        if(getChildFragmentManager().getBackStackEntryCount() < 1) { //nullpointer
            ((Home)getActivity()).hideUpButton();
        }
    }

}
