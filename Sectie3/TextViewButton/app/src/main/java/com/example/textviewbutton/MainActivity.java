package com.example.textviewbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textExample);
        button = findViewById(R.id.domagic);
        buttonReset = findViewById(R.id.buttonReset);

        text.setTextColor(Color.BLACK);
        text.setText("This is an example");

        text.setOnClickListener(v -> {
            text.setTextColor(Color.WHITE);
            text.setBackgroundColor(Color.BLACK);
        });

        buttonReset.setOnClickListener(v -> {
            text.setText("This is an example");
        });

        button.setOnClickListener(v -> {
                text.setText("I have done my magic");
        });
    }
}