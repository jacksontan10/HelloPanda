package com.example.hellopanda;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

public class LearnTopics extends Fragment {

    View topicsFragment;

    public static LearnTopics newInstance(){
        LearnTopics learnTopics = new LearnTopics();
        return learnTopics;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        topicsFragment = inflater.inflate(R.layout.topics_learn, container, false);

        TextView txtInfo = (TextView)topicsFragment.findViewById(R.id.chineseText);
        if(getActivity().getIntent() != null)
        {
            String info = getActivity().getIntent().getStringExtra("info");
            txtInfo.setText(info);
        }
        //GridLayout outerGrid  = (GridLayout)myFragment.findViewById(R.id.outerGrid);

        //Set Event
        //setSingleEvent(outerGrid);

        return topicsFragment;


    }
}
