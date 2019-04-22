package com.example.hellopanda;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

public class LearnFragment extends Fragment {

    View myFragment;

    public static LearnFragment newInstance(){
        LearnFragment learnFragment = new LearnFragment();
        return learnFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_learn, container, false);
        GridLayout outerGrid  = (GridLayout)myFragment.findViewById(R.id.outerGrid);

        //Set Event
        setSingleEvent(outerGrid);

        return myFragment;
    }

    private void setSingleEvent(GridLayout outerGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < outerGrid.getChildCount(); i++) {
            //All child item is CardView -> so we just cast object to CardView
            CardView cardView = (CardView) outerGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getContext(), Home.class);
                    intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);

                }
            });
        }
    }

    //Toggle Event
    private void setToggleEvent(GridLayout outerGrid) {
        //Loop all child item of Outer grid
        for (int i = 0; i < outerGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) outerGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(getContext(), "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(getContext(), "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
