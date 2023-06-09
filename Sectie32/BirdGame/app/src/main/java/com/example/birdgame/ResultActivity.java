package com.example.birdgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewHighestScore = findViewById(R.id.textViewHighestScore);
        TextView textViewMyScore = findViewById(R.id.textViewMyScore);
        TextView textViewResultInfo = findViewById(R.id.textViewResultInfo);
        Button buttonAgain = findViewById(R.id.buttonAgain);

        int score = getIntent().getIntExtra("score", 0);
        textViewMyScore.setText("Your score : " + score);

        SharedPreferences sharedPreferences = this.getSharedPreferences("Score", Context.MODE_PRIVATE);
        int highestScore = sharedPreferences.getInt("highestScore", 0);

        if (score >= 200) {
            textViewResultInfo.setText("You won the Game");
            textViewHighestScore.setText("Highest Score : " + score);
            sharedPreferences.edit().putInt("highestScore", score).apply();
        } else if (score >= highestScore) {
            textViewResultInfo.setText("Sorry, you lost the game.");
            textViewHighestScore.setText("Highest Score : " + score);
            sharedPreferences.edit().putInt("highestScore", score).apply();
        } else {
            textViewResultInfo.setText("Sorry, you lost the game.");
            textViewHighestScore.setText("Highest Score : " + highestScore);
        }

        buttonAgain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
        builder.setTitle("Help The Innocent Bird");
        builder.setMessage("Are you sure you want to quit game?");

        builder.setCancelable(false);

        builder.setNegativeButton("Quit game", (dialog, which) -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        });

        builder.setPositiveButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.create().show();
    }
}