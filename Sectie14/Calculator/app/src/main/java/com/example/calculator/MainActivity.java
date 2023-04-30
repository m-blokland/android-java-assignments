package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button btnDel;

    private TextView textViewResult, textViewHistory;

    private String number = null;
    double firstNumber = 0;
    double lastNumber = 0;
    String status = null;
    boolean operator = false;
    DecimalFormat myFormatter = new DecimalFormat("######.######");
    String history, currentResult;

    boolean dot = true;

    boolean btnACcontrol = true;
    boolean btnEqualsControl = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnMulti = findViewById(R.id.btnMulti);

        Button btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnEquals = findViewById(R.id.btnEquals);

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        btn0.setOnClickListener(v -> numberClick("0"));
        btn1.setOnClickListener(v -> numberClick("1"));
        btn2.setOnClickListener(v -> numberClick("2"));
        btn3.setOnClickListener(v -> numberClick("3"));
        btn4.setOnClickListener(v -> numberClick("4"));
        btn5.setOnClickListener(v -> numberClick("5"));
        btn6.setOnClickListener(v -> numberClick("6"));
        btn7.setOnClickListener(v -> numberClick("7"));
        btn8.setOnClickListener(v -> numberClick("8"));
        btn9.setOnClickListener(v -> numberClick("9"));

        btnAC.setOnClickListener(v -> {

            number = null;
            status = null;
            textViewResult.setText("0");
            textViewHistory.setText("");
            firstNumber = 0;
            lastNumber = 0;
            dot = true;
            btnACcontrol = true;

        });

        btnDel.setOnClickListener(v -> {

            if (btnACcontrol) textViewResult.setText("0");
            else {
                if (number != null) {
                    number = number.substring(0, number.length() - 1);

                    if (number.length() == 0) {
                        btnDel.setClickable(false);
                    } else dot = !number.contains(".");

                    textViewResult.setText(number);
                }
            }
        });

        btnPlus.setOnClickListener(v -> {

            history = textViewHistory.getText().toString();
            currentResult = textViewResult.getText().toString();
            textViewHistory.setText(history + "+");

            if (operator) {
                if (Objects.equals(status, "multiplacition")) {
                    multiply();
                } else if (Objects.equals(status, "division")) {
                    divide();
                } else if (Objects.equals(status, "subtraction")) {
                    minus();
                } else {
                    plus();
                }
            }

            status = "sum";
            operator = false;
            number = null;

        });

        btnMinus.setOnClickListener(v -> {

            history = textViewHistory.getText().toString();
            currentResult = textViewResult.getText().toString();
            textViewHistory.setText(history + "-");

            if (operator) {
                if (Objects.equals(status, "multiplacition")) {
                    multiply();
                } else if (Objects.equals(status, "division")) {
                    divide();
                } else if (Objects.equals(status, "sum")) {
                    plus();
                } else {
                    minus();
                }
            }

            status = "subtraction";
            operator = false;
            number = null;

        });

        btnMulti.setOnClickListener(v -> {

            history = textViewHistory.getText().toString();
            currentResult = textViewResult.getText().toString();
            textViewHistory.setText(history + "*");

            if (operator) {
                if (Objects.equals(status, "sum")) {
                    plus();
                } else if (Objects.equals(status, "division")) {
                    divide();
                } else if (Objects.equals(status, "subtraction")) {
                    minus();
                } else {
                    multiply();
                }

            }

            status = "multiplacition";
            operator = false;
            number = null;

        });

        btnDivide.setOnClickListener(v -> {

            history = textViewHistory.getText().toString();
            currentResult = textViewResult.getText().toString();
            textViewHistory.setText(history + "/");

            if (operator) {
                if (Objects.equals(status, "multiplacition")) {
                    multiply();
                } else if (Objects.equals(status, "sum")) {
                    plus();
                } else if (Objects.equals(status, "subtraction")) {
                    minus();
                } else {
                    divide();
                }
            }

            status = "division";
            operator = false;
            number = null;

        });

        btnEquals.setOnClickListener(v -> {

            if (operator) {
                if (Objects.equals(status, "sum")) plus();
                else if (Objects.equals(status, "subtraction")) minus();
                else if (Objects.equals(status, "multiplacition")) multiply();
                else if (Objects.equals(status, "division")) divide();
                else firstNumber = Double.parseDouble(textViewResult.getText().toString());
            }

            operator = false;
            btnEqualsControl = true;
        });

        btnDot.setOnClickListener(v -> {

            if (dot) {

                if (number == null) {
                    number = "0.";
                } else {
                    number = number + ".";
                }

            }

            textViewResult.setText(number);
            dot = false;
        });
    }

    public void numberClick(String view) {
        history = textViewHistory.getText().toString();
        textViewHistory.setText(history + view);

        if (number == null) number = view;
        else if (btnEqualsControl) {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        } else number = number + view;

        textViewResult.setText(number);
        operator = true;
        btnACcontrol = false;
        btnDel.setClickable(true);
        btnEqualsControl = false;
    }

    public void plus() {
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }

    public void minus() {
        if (firstNumber == 0) {
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }

    public void multiply() {
        if (firstNumber == 0) firstNumber = 1;

        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber * lastNumber;

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }

    public void divide() {
        if (firstNumber == 0) {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }
}