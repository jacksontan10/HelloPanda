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

public class LearnFoodFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    LearnFoodAdapter learnFoodAdapter;
    List<LearnFoodModel> models;
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
        myFragment = inflater.inflate(R.layout.fragment_learn_food, container, false);

        models = new ArrayList<>();
        models.add(new LearnFoodModel(R.drawable.food1));
        models.add(new LearnFoodModel(R.drawable.food2));
        models.add(new LearnFoodModel(R.drawable.food3));
        models.add(new LearnFoodModel(R.drawable.food4));
        models.add(new LearnFoodModel(R.drawable.food5));
        models.add(new LearnFoodModel(R.drawable.food6));
        models.add(new LearnFoodModel(R.drawable.food7));
        models.add(new LearnFoodModel(R.drawable.food8));
        models.add(new LearnFoodModel(R.drawable.food9));
        models.add(new LearnFoodModel(R.drawable.food10));
        models.add(new LearnFoodModel(R.drawable.food11));
        models.add(new LearnFoodModel(R.drawable.food12));
        models.add(new LearnFoodModel(R.drawable.food13));
        models.add(new LearnFoodModel(R.drawable.food14));
        models.add(new LearnFoodModel(R.drawable.food15));
        models.add(new LearnFoodModel(R.drawable.food16));
        models.add(new LearnFoodModel(R.drawable.food17));
        models.add(new LearnFoodModel(R.drawable.food18));
        models.add(new LearnFoodModel(R.drawable.food19));
        models.add(new LearnFoodModel(R.drawable.food20));
        models.add(new LearnFoodModel(R.drawable.food21));
        models.add(new LearnFoodModel(R.drawable.food22));

        learnFoodAdapter = new LearnFoodAdapter(models, getContext());

        viewPager = myFragment.findViewById(R.id.viewPager);
        viewPager.setAdapter(learnFoodAdapter);
        viewPager.setPadding(130,0,130,0);



        return myFragment;
    }
}
