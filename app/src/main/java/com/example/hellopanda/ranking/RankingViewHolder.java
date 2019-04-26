package com.example.hellopanda.ranking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hellopanda.R;
import com.example.hellopanda.test.ItemClickListener;

public class RankingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView text_name, text_score, text_rank;

    private ItemClickListener itemClickListener;

    public RankingViewHolder(@NonNull View itemView) {
        super(itemView);
        text_name = itemView.findViewById(R.id.text_name);
        text_score = itemView.findViewById(R.id.text_score);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
