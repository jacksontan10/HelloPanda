package com.example.hellopanda;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class LearnBasicsFragment extends Fragment {

    View myFragment;
    private int counter = 0;
    int[] images = {R.drawable.basics1, R.drawable.basics2, R.drawable.basics3, R.drawable.basics4, R.drawable.basics5, R.drawable.basics6, R.drawable.basics7, R.drawable.basics8, R.drawable.basics9, R.drawable.basics10, R.drawable.basics11, R.drawable.basics12, R.drawable.basics13, R.drawable.basics14, R.drawable.basics15, R.drawable.basics16, R.drawable.basics17, R.drawable.basics18, R.drawable.basics19, R.drawable.basics20, R.drawable.basics21, R.drawable.basics22};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Show Up Button (to go back)
        ((Home)getActivity()).showUpButton();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_learn_basics, container, false);

        final ImageView imageView = myFragment.findViewById(R.id.imageView);
        Button button = myFragment.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                counter++;
                counter%=images.length; //could also do counter%=22;

                imageView.setImageResource(images[counter]);
            }
        });

        return myFragment;
    }
}
