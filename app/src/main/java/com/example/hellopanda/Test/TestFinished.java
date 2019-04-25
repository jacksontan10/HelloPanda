package com.example.hellopanda.Test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hellopanda.Home;
import com.example.hellopanda.Models.CategoryScore;
import com.example.hellopanda.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestFinished extends AppCompatActivity {

    Button btnTryAgain, btnHome;
    TextView txtResultScore, getTxtResultQuestion;
    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference category_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_finished);

        database = FirebaseDatabase.getInstance();
        category_score = database.getReference("Category_Score");

        txtResultScore = findViewById(R.id.textTotalScore);
        getTxtResultQuestion = findViewById(R.id.textTotalQuestion);
        progressBar = findViewById(R.id.finishedProgressBar);
        btnTryAgain = findViewById(R.id.btnTryAgain);
        btnHome = findViewById(R.id.btnHome);

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestFinished.this, Playing.class);
                startActivity(intent);
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestFinished.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        //get data from Bundle and set to View
        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            int score = extra.getInt("SCORE");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");

            txtResultScore.setText(String.format("Score : %d", score));
            getTxtResultQuestion.setText(String.format("Passed : %d / %d", correctAnswer, totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);

            //Upload points to database
            category_score.child(String.format("%s_%s", Common.currentUser.getUser(), Common.categoryId))
                    .setValue(new CategoryScore(String.format("%s_%s", Common.currentUser.getUser(),
                            Common.categoryId),
                            Common.currentUser.getUser(),
                            String.valueOf(score)));
        }
    }
}
