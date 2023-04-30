package com.example.textviewbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    TextView text;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        text = findViewById(R.id.textView);

        constraintLayout = findViewById(R.id.constraintLayout);

        button1.setOnClickListener(v -> {
            Snackbar.make(constraintLayout,
                    "This is a Snackbar message",
                    Snackbar.LENGTH_LONG).show();
        });

        button2.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "This is a Toast message",
                    Toast.LENGTH_LONG).show();
        });

        button3.setOnClickListener(v -> {
            showDialogMessage();
        });


    }

    private void showDialogMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete").setMessage("Do you want to delete text?")
                .setNegativeButton("No", (dialogInterface, i) ->
                        dialogInterface.cancel())
                .setPositiveButton("Yes", (dialogInterface, i) ->
                        text.setVisibility(View.INVISIBLE)).show();
        alertDialog.create();
    }
}