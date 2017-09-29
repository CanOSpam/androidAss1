package com.example.tim.androidschoolproject1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ConvertActivity extends AppCompatActivity {
    Intent intent;
    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        intent = getIntent();
        String conversionText = intent.getStringExtra("ItemSelected");
        String[] splitText = conversionText.split(" ");

        int position = intent.getIntExtra("Position",0);
        double input = Double.parseDouble(intent.getStringExtra("Input"));
        double convertedValue = convert(input, position);

        String outputString = createOutputString (splitText, input, convertedValue);

        TextView conversion = (TextView) findViewById(R.id.displayConversion);
        conversion.setText(outputString);


        Button backButt = (Button) findViewById(R.id.backbutton);
        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    /*
    @Override
    public void onResume() {

    }


    @Override
    public void onPause() {
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("selection", )
    }*/


    private double convert(double input, int position) {
        switch (position) {
            case 0:
                return input * 2.47105;
            case 1:
                return input * 0.404686;
            case 2:
                return input * 107639.10;
            case 3:
                return input * 9.2903e-6;
            case 4:
                return input * 10.7639;
            case 5:
                return input * 0.092903;
            default:
                return Double.NaN;
        }
    }

    private String createOutputString(String[]arr, double input, double convertedValue)
    {
        if (arr.length == 3) {
            return input + " " + arr[0] + " " + arr[1] + " "
                    + convertedValue + " " + arr[2];
        }
        else {
            return input + " " + arr[0] + " " + arr[1]
                    + " " + arr[2] + " "
                    + convertedValue + " " + arr[3] + " " + arr[4];
        }
    }

}
