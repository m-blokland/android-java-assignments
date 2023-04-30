package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addition;
    Button substraction;
    Button multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addition = findViewById(R.id.addition);
        substraction = findViewById(R.id.substraction);
        multiplication = findViewById(R.id.multiplication);

        addition.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Game.class);
            intent.putExtra("gameType", "+");
            startActivity(intent);
            finish();
        });

        substraction.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Game.class);
            intent.putExtra("gameType", "-");
            startActivity(intent);
            finish();
        });

        multiplication.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Game.class);
            intent.putExtra("gameType", "*");
            startActivity(intent);
            finish();
        });
    }
}