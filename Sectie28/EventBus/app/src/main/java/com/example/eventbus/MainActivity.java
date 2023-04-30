package com.example.eventbus;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.editTextMessage);
        send = findViewById(R.id.buttonSend);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MyFragment fr = new MyFragment();
        ft.add(R.id.frameLayout, fr);
        ft.commit();

        send.setOnClickListener(v -> {
            String userMessage = message.getText().toString();

            EventBus.getDefault().post(new Messages(userMessage));
        });
    }
}