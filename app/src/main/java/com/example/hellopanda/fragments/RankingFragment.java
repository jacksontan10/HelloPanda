package com.example.hellopanda.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hellopanda.models.CategoryScore;
import com.example.hellopanda.models.Ranking;
import com.example.hellopanda.R;
import com.example.hellopanda.models.User;
import com.example.hellopanda.ranking.RankingCallBack;
import com.example.hellopanda.ranking.RankingViewHolder;
import com.example.hellopanda.test.Common;
import com.example.hellopanda.test.ItemClickListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;

public class RankingFragment extends Fragment {

    View myFragment;
    RecyclerView rankingList;
    LinearLayoutManager layoutManager;
    ImageView panda;
    int getPandaResult;
    FirebaseRecyclerAdapter<Ranking, RankingViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference categoryScore, rankingTable, user;

    int sum=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        categoryScore = database.getReference("Category_Score");
        rankingTable = database.getReference("Ranking");
        user = database.getReference("User");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        myFragment = inflater.inflate(R.layout.fragment_ranking, container, false);
        panda = myFragment.findViewById(R.id.userPanda);

        // initiate view
        rankingList = myFragment.findViewById(R.id.rankingList);
        layoutManager = new LinearLayoutManager(getActivity());
        rankingList.setHasFixedSize(true);

        // since Firebase's OrderByChild method sorts lists in ascending order, we need to reverse to descending order
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rankingList.setLayoutManager(layoutManager);

        // implement the callback
        updateScore(Common.currentUser.getUser(), new RankingCallBack<Ranking>() {
            @Override
            public void callBack(Ranking ranking) {
                //Update ranking on Firebase
                rankingTable.child(ranking.getUser()).setValue(ranking);
                showRanking();
            }
        });

        // set the adapter
        adapter = new FirebaseRecyclerAdapter<Ranking, RankingViewHolder> (
                Ranking.class, R.layout.ranking_layout, RankingViewHolder.class, rankingTable.orderByChild("score")
        ) {
            @Override
            protected void populateViewHolder(final RankingViewHolder viewHolder, Ranking model, int position) {
                viewHolder.text_name.setText(model.getUser());
                viewHolder.text_score.setText(String.valueOf(model.getScore()));

                user.child("panda").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            User local = data.getValue(User.class);

                            getPandaResult = local.getPanda();

                            if (getPandaResult == 1){
                                viewHolder.userPanda.setImageResource(R.drawable.panda1);
                            }
                            else if (getPandaResult == 2){
                                viewHolder.userPanda.setImageResource(R.drawable.panda2);
                            }
                            else if (getPandaResult == 3){
                                viewHolder.userPanda.setImageResource(R.drawable.panda3);
                            }
                            else if (getPandaResult == 4){
                                viewHolder.userPanda.setImageResource(R.drawable.panda4);
                            }
                            else if (getPandaResult == 5){
                                viewHolder.userPanda.setImageResource(R.drawable.panda5);
                            }
                            else if (getPandaResult == 6){
                                viewHolder.userPanda.setImageResource(R.drawable.panda6);
                            }
                            else{
                                viewHolder.userPanda.setImageResource(R.drawable.hellopanda_icon);
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        };

        adapter.notifyDataSetChanged();
        rankingList.setAdapter(adapter);

        //panda setting


        return myFragment;
    }

    private void updateScore(final String user, final RankingCallBack<Ranking> callback) {
        categoryScore.orderByChild("user").equalTo(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Sums all the user's scores
                    for(DataSnapshot data:dataSnapshot.getChildren())
                    {
                        CategoryScore ques = data.getValue(CategoryScore.class);
                    sum+=Integer.parseInt(ques.getScore());
                   // Ranking panda = data.getValue(Ranking.class);
                    // pandaInt = panda.getPanda();
                }
                //After summing scores, the Sum variable is processed here to prevent the sum resetting each time
                Ranking ranking = new Ranking(user, sum);
                callback.callBack(ranking);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showRanking() {
        rankingTable.orderByChild("score").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    Ranking local = data.getValue(Ranking.class);
                    Log.d("DEBUG", " " + local.getUser());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}