package com.example.hellopanda.ranking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellopanda.R;
import com.example.hellopanda.test.ItemClickListener;

public class RankingViewHolder extends RecyclerView.ViewHolder {

    public TextView text_name, text_score;
    public ImageView userPanda;

    private ItemClickListener itemClickListener;

    public RankingViewHolder(@NonNull View itemView) {
        super(itemView);
        text_name = itemView.findViewById(R.id.text_name);
        text_score = itemView.findViewById(R.id.text_score);
        userPanda = itemView.findViewById(R.id.userPanda);
    }

}
