package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);

        String imageUrl = "https://w7.pngwing.com/pngs/303/413/png-transparent-illustration-of-palm-tree-palm-trees-palm-leaf-plant-stem-palm-tree.png";

        Picasso.get().load(imageUrl).into(image);
    }
}