package com.example.mychatapp;

import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ForgetActivity extends AppCompatActivity {

    private TextInputEditText editTextForget;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        editTextForget = findViewById(R.id.editTextForget);
        Button buttonForget = findViewById(R.id.buttonForget);

        buttonForget.setOnClickListener(v -> {

            String email = Objects.requireNonNull(editTextForget.getText()).toString();
            if (!email.equals("")) passwordReset(email);
        });

        auth = FirebaseAuth.getInstance();
    }

    public void passwordReset(String email) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if (task.isSuccessful())
                Toast.makeText(ForgetActivity.this,
                        "Please check your email.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(ForgetActivity.this,
                        "There is a problem.", Toast.LENGTH_SHORT).show();
        });
    }
}