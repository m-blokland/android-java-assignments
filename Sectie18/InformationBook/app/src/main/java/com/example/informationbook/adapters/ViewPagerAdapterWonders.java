package com.example.informationbook.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.informationbook.fragments.FragmentTajMahal;

public class ViewPagerAdapterWonders extends FragmentStateAdapter {

    public ViewPagerAdapterWonders(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        if (position == 0) {
            fragment = FragmentTajMahal.newInstance();
            return fragment;
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
