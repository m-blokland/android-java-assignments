package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    CheckBox ja;
    CheckBox nee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);
        ja = findViewById(R.id.checkboxJa);
        nee = findViewById(R.id.checkboxNee);

        ja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ja.isChecked())
                {
                    result.setText("Ja");
                    nee.setChecked(false);
                }
                else
                {
                    result.setText("Vindt u Android Studio leuk?");
                }

            }
        });

        nee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nee.isChecked())
                {
                    result.setText("Nee");
                    ja.setChecked(false);
                }
                else
                {
                    result.setText("Vindt u Android Studio leuk?");
                }

            }
        });

    }
}