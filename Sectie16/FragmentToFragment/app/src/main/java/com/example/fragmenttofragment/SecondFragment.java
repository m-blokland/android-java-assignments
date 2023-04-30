package com.example.fragmenttofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    TextView name;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        name = view.findViewById(R.id.textViewName);

        Bundle bundle = getArguments();

        if (bundle != null) {
            String userName = bundle.getString("username");
            name.setText(userName);
        }

        return view;
    }
}