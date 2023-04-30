package com.example.dialogfragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MyDialogFragment extends DialogFragment {

    Button ok, cancel;
    EditText enter;

    public MyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_dialog, container, false);

        enter = view.findViewById(R.id.editTextEnter);
        ok = view.findViewById(R.id.buttonOk);
        cancel = view.findViewById(R.id.buttonCancel);

        ok.setOnClickListener(v -> {
            String userEnter = enter.getText().toString();
            ((MainActivity)getActivity()).result.setText(userEnter);
            Objects.requireNonNull(getDialog()).dismiss();
        });

        cancel.setOnClickListener(v -> {
            getDialog().dismiss();
        });

        return view;

    }
}