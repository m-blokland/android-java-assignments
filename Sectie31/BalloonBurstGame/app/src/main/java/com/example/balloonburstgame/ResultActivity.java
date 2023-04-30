package com.example.balloonburstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    int myScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewHighestScore = findViewById(R.id.textViewHighest);
        TextView textViewMyScore = findViewById(R.id.textViewMyScore);
        TextView textViewInfo = findViewById(R.id.textViewInfo);
        Button buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        Button buttonQuitGame = findViewById(R.id.buttonQuitGame);

        myScore = getIntent().getIntExtra("score", 0);
        textViewMyScore.setText("Your Score : " + myScore);

        sharedPreferences = this.getSharedPreferences("Score", Context.MODE_PRIVATE);
        int highestScore = sharedPreferences.getInt("highestScore", 0);

        if (myScore >= highestScore) {

            sharedPreferences.edit().putInt("highestScore", myScore).apply();

            textViewHighestScore.setText("Highest Score : " + myScore);
            textViewInfo.setText("Congratulations. The new high score. Do you want to get better scores?");
        } else {
            textViewHighestScore.setText("Highest Score : " + highestScore);

            if ((highestScore - myScore) > 10)
                textViewInfo.setText("You must get a little faster!");
            if ((highestScore - myScore) > 3 && (highestScore - myScore) <= 10)
                textViewInfo.setText("Good. How about getting a little faster?");
            if ((highestScore - myScore) <= 3)
                textViewInfo.setText("Excellent. If you get a little faster, you can reach the high score.");
        }

        buttonPlayAgain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        buttonQuitGame.setOnClickListener(v -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        });
    }
}