package com.example.hellopanda.Test;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellopanda.R;
import com.squareup.picasso.Picasso;

public class Playing extends AppCompatActivity implements View.OnClickListener {
    final static long INTERVAL = 2000; //2 seconds
    final static long TIMEOUT = 10000; //10 seconds
    int progressValue = 0;

    CountDownTimer mCountDown;

    int index = 0, score = 0, thisQuestion = 0;
    int totalQuestion, correctAnswer;

    ProgressBar progressBar;
    ImageView question_image;
    Button btnA, btnB, btnC, btnD;
    TextView textScore;
    TextView textQuestionNumber;
    TextView question_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //Views
        textScore = findViewById(R.id.textScore);
        textQuestionNumber = findViewById(R.id.textTotalQuestion);
        question_text = findViewById(R.id.question_text);
        question_image = findViewById(R.id.question_image);

        progressBar = findViewById(R.id.progress_bar);

        btnA = findViewById(R.id.btnAnswerA);
        btnB = findViewById(R.id.btnAnswerB);
        btnC = findViewById(R.id.btnAnswerC);
        btnD = findViewById(R.id.btnAnswerD);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mCountDown.cancel();
        if(index < totalQuestion) //If there are still questions left
        {
            Button clickedButton = (Button)view;
            //If correct answer clicked
            if(clickedButton.getText().equals(Common.questionList.get(index).getCorrectAnswer()))
            {
                Toast.makeText(this, "Nice one!", Toast.LENGTH_SHORT).show();
                score += 10; //Add 10 points
                correctAnswer++;
                showQuestion(++index); //Next question
            }
            else
            {
                //If wrong answer is chosen
                Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                showQuestion(++index);
            }

            textScore.setText(String.format("%d", score));
        }
    }

    private void showQuestion(int i) {
        if(index < totalQuestion) {
            thisQuestion++;
            textQuestionNumber.setText(String.format("%d / %d", thisQuestion, totalQuestion));
            progressBar.setProgress(0);
            progressValue=0;

            //load question image and text
            Picasso.with(getBaseContext()).load(Common.questionList.get(index).getQuestionImage()).into(question_image);
            question_text.setText(Common.questionList.get(index).getQuestionText());

            btnA.setText(Common.questionList.get(index).getAnswerA());
            btnB.setText(Common.questionList.get(index).getAnswerB());
            btnC.setText(Common.questionList.get(index).getAnswerC());
            btnD.setText(Common.questionList.get(index).getAnswerD());

            mCountDown.start(); //start timer
        }

        else {
            Intent intent = new Intent(this, TestFinished.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE", score);
            dataSend.putInt("TOTAL", totalQuestion);
            dataSend.putInt("CORRECT", correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        totalQuestion = Common.questionList.size();

        mCountDown = new CountDownTimer(TIMEOUT, INTERVAL) {
            @Override
            public void onTick(long minisec) {
                progressBar.setProgress((progressValue));
                progressValue++;
            }

            @Override
            public void onFinish() {
                mCountDown.cancel();
                showQuestion(++index);
            }
        };
        showQuestion(index);
    }
}
