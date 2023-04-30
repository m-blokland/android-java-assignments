package com.example.addlibraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.addlibraries.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        Information info = new Information("David", "Michael", "david@gmail.com");

        mainBinding.setData(info);
    }
}