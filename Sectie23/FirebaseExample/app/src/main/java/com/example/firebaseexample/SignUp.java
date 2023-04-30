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

public class SignUp extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button enter;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mail = findViewById(R.id.editTextEmailSignup);
        password = findViewById(R.id.editTextPasswordSignup);
        enter = findViewById(R.id.button2);

        enter.setOnClickListener(v -> {

            String userEmail = mail.getText().toString();
            String userPassword = password.getText().toString();

            signUpFirebase(userEmail, userPassword);
        });
    }

    public void signUpFirebase(String userEmail, String userPassword) {

        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(SignUp.this, "Your account has been created",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignUp.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(SignUp.this, "There is a problem",
                                Toast.LENGTH_SHORT).show();
                    }

                });
    }
}