package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;

import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    MaterialButton c,one,two,three,four,five,six,seven,eight,nine,zero;
    MaterialButton open_bracket,close_bracket,div,mul,add,sub,equal,dot,per;
    private StringBuilder inputStringBuilder = new StringBuilder();
    TextView InputText, inputOut;
    String data;
    private double result = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputText = findViewById(R.id.inputTxt);
        inputOut = findViewById(R.id.textView);


        c = findViewById(R.id.button_c);
        one = findViewById(R.id.button_one);
        two = findViewById(R.id.button_two);
        three = findViewById(R.id.button_three);
        four = findViewById(R.id.button_four);
        five = findViewById(R.id.button_five);
        six = findViewById(R.id.button_six);
        seven = findViewById(R.id.button_seven);
        eight = findViewById(R.id.button_eight);
        nine = findViewById(R.id.button_nine);
        zero = findViewById(R.id.button_zero);


        open_bracket = findViewById(R.id.button_open_bracket);
        close_bracket = findViewById(R.id.button_close_bracket);
        div = findViewById(R.id.button_divide);
        mul = findViewById(R.id.button_multiply);
        add = findViewById(R.id.button_add);
        sub = findViewById(R.id.button_subtract);
        per = findViewById(R.id.button_percentage);
        equal = findViewById(R.id.button_equal);
        dot = findViewById(R.id.button_dot);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(" ");
                // Toast.makeText(MainActivity.this, "working c fine", Toast.LENGTH_SHORT).show();
                inputOut.setText(" ");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"-");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"/");
            }
        });

        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"%");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+".");
            }
        });

        open_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"(");
            }
        });

        close_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+")");
            }
        });





        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                InputText.setText(data+"9");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = InputText.getText().toString();
                data = data.replaceAll("×","*");
                data = data.replaceAll("÷","/");
                data = data.replaceAll("%", "/100");
                inputOut.setText(""+calculateResult());

            }
        });
    }
    private double calculateResult() {
        data = InputText.getText().toString();


        try {
            // Convert the expression into a character array
            char[] chars = data.toCharArray();

            // Initialize two stacks, one for numbers and one for operators
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                // If the character is a digit, it's part of a number
                if (Character.isDigit(c) || c == '.') {
                    StringBuilder sb = new StringBuilder();
                    while (i < chars.length && (Character.isDigit(chars[i]) || chars[i] == '.')) {
                        sb.append(chars[i]);
                        i++;
                    }
                    i--; // Decrement i to account for the last increment
                    double number = Double.parseDouble(sb.toString());
                    numbers.push(number);
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (operators.peek() != '(') {
                        double result = applyOperator(operators.pop(), numbers.pop(), numbers.pop());
                        numbers.push(result);
                    }
                    operators.pop(); // Remove the '(' from the operators stack
                } else if (isOperator(c)) {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        double result = applyOperator(operators.pop(), numbers.pop(), numbers.pop());
                        numbers.push(result);
                    }
                    operators.push(c);
                }
            }

            // Perform the remaining calculations
            while (!operators.isEmpty()) {
                double result = applyOperator(operators.pop(), numbers.pop(), numbers.pop());
                numbers.push(result);
            }

            // The final result will be at the top of the numbers stack
            return numbers.pop();
        } catch (Exception e) {
            // Handle any exceptions that occur during parsing or evaluation
            e.printStackTrace();
            return Double.NaN;
        }


    }
    // Helper function to apply an operator to two numbers
    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0; // Default case, shouldn't happen if the expression is valid
    }

    // Helper function to check if a character is a valid operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Helper function to check operator precedence
    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 != '(' && op2 != ')') && (op1 == '*' || op1 == '/') || (op1 == '+' || op1 == '-');
    }
}


