package com.example.fragmentoperations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button replace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FirstFragment FirstFragment = new FirstFragment();
        fragmentTransaction.add(R.id.frame, FirstFragment);
        fragmentTransaction.commit();

        replace = findViewById(R.id.buttonReplace);

        replace.setOnClickListener(v -> {
            FragmentManager fragmentManager1 = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();

            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction1.replace(R.id.frame, secondFragment);

            fragmentTransaction1.addToBackStack(null);

            fragmentTransaction1.commit();
        });
    }
}