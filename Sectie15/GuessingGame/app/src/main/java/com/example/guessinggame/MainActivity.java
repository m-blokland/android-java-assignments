package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private RadioButton radio2, radio3, radio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.buttonStart);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);

        buttonStart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Game.class);

            if (!radio2.isChecked() && !radio3.isChecked() && !radio4.isChecked()) {
                Snackbar.make(v, "Please select a number of digits", Snackbar.LENGTH_LONG).show();
            } else {
                if (radio2.isChecked()) intent.putExtra("two", true);
                if (radio3.isChecked()) intent.putExtra("three", true);
                if (radio4.isChecked()) intent.putExtra("four", true);

                startActivity(intent);
            }
        });
    }
}