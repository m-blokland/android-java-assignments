package com.example.firebaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends AppCompatActivity {

    EditText resetEmail;
    Button reset;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        resetEmail = findViewById(R.id.editTextemailForget);
        reset = findViewById(R.id.reset);

        reset.setOnClickListener(v -> {

            String userEmail = resetEmail.getText().toString();

            auth.sendPasswordResetEmail(userEmail)
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {
                            Toast.makeText(ForgetActivity.this,
                                    "We sent an email to reset your password",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
            finish();
        });
    }
}