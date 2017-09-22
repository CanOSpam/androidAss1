package com.example.tim.androidschoolproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        intent = getIntent();
        String conversionText = intent.getStringExtra("itemSelected");

        TextView conversion = (TextView) findViewById(R.id.displayConversion);
        conversion.setText(conversionText);


    }

}
