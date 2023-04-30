package com.example.quizgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class sign_up_page extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button signUp;
    ProgressBar progressBar;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        mail = findViewById(R.id.editTextSignupMail);
        password = findViewById(R.id.editTextSignupPassword);
        signUp = findViewById(R.id.buttonSignupSign);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        signUp.setOnClickListener(v -> {
            signUp.setClickable(false);
            String userEmail = mail.getText().toString();
            String userPassword = password.getText().toString();
            signUpFirebase(userEmail, userPassword);
        });
    }

    public void signUpFirebase(String userEmail, String userPassword) {
        progressBar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, task -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(
                                sign_up_page.this,
                                "Your Account is Created",
                                Toast.LENGTH_LONG).show();

                        finish();

                        progressBar.setVisibility(View.INVISIBLE);
                    } else {
                        Toast.makeText(
                                sign_up_page.this,
                                "There is a problem! Please try again later.",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}
