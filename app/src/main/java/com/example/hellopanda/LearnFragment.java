package com.example.hellopanda;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

public class LearnFragment extends Fragment implements View.OnClickListener, FragmentManager.OnBackStackChangedListener {

    View myFragment;

    public static LearnFragment newInstance() {
        LearnFragment learnFragment = new LearnFragment();
        return learnFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getSupportFragmentManager().addOnBackStackChangedListener(this);

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
        transaction.addToBackStack("learnfragment");
        transaction.commit();
    }

    //Source: verboze implementation of back button on https://stackoverflow.com/questions/13086840/actionbar-up-navigation-with-fragments
    public void onBackStackChanged() {
        // enable Up button only  if there are entries on the backstack
        if(getActivity().getSupportFragmentManager().getBackStackEntryCount() < 1) {
            ((Home)getActivity()).hideUpButton();
        }
    }


}
