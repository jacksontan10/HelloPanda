package com.example.hellopanda.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellopanda.Models.Category;
import com.example.hellopanda.Models.CategoryScore;
import com.example.hellopanda.Models.Ranking;
import com.example.hellopanda.R;
import com.example.hellopanda.Test.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RankingFragment extends Fragment {

    View myFragment;

    FirebaseDatabase database;
    DatabaseReference categoryScore;

    int sum=0;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        categoryScore = database.getReference("Category_Score");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        myFragment = inflater.inflate(R.layout.fragment_ranking, container, false);

        updateScore(Common.currentUser.getUser());

        return myFragment;
    }

    private void updateScore(final String user) {
        categoryScore.orderByChild("user").equalTo(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Sums all the user's scores
                for(DataSnapshot data:dataSnapshot.getChildren())
                {
                    CategoryScore ques = data.getValue(CategoryScore.class);
                    sum+=Integer.parseInt(ques.getScore());
                }
                //After summing scores, the Sum variable is processed here to prevent the sum resetting each time
                Ranking ranking = new Ranking(user, sum);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
