package com.example.sendingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.textViewName);
        email = findViewById(R.id.textViewEmail);
        phone = findViewById(R.id.textViewPhone);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        String userEmail = i.getStringExtra("email");
        int userPhone = i.getIntExtra("phone", 0);

        name.setText("Hello " + userName);
        email.setText("Your email address is " + userEmail);
        phone.setText("Your phone number is " + userPhone);
    }
}