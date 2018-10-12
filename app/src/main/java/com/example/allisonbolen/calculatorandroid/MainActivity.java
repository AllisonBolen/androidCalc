package com.example.allisonbolen.calculatorandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.view.Menu;
import android.view.MenuItem;

import com.example.allisonbolen.calculatorandroid.UnitsConverter.VolumeUnits;

import com.example.allisonbolen.calculatorandroid.UnitsConverter.LengthUnits;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.settings) {
            Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //internal vars
        boolean[] modeVal = {false}; // false = length | true = volume
        // ui vars
        EditText fromTextBox = findViewById(R.id.fromEditText);
        final EditText toTextBox = findViewById(R.id.toEditText);
        final TextView fromView = findViewById(R.id.fromUnitTextView);
        TextView toView = findViewById(R.id.toUnitTextView);
        Button calc = findViewById(R.id.button4);
        Button clear = findViewById(R.id.button5);
        Button mode = findViewById(R.id.button3);
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);



        clear.setOnClickListener(v -> {
            fromTextBox.setText("");
            toTextBox.setText("");
            mgr.hideSoftInputFromWindow(toTextBox.getWindowToken(), 0);
            mgr.hideSoftInputFromWindow(fromTextBox.getWindowToken(), 0);
        });

        // mode method
        mode.setOnClickListener(v -> {
            modeVal[0]= !modeVal[0];
            if(modeVal[0]){
                fromView.setText("Gallons");
                toView.setText("Liters");
            }else{
                fromView.setText("Meters");
                toView.setText("Yards");
            }
        });

        // calcualte method
        calc.setOnClickListener(v -> {
            double fromVal = Double.parseDouble(fromTextBox.getText().toString());

            if(modeVal[0]){
                //volume conversion = enum string conversion
                VolumeUnits from = VolumeUnits.valueOf(fromView.getText().toString());
                VolumeUnits to = VolumeUnits.valueOf(toView.getText().toString());
                // value conversion
                double lenVal = UnitsConverter.convert(fromVal, from, to);
                toTextBox.setText(String.valueOf(lenVal));
            }
            else{
                LengthUnits from = LengthUnits.valueOf(fromView.getText().toString());
                LengthUnits to = LengthUnits.valueOf(toView.getText().toString());

                double lenVal = UnitsConverter.convert(fromVal, from, to);
                toTextBox.setText(String.valueOf(lenVal));
            }
            mgr.hideSoftInputFromWindow(toTextBox.getWindowToken(), 0);
            mgr.hideSoftInputFromWindow(fromTextBox.getWindowToken(), 0);
        });

    }
}
