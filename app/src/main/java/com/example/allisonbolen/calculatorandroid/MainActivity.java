package com.example.allisonbolen.calculatorandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import android.view.Menu;
import android.view.MenuItem;
import android.content.*;


import com.example.allisonbolen.calculatorandroid.UnitsConverter.VolumeUnits;

import com.example.allisonbolen.calculatorandroid.UnitsConverter.LengthUnits;



public class MainActivity extends AppCompatActivity {

    public static final int SELECTION = 1;
    public static boolean[] modeVal = {false}; // false = length | true = volume
    private String fromSelection = "Meters";
    private String toSelection = "Yards";
    private String tempFromS = "Liters";
    private String tempToS = "Gallons";
//    private String[] length = {"Meters", "Yards", "Miles"};
//    private String[] volume = {"Liters", "Gallons", "Quarts"};

    // ui vars
    private EditText fromTextBox = findViewById(R.id.fromEditText);
    private final EditText toTextBox = findViewById(R.id.toEditText);
    private final TextView fromView = findViewById(R.id.fromUnitTextView);
    private TextView toView = findViewById(R.id.toUnitTextView);
    private Button calc = findViewById(R.id.button4);
    private Button clear = findViewById(R.id.button5);
    private Button mode = findViewById(R.id.button3);
    private InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


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
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivityForResult(intent, SELECTION);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == SELECTION) {
            fromSelection = data.getStringExtra("from_spinner");
            toSelection = data.getStringExtra("to_spinner");
            fromTextBox.setText(data.getStringExtra("from_spinner"));
            toTextBox.setText(data.getStringExtra("to_spinner"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                fromView.setText(tempFromS);
                toView.setText(tempToS);
            }else{
                fromView.setText(tempFromS);
                toView.setText(tempToS);
            }
            tempFromS = fromSelection;
            tempToS = toSelection;
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
