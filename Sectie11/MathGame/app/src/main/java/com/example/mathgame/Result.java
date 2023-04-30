package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView result;
    Button playAgain;
    Button exit;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.textViewResult);
        playAgain = findViewById(R.id.buttonPlayAgain);
        exit = findViewById(R.id.buttonExit);

        Intent retrieveData = getIntent();
        score = retrieveData.getIntExtra("score", 0);
        String userScore = String.valueOf(score);
        result.setText("Your score : " + userScore);

        playAgain.setOnClickListener(v -> {
            Intent intent = new Intent(Result.this, MainActivity.class);

            startActivity(intent);
            finish();
        });

        exit.setOnClickListener(v -> {
            finish();
        });
    }
}