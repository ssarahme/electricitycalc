package com.example.electricitycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.InputFilter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etKwh;
    EditText etRebate;
    Button btnCalculate;
    Button btnAboutMe;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKwh = (EditText) findViewById(R.id.editTextNumberDecimal);
        etRebate = (EditText) findViewById(R.id.editTextNumberDecimal2);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnAboutMe = (Button) findViewById(R.id.btnAboutMe);
        tvOutput = (TextView) findViewById(R.id.tvOutput);

        etRebate.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "5" )}) ;

        btnCalculate.setOnClickListener(this);

        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutMe();
            }
        });
    }

    public void openAboutMe() {
        Intent intent = new Intent(this, aboutme.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculate:

                if (etKwh.length()==0) {
                    etKwh.setError("Enter electricity unit");
                } else if (etRebate.length()==0) {
                    etRebate.setError("Enter a number from 0 to 5");
                } else {
                    double kWh = Double.parseDouble(etKwh.getText().toString());
                    double rebateA = Double.parseDouble(etRebate.getText().toString());
                    double rebate = rebateA / 100;
                    double charges = 0.00;
                    double total = 0.00;

                    //0.218 * 200 = 43.6
                    //0.334 * 100 = 33.4
                    //0.516 * 300 = 154.8
                    //0.546 * 300 = 163.8
                    if(kWh < 201)
                    {
                        charges = kWh * 0.218;
                        total = charges - (charges * rebate);
                    } else if (kWh > 200 && kWh <301) {
                        charges = 43.6 + ((kWh-200) * 0.334);
                        total = charges - (charges * rebate);
                    } else if (kWh > 300 && kWh < 601) {
                        charges = 43.6 + 33.4 + ((kWh-300) * 0.516);
                        total = charges - (charges * rebate);
                    } else if (kWh > 600 && kWh < 901) {
                        charges = 43.6 + 33.4 + 154.8 + ((kWh-600) * 0.546);
                        total = charges - (charges * rebate);
                    }

                    tvOutput.setText("Final cost: RM " + String.format("%.2f",total));
                }
                break;
        }
    }
}