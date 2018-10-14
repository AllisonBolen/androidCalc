package com.example.allisonbolen.calculatorandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);
        String[] fromSelection = {""};
        String[] toSelection = {""};


        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.putExtra("FROM_SEL", fromSelection );
                intent.putExtra("TO_SEL", toSelection);
                setResult(MainActivity.SELECTION,intent);
                finish();
            }
        });

        Spinner fromSpin = findViewById(R.id.fromSpinner);
        Spinner toSpin = findViewById(R.id.toSpinner);
        ArrayAdapter<CharSequence> fromAd;
        ArrayAdapter<CharSequence> toAd;
        if(MainActivity.modeVal[0]){ // volume
             fromAd = ArrayAdapter.createFromResource(this, R.array.volume, android.R.layout.simple_spinner_item);
             toAd = ArrayAdapter.createFromResource(this, R.array.volume, android.R.layout.simple_spinner_item);
        }else{
             fromAd = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
             toAd = ArrayAdapter.createFromResource(this, R.array.length, android.R.layout.simple_spinner_item);
        }
        // from
        fromAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpin.setAdapter(fromAd);
        fromSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromSelection[0] = fromAd.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // to
        toAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpin.setAdapter(fromAd);
        toSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toSelection[0] = toAd.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
