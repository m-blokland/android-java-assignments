package com.example.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button signIn;
    Button signUp;
    Button forgotPassword;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        signIn = findViewById(R.id.buttonSignIn);
        signUp = findViewById(R.id.buttonSignUp);
        forgotPassword = findViewById(R.id.forgotpassword);

        forgotPassword.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, ForgetActivity.class);
            startActivity(i);
        });

        signIn.setOnClickListener(v -> {
            String userMail = mail.getText().toString();
            String userPassword = password.getText().toString();

            signInFirebase(userMail, userPassword);
        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUp.class);
            startActivity(intent);
        });
    }

    public void signInFirebase(String userMail, String userPassword) {
        auth.signInWithEmailAndPassword(userMail, userPassword)
                .addOnCompleteListener(this, (OnCompleteListener<AuthResult>) task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information

                        Intent intent = new Intent(LoginActivity.this, MainMenu.class);
                        startActivity(intent);
                        finish();

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Mail or Password is not correct",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = auth.getCurrentUser();

        if (user != null) {
            Intent i = new Intent(LoginActivity.this, MainMenu.class);
            startActivity(i);
            finish();
        }
    }
}