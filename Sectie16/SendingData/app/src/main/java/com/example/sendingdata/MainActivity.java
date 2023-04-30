package com.example.sendingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, email, phone;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextTextName);
        email = findViewById(R.id.editTextTextEmail);
        phone = findViewById(R.id.editTextTextPhone);

        signup = findViewById(R.id.buttonSignup);

        signup.setOnClickListener(v -> {
            String userName = name.getText().toString();
            String userEmail = email.getText().toString();
            int userPhone = Integer.parseInt(phone.getText().toString());

            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("name", userName);
            i.putExtra("email", userEmail);
            i.putExtra("phone", userPhone);
            startActivity(i);
        });

    }
}