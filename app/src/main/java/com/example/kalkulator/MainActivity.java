package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String currentOperator = "";
    private double firstNumber = Double.NaN;
    private double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        findViewById(R.id.btn0).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn1).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn2).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn3).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn4).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn5).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn6).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn7).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn8).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn9).setOnClickListener(this::onNumberClick);

        findViewById(R.id.btnAdd).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnSub).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnMul).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnDiv).setOnClickListener(this::onOperatorClick);

        findViewById(R.id.btnC).setOnClickListener(this::onClearClick);
        findViewById(R.id.btnEqual).setOnClickListener(this::onEqualClick);
    }

    private void onNumberClick(View view) {
        Button button = (Button) view;
        display.append(button.getText().toString());
    }

    private void onOperatorClick(View view) {
        Button button = (Button) view;
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(display.getText().toString());
            firstNumber = calculate(firstNumber, secondNumber, currentOperator);
            display.setText(String.valueOf(firstNumber));
        } else {
            firstNumber = Double.parseDouble(display.getText().toString());
        }
        currentOperator = button.getText().toString();
        display.setText("");
    }

    private void onEqualClick(View view) {
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(display.getText().toString());
            display.setText(String.valueOf(calculate(firstNumber, secondNumber, currentOperator)));
            firstNumber = Double.NaN;
            currentOperator = "";
        }
    }

    private void onClearClick(View view) {
        display.setText("");
        firstNumber = Double.NaN;
        currentOperator = "";
    }

    private double calculate(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "x":
                return firstNumber * secondNumber;
            case ":":
                return firstNumber / secondNumber;
            default:
                return secondNumber;
        }
    }
}
