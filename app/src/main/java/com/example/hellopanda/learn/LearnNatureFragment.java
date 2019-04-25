package com.example.hellopanda.learn;

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

public class LearnNatureFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    LearnNatureAdapter learnNatureAdapter;
    List<LearnNatureModel> models;
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
        myFragment = inflater.inflate(R.layout.fragment_learn_nature, container, false);

        models = new ArrayList<>();
        models.add(new LearnNatureModel(R.drawable.nature1));
        models.add(new LearnNatureModel(R.drawable.nature2));
        models.add(new LearnNatureModel(R.drawable.nature3));
        models.add(new LearnNatureModel(R.drawable.nature4));
        models.add(new LearnNatureModel(R.drawable.nature5));
        models.add(new LearnNatureModel(R.drawable.nature6));
        models.add(new LearnNatureModel(R.drawable.nature7));
        models.add(new LearnNatureModel(R.drawable.nature8));
        models.add(new LearnNatureModel(R.drawable.nature9));
        models.add(new LearnNatureModel(R.drawable.nature10));
        models.add(new LearnNatureModel(R.drawable.nature11));
        models.add(new LearnNatureModel(R.drawable.nature12));
        models.add(new LearnNatureModel(R.drawable.nature13));
        models.add(new LearnNatureModel(R.drawable.nature14));
        models.add(new LearnNatureModel(R.drawable.nature15));
        models.add(new LearnNatureModel(R.drawable.nature16));
        models.add(new LearnNatureModel(R.drawable.nature17));
        models.add(new LearnNatureModel(R.drawable.nature18));
        models.add(new LearnNatureModel(R.drawable.nature19));
        models.add(new LearnNatureModel(R.drawable.nature20));
        models.add(new LearnNatureModel(R.drawable.nature21));
        models.add(new LearnNatureModel(R.drawable.nature22));


        learnNatureAdapter = new LearnNatureAdapter(models, getContext());

        viewPager = myFragment.findViewById(R.id.viewPager);
        viewPager.setAdapter(learnNatureAdapter);
        viewPager.setPadding(130,0,130,0);



        return myFragment;
    }
}
