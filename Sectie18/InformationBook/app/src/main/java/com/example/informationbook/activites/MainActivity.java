package com.example.informationbook.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.informationbook.ModelClass;
import com.example.informationbook.R;
import com.example.informationbook.adapters.AdapterClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<ModelClass> arrayList = new ArrayList<>();

        ModelClass modelClass1 = new ModelClass("countries", "The Countries");
        ModelClass modelClass2 = new ModelClass("leaders", "The Leaders");
        ModelClass modelClass3 = new ModelClass("museums", "The Museums");
        ModelClass modelClass4 = new ModelClass("wonders", "Seven Wonders of the World");

        arrayList.add(modelClass1);
        arrayList.add(modelClass2);
        arrayList.add(modelClass3);
        arrayList.add(modelClass4);

        AdapterClass adapter = new AdapterClass(arrayList, this);
        recyclerView.setAdapter(adapter);
    }
}