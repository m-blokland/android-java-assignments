package com.example.informationbook.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.informationbook.fragments.FragmentFrance;
import com.example.informationbook.fragments.FragmentItaly;
import com.example.informationbook.fragments.FragmentUnitedKingdom;

public class ViewPagerAdapterCountries extends FragmentStateAdapter {

    public ViewPagerAdapterCountries(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        switch (position)
        {
            case 0:
                fragment = FragmentUnitedKingdom.newInstance();
                break;
            case 1:
                fragment = FragmentFrance.newInstance();
                break;
            case 2:
                fragment = FragmentItaly.newInstance();
                break;
            default:
                return null;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
