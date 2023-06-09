package com.example.quizgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password extends AppCompatActivity {

    EditText email;
    Button button;
    ProgressBar progressBar;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.editTextPasswordEmail);
        button = findViewById(R.id.buttonPasswordContinue);
        progressBar = findViewById(R.id.progressBarPasswordForgot);

        button.setOnClickListener(v -> {
            String userMail = email.getText().toString();
            resetPassword(userMail);
        });
    }

    public void resetPassword(String userMail) {
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(userMail)
                .addOnCompleteListener(this, task -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(Forgot_Password.this,
                                "We sent you an email to reset your password!",
                                Toast.LENGTH_LONG).show();

                        button.setClickable(false);

                        progressBar.setVisibility(View.INVISIBLE);

                        finish();
                    } else {
                        Toast.makeText(Forgot_Password.this,
                                "Sorry, There is a problem, try again later...",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}
