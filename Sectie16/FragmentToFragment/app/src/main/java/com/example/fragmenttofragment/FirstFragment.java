package com.example.fragmenttofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    EditText name;
    Button send;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        name = view.findViewById(R.id.editTextName);
        send = view.findViewById(R.id.buttonSend);

        send.setOnClickListener(v -> {
            String userName = name.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("username", userName);

            if (getActivity() != null) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame, secondFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}

