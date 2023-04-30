package com.example.takenote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText title;
    EditText description;
    Button cancel;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.editTextTitle);
        description = findViewById(R.id.editTextNote);
        cancel = findViewById(R.id.buttonCancel);
        save = findViewById(R.id.buttonSave);

        cancel.setOnClickListener(v -> {
            Toast.makeText(
                    getApplicationContext(),
                    "Nothing Saved",
                    Toast.LENGTH_SHORT).show();
            finish();
        });

        save.setOnClickListener(v -> {
            saveNote();
        });
    }

    public void saveNote() {
        String noteTitle = title.getText().toString();
        String noteDescription = description.getText().toString();

        Intent i = new Intent();
        i.putExtra("noteTitle", noteTitle);
        i.putExtra("noteDescription", noteDescription);
        setResult(RESULT_OK, i);
        finish();
    }
}