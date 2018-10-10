package com.example.allisonbolen.calculatorandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fromTextBox = findViewById(R.id.fromEditText);
        EditText toTextBox = findViewById(R.id.toEditText);
        TextView fromView = findViewById(R.id.fromUnitTextView);
        TextView toView = findViewById(R.id.toUnitTextView);
        Button calc = findViewById(R.id.button4);
        Button clear = findViewById(R.id.button5);
        Button mode = findViewById(R.id.button3);

        calc.setOnClickListener(v -> {
            int from = Integer.parseInt(fromTextBox.getText().toString());
            int to = Integer.parseInt(toTextBox.getText().toString());

        });

    }
}
