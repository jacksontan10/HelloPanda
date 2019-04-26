package com.example.hellopanda.learn;

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

public class LearnVideosFragment extends Fragment {
    View myFragment;
    ViewPager viewPager;
    LearnVideosAdapter learnVideosAdapter;
    List<LearnVideosModel> models;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Show Up Button (to go back)
        ((Home) getActivity()).showUpButton();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        myFragment = inflater.inflate(R.layout.fragment_learn_videos, container, false);

        models = new ArrayList<>();

        models.add( new LearnVideosModel("<iframe width=\"100%\"height=\"100%\"src=\"https://www.youtube.com/embed/QOpQf3fi2N4\"frameborder=\"0\"allowfullscreen><iframe>"));
        models.add( new LearnVideosModel("<iframe width=\"100%\"height=\"100%\"src=\"https://www.youtube.com/embed/McZW0iDsZns\"frameborder=\"0\"allowfullscreen><iframe>"));
        models.add( new LearnVideosModel("<iframe width=\"100%\"height=\"100%\"src=\"https://www.youtube.com/embed/g7cqtYORC8I\"frameborder=\"0\"allowfullscreen><iframe>"));
        models.add( new LearnVideosModel("<iframe width=\"100%\"height=\"100%\"src=\"https://www.youtube.com/embed/FIxK7mEYFBI\"frameborder=\"0\"allowfullscreen><iframe>"));

        learnVideosAdapter = new LearnVideosAdapter(models, getContext());

        viewPager = myFragment.findViewById(R.id.viewPager);
        viewPager.setAdapter(learnVideosAdapter);
        viewPager.setPadding(130,0,130,0);

        return myFragment;
    }
}


