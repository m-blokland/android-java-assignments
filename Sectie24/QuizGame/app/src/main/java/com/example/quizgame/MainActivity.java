package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView signOut;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signOut = findViewById(R.id.textViewSignOut);
        signOut.setOnClickListener(v -> {
            auth.signOut();
            Intent i = new Intent(MainActivity.this, Login_Page.class);
            startActivity(i);
            finish();
        });

        start = findViewById(R.id.buttonStart);
        start.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, Quiz_Page.class);
            startActivity(i);
        });
    }
}
