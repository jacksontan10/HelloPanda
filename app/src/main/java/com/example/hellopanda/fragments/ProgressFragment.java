package com.example.hellopanda.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellopanda.R;
import com.example.hellopanda.models.Ranking;
import com.example.hellopanda.test.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

import static com.example.hellopanda.test.Common.currentUser;

public class ProgressFragment extends Fragment {

    View myFragment;
    TextView  highestScore;

    String storeScore;
    int storeScoreInt;

    FirebaseDatabase database;
    DatabaseReference rankingTable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        rankingTable = database.getReference("Ranking");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_progress, container, false);

        highestScore = myFragment.findViewById(R.id.highestScore);

        rankingTable.orderByChild("user").equalTo(Common.currentUser.getUser()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    Ranking local = data.getValue(Ranking.class);

                    storeScoreInt = local.getScore();
                    storeScore = String.valueOf(local.getScore());
                    highestScore.setText(storeScore);

                    ImageView bamboo1 = myFragment.findViewById(R.id.bamboo1);
                    ImageView bamboo2 = myFragment.findViewById(R.id.bamboo2);
                    ImageView bamboo3 = myFragment.findViewById(R.id.bamboo3);
                    ImageView bamboo4 = myFragment.findViewById(R.id.bamboo4);
                    ImageView bamboo5 = myFragment.findViewById(R.id.bamboo5);
                    ImageView panda = myFragment.findViewById(R.id.panda);

                    if (storeScoreInt < 100){
                        bamboo1.setVisibility(View.INVISIBLE);
                        bamboo2.setVisibility(View.INVISIBLE);
                        bamboo3.setVisibility(View.INVISIBLE);
                        bamboo4.setVisibility(View.INVISIBLE);
                        bamboo5.setVisibility(View.INVISIBLE);
                        panda.setVisibility(View.INVISIBLE);
                    }
                    else if (storeScoreInt >= 100 && storeScoreInt < 200) {
                        bamboo1.setVisibility(View.VISIBLE);
                    }
                    else if (storeScoreInt >= 200 && storeScoreInt < 300){
                        bamboo1.setVisibility(View.VISIBLE);
                        bamboo2.setVisibility(View.VISIBLE);
                    }
                    else if (storeScoreInt >= 300 && storeScoreInt < 400){
                        bamboo1.setVisibility(View.VISIBLE);
                        bamboo2.setVisibility(View.VISIBLE);
                        bamboo3.setVisibility(View.VISIBLE);
                    }
                    else if (storeScoreInt >= 400 && storeScoreInt < 500){
                        bamboo1.setVisibility(View.VISIBLE);
                        bamboo2.setVisibility(View.VISIBLE);
                        bamboo3.setVisibility(View.VISIBLE);
                        bamboo4.setVisibility(View.VISIBLE);
                    }
                    else if (storeScoreInt >= 500 && storeScoreInt < 600){
                        bamboo1.setVisibility(View.VISIBLE);
                        bamboo2.setVisibility(View.VISIBLE);
                        bamboo3.setVisibility(View.VISIBLE);
                        bamboo4.setVisibility(View.VISIBLE);
                        bamboo5.setVisibility(View.VISIBLE);
                    }
                    else {
                        bamboo1.setVisibility(View.VISIBLE);
                        bamboo2.setVisibility(View.VISIBLE);
                        bamboo3.setVisibility(View.VISIBLE);
                        bamboo4.setVisibility(View.VISIBLE);
                        bamboo5.setVisibility(View.VISIBLE);
                        panda.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return myFragment;
    }



}
