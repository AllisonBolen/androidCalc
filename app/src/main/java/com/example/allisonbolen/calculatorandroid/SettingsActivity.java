package com.example.allisonbolen.calculatorandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
import android.content.*;

public class SettingsActivity extends AppCompatActivity {

    private String fromSelection = "Meters";
    private String toSelection = "Yards";
    private boolean[] mode = MainActivity.modeVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("from_spinner", fromSelection);
                intent.putExtra("to_spinner", toSelection);
                setResult(MainActivity.SELECTION, intent);
                finish();
            }
        });

        Spinner from_spinner = findViewById(R.id.from_spinner);
        ArrayAdapter<CharSequence> fromAdapter;
        if(mode[0]) {
            fromAdapter = ArrayAdapter.createFromResource
                    (this, R.array.volume, android.R.layout.simple_spinner_item);
        }
        else{
            fromAdapter = ArrayAdapter.createFromResource
                    (this, R.array.length, android.R.layout.simple_spinner_item);
        }
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from_spinner.setAdapter(fromAdapter);
        from_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fromSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner to_spinner = findViewById(R.id.to_spinner);

        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource
                (this, R.array.length, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to_spinner.setAdapter(fromAdapter);
        to_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
