package com.example.allisonbolen.calculatorandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import com.example.allisonbolen.calculatorandroid.UnitsConverter.VolumeUnits;
import com.example.allisonbolen.calculatorandroid.UnitsConverter.LengthUnits;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //internal vars
        final boolean modeVal = False; // false = length | true = volume

        // ui vars
        EditText fromTextBox = findViewById(R.id.fromEditText);
        final EditText toTextBox = findViewById(R.id.toEditText);
        TextView fromView = findViewById(R.id.fromUnitTextView);
        TextView toView = findViewById(R.id.toUnitTextView);
        Button calc = findViewById(R.id.button4);
        Button clear = findViewById(R.id.button5);
        Button mode = findViewById(R.id.button3);

        mode.setOnClickListener(v -> {
            modeVal = !modeVal;
        });

        calc.setOnClickListener(v -> {
            int fromVal = Integer.parseInt(fromTextBox.getText().toString());
            int toVal = Integer.parseInt(toTextBox.getText().toString());
            UnitsConverter.VolumeUnits

            // enum conversion

            VolumeUnits from = VolumeUnits.valueOf();

            if(modeVal){
                //volume conversion
                double lenVal = UnitsConverter.convert(VolumeUnits.Gallons,VolumeUnits.Liters,10.0)
                toTextBox.setText(lenVal.toString());
            }
        });

    }
}
