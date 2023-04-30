package com.example.multilanguagesupport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.button3);

        show.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), R.string.toast, Toast.LENGTH_LONG).show();
        });
    }
}