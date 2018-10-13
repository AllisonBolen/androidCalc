package com.example.allisonbolen.calculatorandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.allisonbolen.calculatorandroid.UnitsConverter.LengthUnits;
import com.example.allisonbolen.calculatorandroid.UnitsConverter.VolumeUnits;
import android.support.design.widget.Snackbar;


public class MainActivity extends AppCompatActivity {


    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;// "true" means the menu should be visible
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
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
            double fromVal = -1;
            double toVal = -1;
            // test for blank input
            if(!fromTextBox.getText().toString().equals("")){
                fromVal = Double.parseDouble(fromTextBox.getText().toString());
            }
            if(!toTextBox.getText().toString().equals("")){
                toVal = Double.parseDouble(fromTextBox.getText().toString());
            }

            System.out.print("From"+fromVal+", to"+toVal);

            if(fromVal != -1 && toVal !=-1){// if htere are values in both fields you need to clear one
                String error = "Clear the to field. I dont want to overwrite!!";
                EditText view = findViewById(R.id.fromEditText);
                Snackbar.make(view, error,  Snackbar.LENGTH_LONG).show();
            }
            else if(fromVal != -1) { // this is converting from value to to
                if (modeVal[0]) {
                    //volume conversion = enum string conversion
                    VolumeUnits from = VolumeUnits.valueOf(fromView.getText().toString());
                    VolumeUnits to = VolumeUnits.valueOf(toView.getText().toString());
                    // value conversion
                    double lenVal = UnitsConverter.convert(fromVal, from, to);
                    toTextBox.setText(String.valueOf(lenVal));
                } else {
                    LengthUnits from = LengthUnits.valueOf(fromView.getText().toString());
                    LengthUnits to = LengthUnits.valueOf(toView.getText().toString());

                    double lenVal = UnitsConverter.convert(fromVal, from, to);
                    toTextBox.setText(String.valueOf(lenVal));
                }

            }
            mgr.hideSoftInputFromWindow(toTextBox.getWindowToken(), 0);
            mgr.hideSoftInputFromWindow(fromTextBox.getWindowToken(), 0);
        });

    }
}