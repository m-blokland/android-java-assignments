package com.example.flagquizgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    int correct,wrong,empty;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        TextView textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        TextView textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);
        TextView textViewSuccess = findViewById(R.id.textViewSuccess);
        Button buttonAgain = findViewById(R.id.buttonAgain);
        Button buttonQuit = findViewById(R.id.buttonQuit);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        empty = getIntent().getIntExtra("empty",0);

        textViewTotalCorrect.setText("Total correct answer : " +  correct);
        textViewTotalWrong.setText("Total wrong answer : " + wrong);
        textViewTotalEmpty.setText("Total empty answer : " +empty);
        textViewSuccess.setText("Success rate : " + (correct * 10));

        buttonQuit.setOnClickListener(v -> {
            Intent newIntent = new Intent(Intent.ACTION_MAIN);
            newIntent.addCategory(Intent.CATEGORY_HOME);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newIntent);
            finish();
        });

        buttonAgain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}