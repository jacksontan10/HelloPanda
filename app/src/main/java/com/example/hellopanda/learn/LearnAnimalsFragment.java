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

public class LearnAnimalsFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    LearnAnimalsAdapter learnAnimalsAdapter;
    List<LearnAnimalsModel> models;

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
        myFragment = inflater.inflate(R.layout.fragment_learn_animals, container, false);

        models = new ArrayList<>();
        models.add(new LearnAnimalsModel(R.drawable.animals1));
        models.add(new LearnAnimalsModel(R.drawable.animals2));
        models.add(new LearnAnimalsModel(R.drawable.animals3));
        models.add(new LearnAnimalsModel(R.drawable.animals4));
        models.add(new LearnAnimalsModel(R.drawable.animals5));
        models.add(new LearnAnimalsModel(R.drawable.animals6));
        models.add(new LearnAnimalsModel(R.drawable.animals7));
        models.add(new LearnAnimalsModel(R.drawable.animals8));
        models.add(new LearnAnimalsModel(R.drawable.animals9));
        models.add(new LearnAnimalsModel(R.drawable.animals10));
        models.add(new LearnAnimalsModel(R.drawable.animals11));
        models.add(new LearnAnimalsModel(R.drawable.animals12));
        models.add(new LearnAnimalsModel(R.drawable.animals13));
        models.add(new LearnAnimalsModel(R.drawable.animals14));
        models.add(new LearnAnimalsModel(R.drawable.animals15));
        models.add(new LearnAnimalsModel(R.drawable.animals16));
        models.add(new LearnAnimalsModel(R.drawable.animals17));
        models.add(new LearnAnimalsModel(R.drawable.animals18));
        models.add(new LearnAnimalsModel(R.drawable.animals19));
        models.add(new LearnAnimalsModel(R.drawable.animals20));
        models.add(new LearnAnimalsModel(R.drawable.animals21));
        models.add(new LearnAnimalsModel(R.drawable.animals22));


        learnAnimalsAdapter = new LearnAnimalsAdapter(models, getContext());

        viewPager = myFragment.findViewById(R.id.viewPager);
        viewPager.setAdapter(learnAnimalsAdapter);
        viewPager.setPadding(130,0,130,0);



        return myFragment;
    }
}
