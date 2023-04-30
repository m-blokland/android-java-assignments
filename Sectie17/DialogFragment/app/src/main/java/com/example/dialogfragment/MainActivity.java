package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button show;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.buttonShow);
        result = findViewById(R.id.textViewResult);

        show.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            MyDialogFragment myDialogFragment = new MyDialogFragment();

            myDialogFragment.show(fragmentManager, "MyDialogFragment");
        });
    }
}