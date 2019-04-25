package com.example.hellopanda.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hellopanda.Home;
import com.example.hellopanda.models.Question;
import com.example.hellopanda.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

public class Start extends AppCompatActivity {

    Button btnStart, btnBack;

    FirebaseDatabase database;
    DatabaseReference questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        database = FirebaseDatabase.getInstance();
        questions = database.getReference("Questions");

        loadQuestions(Common.categoryId);

        btnStart = findViewById(R.id.btn_Start);
        btnBack = findViewById(R.id.btn_Back);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, Playing.class);
                startActivity(intent);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, Home.class);
                startActivity(intent);

                finish();
            }
        });
    }

    private void loadQuestions(String categoryId) {

        if(Common.questionList.size() > 0)
            Common.questionList.clear();

        questions.orderByChild("CategoryId").equalTo(categoryId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Question ques = postSnapshot.getValue(Question.class);
                            Common.questionList.add(ques);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        //Randomise list of questions
        Collections.shuffle(Common.questionList);
    }

}
