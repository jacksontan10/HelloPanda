package com.example.hellopanda;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class LearnBasicsFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    LearnBasicsAdapter learnBasicsAdapter;
    List<LearnBasicsModel> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Show Up Button (to go back)
        ((Home)getActivity()).showUpButton();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_learn_basics, container, false);

        models = new ArrayList<>();
        models.add(new LearnBasicsModel(R.drawable.basics1));
        models.add(new LearnBasicsModel(R.drawable.basics2));
        models.add(new LearnBasicsModel(R.drawable.basics3));
        models.add(new LearnBasicsModel(R.drawable.basics4));
        models.add(new LearnBasicsModel(R.drawable.basics5));
        models.add(new LearnBasicsModel(R.drawable.basics6));
        models.add(new LearnBasicsModel(R.drawable.basics7));
        models.add(new LearnBasicsModel(R.drawable.basics8));
        models.add(new LearnBasicsModel(R.drawable.basics9));
        models.add(new LearnBasicsModel(R.drawable.basics10));
        models.add(new LearnBasicsModel(R.drawable.basics11));
        models.add(new LearnBasicsModel(R.drawable.basics12));
        models.add(new LearnBasicsModel(R.drawable.basics13));
        models.add(new LearnBasicsModel(R.drawable.basics14));
        models.add(new LearnBasicsModel(R.drawable.basics15));
        models.add(new LearnBasicsModel(R.drawable.basics16));
        models.add(new LearnBasicsModel(R.drawable.basics17));
        models.add(new LearnBasicsModel(R.drawable.basics18));
        models.add(new LearnBasicsModel(R.drawable.basics19));
        models.add(new LearnBasicsModel(R.drawable.basics20));
        models.add(new LearnBasicsModel(R.drawable.basics21));
        models.add(new LearnBasicsModel(R.drawable.basics22));

        learnBasicsAdapter = new LearnBasicsAdapter(models, getContext());

        viewPager = myFragment.findViewById(R.id.viewPager);
        viewPager.setAdapter(learnBasicsAdapter);
        viewPager.setPadding(130,0,130,0);



        return myFragment;
    }
}

//sourcecode created with the help from https://stackoverflow.com/questions/40633639/getting-the-correct-context-in-an-adapter-and-fragment