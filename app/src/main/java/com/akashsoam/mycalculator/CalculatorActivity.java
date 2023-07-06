package com.akashsoam.mycalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    TextView txtCalculations, txtResults;
//    ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnMul, btnAdd, btnDiv, btnSub;
//    ImageView btnEqual;
//    Button btnClear;

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    //    Instance variables
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        currentNumber = "";
        calculationsResult = 0;

        findViewById(R.id.btnEqual).setOnClickListener(v -> {

        });

        findViewById(R.id.btn7).setOnClickListener(v -> {
            numberIsTapped(7);
        });
        findViewById(R.id.btn8).setOnClickListener(v -> {
            numberIsTapped(8);
        });
        findViewById(R.id.btn9).setOnClickListener(v -> {
            numberIsTapped(9);
        });
        findViewById(R.id.btn4).setOnClickListener(v -> {
            numberIsTapped(4);
        });
        findViewById(R.id.btn5).setOnClickListener(v -> {
            numberIsTapped(5);
        });
        findViewById(R.id.btn6).setOnClickListener(v -> {
            numberIsTapped(6);
        });
        findViewById(R.id.btn1).setOnClickListener(v -> {
            numberIsTapped(1);
        });
        findViewById(R.id.btn2).setOnClickListener(v -> {
            numberIsTapped(2);
        });
        findViewById(R.id.btn3).setOnClickListener(v -> {
            numberIsTapped(3);
        });
        findViewById(R.id.btnClear).setOnClickListener(v -> {

        });
        findViewById(R.id.btn0).setOnClickListener(v -> {
            numberIsTapped(0);
        });
        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            operatorIsTapped(OPERATOR.PLUS);
        });
        findViewById(R.id.btnSub).setOnClickListener(v -> {
            operatorIsTapped(OPERATOR.SUBTRACT);
        });
        findViewById(R.id.btnMul).setOnClickListener(v -> {
            operatorIsTapped(OPERATOR.MULTIPLY);
        });
        findViewById(R.id.btnDiv).setOnClickListener(v -> {
            operatorIsTapped(OPERATOR.DIVIDE);
        });
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if (currentOperator != null && currentNumber != "") {
            stringNumberAtRight = currentNumber;
            currentNumber = "";

            switch (currentOperator) {
                case PLUS:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                    break;
                case MULTIPLY:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);

                    break;
                case SUBTRACT:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);

                    break;
                case DIVIDE:
                    calculationsResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);

                    break;
//                case EQUAL:
//                    break;
            }
            stringNumberAtLeft = String.valueOf(calculationsResult);
            txtResults.setText(stringNumberAtLeft);

        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }
}