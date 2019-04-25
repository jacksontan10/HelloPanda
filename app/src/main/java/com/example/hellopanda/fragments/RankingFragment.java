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

import com.example.hellopanda.models.CategoryScore;
import com.example.hellopanda.models.Ranking;
import com.example.hellopanda.R;
import com.example.hellopanda.RankingCallBack;
import com.example.hellopanda.RankingViewHolder;
import com.example.hellopanda.test.Common;
import com.example.hellopanda.test.ItemClickListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RankingFragment extends Fragment {

    View myFragment;
    RecyclerView rankingList;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Ranking, RankingViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference categoryScore, rankingTable;

    int sum=0;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        categoryScore = database.getReference("Category_Score");
        rankingTable = database.getReference("Ranking");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        myFragment = inflater.inflate(R.layout.fragment_ranking, container, false);

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
            protected void populateViewHolder(RankingViewHolder viewHolder, Ranking model, int position) {
                viewHolder.text_name.setText(model.getUser());
                viewHolder.text_score.setText(String.valueOf(model.getScore()));

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                    }
                });
            }
        };

        adapter.notifyDataSetChanged();
        rankingList.setAdapter(adapter);
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
                    Log.d("DEBUG", local.getUser());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
