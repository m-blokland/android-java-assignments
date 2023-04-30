package com.example.mychatapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MyLoginActivity extends AppCompatActivity {

    private TextInputEditText editTextEmail, editTextPassword;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            Intent intent = new Intent(MyLoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignin = findViewById(R.id.buttonSignin);
        Button buttonSignup = findViewById(R.id.buttonSignup);
        TextView textViewForget = findViewById(R.id.textViewForget);

        auth = FirebaseAuth.getInstance();

        buttonSignin.setOnClickListener(v -> {
            String email = Objects.requireNonNull(editTextEmail.getText()).toString();
            String password = Objects.requireNonNull(editTextPassword.getText()).toString();

            if (!email.equals("") && !password.equals("")) signin(email, password);
            else
                Toast.makeText(MyLoginActivity.this,
                        "Please enter an email and password.",
                        Toast.LENGTH_SHORT).show();
        });

        buttonSignup.setOnClickListener(v -> {
            Intent intent = new Intent(MyLoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        textViewForget.setOnClickListener(v -> {
            Intent intent = new Intent(MyLoginActivity.this, ForgetActivity.class);
            startActivity(intent);
        });
    }

    public void signin(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {

            if (task.isSuccessful()) {
                Intent intent = new Intent(MyLoginActivity.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(
                        MyLoginActivity.this,
                        "Sign in is successful.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(
                        MyLoginActivity.this,
                        "Sign in is not successful.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}