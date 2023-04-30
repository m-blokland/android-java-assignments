package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private ArrayList<String>countryNameList = new ArrayList<>();
    private ArrayList<String>detailsList = new ArrayList<>();
    private ArrayList<Integer>imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        countryNameList.add("United Kingdom");
        countryNameList.add("Germany");
        countryNameList.add("USA");

        detailsList.add("This is the United Kingdom Flag");
        detailsList.add("This is the Germany Flag");
        detailsList.add("This is the USA Flag");

        imageList.add(R.drawable.unitedkingdom);
        imageList.add(R.drawable.germany);
        imageList.add(R.drawable.usa);

        adapter = new RecyclerAdapter(countryNameList,detailsList,imageList,MainActivity.this);
        recyclerView.setAdapter(adapter);

    }
}