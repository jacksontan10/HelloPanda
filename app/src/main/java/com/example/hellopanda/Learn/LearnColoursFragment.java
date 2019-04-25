package com.example.hellopanda.Learn;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellopanda.Home;
import com.example.hellopanda.R;

import java.util.ArrayList;
import java.util.List;

public class LearnColoursFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    LearnColoursAdapter learnColoursAdapter;
    List<LearnColoursModel> models;
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
        //return super.onCreateView(inflater, container, savedInstanceState);
        myFragment = inflater.inflate(R.layout.fragment_learn_colours, container, false);

        models = new ArrayList<>();
        models.add(new LearnColoursModel(R.drawable.colour1));
        models.add(new LearnColoursModel(R.drawable.colour2));
        models.add(new LearnColoursModel(R.drawable.colour3));
        models.add(new LearnColoursModel(R.drawable.colour4));
        models.add(new LearnColoursModel(R.drawable.colour5));
        models.add(new LearnColoursModel(R.drawable.colour6));
        models.add(new LearnColoursModel(R.drawable.colour7));
        models.add(new LearnColoursModel(R.drawable.colour8));
        models.add(new LearnColoursModel(R.drawable.colour9));
        models.add(new LearnColoursModel(R.drawable.colour10));
        models.add(new LearnColoursModel(R.drawable.colour11));
        models.add(new LearnColoursModel(R.drawable.colour12));
        models.add(new LearnColoursModel(R.drawable.colour13));
        models.add(new LearnColoursModel(R.drawable.colour14));
        models.add(new LearnColoursModel(R.drawable.colour15));
        models.add(new LearnColoursModel(R.drawable.colour16));
        models.add(new LearnColoursModel(R.drawable.colour17));


        learnColoursAdapter = new LearnColoursAdapter(models, getContext());

        viewPager = myFragment.findViewById(R.id.viewPager);
        viewPager.setAdapter(learnColoursAdapter);
        viewPager.setPadding(130,0,130,0);



        return myFragment;
    }
}

//sourcecode created with the help from https://stackoverflow.com/questions/40633639/getting-the-correct-context-in-an-adapter-and-fragment