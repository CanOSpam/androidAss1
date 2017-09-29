package com.example.tim.androidschoolproject1;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String itemSelected;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button) findViewById(R.id.buttonSubmit);
        spinner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelected = (String) spinner.getSelectedItem();
                int spinnerPos = spinner.getSelectedItemPosition();
                EditText  textBox = (EditText) findViewById(R.id.convert);
                String input = textBox.getText().toString();

                Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
                intent.putExtra("ItemSelected", itemSelected);
                intent.putExtra("Position", spinnerPos);
                intent.putExtra("Input", input);
                startActivity(intent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        itemSelected = (String) parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }


}