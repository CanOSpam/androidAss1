package com.example.tim.androidschoolproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        intent = getIntent();
        String conversionText = intent.getStringExtra("ItemSelected");
        String[] splitText = conversionText.split(" to ");

        int position = intent.getIntExtra("Position",0);
        double input = Double.parseDouble(intent.getStringExtra("Input"));
        double convertedValue = convert(input, position);



        TextView conversion = (TextView) findViewById(R.id.displayConversion);
        conversion.setText(input + " " + splitText[0]+ " converts to "
                + convertedValue + " " + splitText[splitText.length - 1]);


    }

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

}
