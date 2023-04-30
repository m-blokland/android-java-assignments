package com.example.informationbook.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.informationbook.R;
import com.example.informationbook.adapters.ViewPagerAdapterCountries;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        TabLayout tabLayoutCountries = findViewById(R.id.tabLayoutUnitedKingdom);
        ViewPager2 viewPagerCountries = findViewById(R.id.viewPagerUnitedKingdom);

        ViewPagerAdapterCountries adapter = new ViewPagerAdapterCountries(getSupportFragmentManager(), getLifecycle());

        viewPagerCountries.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayoutCountries,
                viewPagerCountries,
                true,
                true, (tab, position) -> {

            switch (position) {
                case 0:
                    tab.setText("United Kingdom");
                    break;
                case 1:
                    tab.setText("France");
                    break;
                case 2:
                    tab.setText("Italy");
            }
        });

        tabLayoutMediator.attach();
    }
}