package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Page extends AppCompatActivity {

    EditText mail;
    EditText password;

    Button SignIn;

    TextView signUp;
    TextView forgotPassword;

    ProgressBar progressBarSignin;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mail = findViewById(R.id.editTextLoginEmail);
        password = findViewById(R.id.editTextLoginPassword);
        SignIn = findViewById(R.id.buttonLoginSignin);
        signUp = findViewById(R.id.textViewLoginSignUp);
        forgotPassword = findViewById(R.id.textViewLoginForgotPassword);
        progressBarSignin = findViewById(R.id.progressBarSignin);

        SignIn.setOnClickListener(v -> {
            String userMail = mail.getText().toString();
            String userPassword = password.getText().toString();
            signInWithFirebase(userMail, userPassword);
        });

        signUp.setOnClickListener(v -> {
            Intent i = new Intent(Login_Page.this, sign_up_page.class);
            startActivity(i);
        });

        forgotPassword.setOnClickListener(v -> {
            Intent i = new Intent(Login_Page.this, Forgot_Password.class);
            startActivity(i);
        });
    }

    public void signInWithFirebase(String userMail, String userPassword) {
        progressBarSignin.setVisibility(View.VISIBLE);
        SignIn.setClickable(false);
        auth.signInWithEmailAndPassword(userMail, userPassword)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Intent i = new Intent(Login_Page.this, MainActivity.class);
                        startActivity(i);
                        finish();
                        progressBarSignin.setVisibility(View.INVISIBLE);
                        Toast.makeText(Login_Page.this, "Sign in is Successful",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Login_Page.this, "Sign in is not Successful",
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            Intent i = new Intent(Login_Page.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
