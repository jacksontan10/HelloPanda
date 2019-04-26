package com.example.hellopanda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellopanda.test.Common;

public class SelectPanda extends AppCompatActivity {

    Button btnFinished;
    ImageView getPanda1, getPanda2, getPanda3, getPanda4, getPanda5, getPanda6,getUserPanda;
    TextView getUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_panda);

        //Clicking through different panda avatars
        getPanda1 = findViewById(R.id.panda1);
        getPanda2 = findViewById(R.id.panda2);
        getPanda3 = findViewById(R.id.panda3);
        getPanda4 = findViewById(R.id.panda4);
        getPanda5 = findViewById(R.id.panda5);
        getPanda6 = findViewById(R.id.panda6);
        getUserPanda = findViewById(R.id.userPanda);

        getPanda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserPanda.setImageResource(R.drawable.panda1);
            }
        });

        getPanda2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserPanda.setImageResource(R.drawable.panda2);
            }
        });

        getPanda3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserPanda.setImageResource(R.drawable.panda3);
            }
        });

        getPanda4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserPanda.setImageResource(R.drawable.panda4);
            }
        });

        getPanda5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserPanda.setImageResource(R.drawable.panda5);
            }
        });

        getPanda6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserPanda.setImageResource(R.drawable.panda6);
            }
        });

        //Display username
        getUser = findViewById(R.id.username);
        getUser.setText(Common.currentUser.getUser().toString());

        //I'm finished button
        btnFinished = findViewById(R.id.btn_finished);

        btnFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent onboardActivity = new Intent(SelectPanda.this, Onboarding.class);
                SelectPanda.this.startActivity(onboardActivity);
                finish();
            }
        });
    }
}
