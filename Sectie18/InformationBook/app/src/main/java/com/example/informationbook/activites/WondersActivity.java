package com.example.informationbook.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.informationbook.R;
import com.example.informationbook.adapters.ViewPagerAdapterWonders;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WondersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        TabLayout tabLayoutWonders = findViewById(R.id.tabLayoutWonders);
        ViewPager2 viewPagerWonders = findViewById(R.id.viewPagerWonders);

        ViewPagerAdapterWonders adapter =
                new ViewPagerAdapterWonders(getSupportFragmentManager(),
                        getLifecycle());

        viewPagerWonders.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator =
                new TabLayoutMediator(
                        tabLayoutWonders,
                        viewPagerWonders,
                        true,
                        true, (tab, position) -> {

                    if (position == 0) {
                        tab.setText("Taj Mahal");
                    }
                });

        tabLayoutMediator.attach();
    }
}