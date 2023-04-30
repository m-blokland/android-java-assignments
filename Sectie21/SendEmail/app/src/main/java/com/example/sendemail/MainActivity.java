package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText address, message, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = findViewById(R.id.editTextAdress);
        message = findViewById(R.id.editTextMessage);
        subject = findViewById(R.id.editTextSubject);
        send = findViewById(R.id.buttonSend);

        send.setOnClickListener(v -> {
            String userAddress = address.getText().toString();
            String userMessage = message.getText().toString();
            String userSubject = subject.getText().toString();

            sendEmail(userAddress, userMessage, userSubject);
        });
    }

    public void sendEmail(String userAddress, String userSubject, String userMessage) {
        String[] emailAdress = {userAddress};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAdress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, userSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, userMessage);

        startActivity(Intent.createChooser(emailIntent, "email send"));
    }
}