package com.Calculator.unitmeasurementconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inches;

    private Button calculate;

    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayResult();
            }
        });
    }

    private void findView() {
        calculate = findViewById(R.id.button_calculate);
        inches = findViewById(R.id.edit_text_inches);
        result = findViewById(R.id.text_view_result);
    }


    private void displayResult() {

        if (inches.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter an amount for inches ", Toast.LENGTH_SHORT).show();
        } else {
            DecimalFormat conversion = new DecimalFormat("0.00");
            double inch = Double.parseDouble(inches.getText().toString());
            result.setText( conversion.format(convertToMeters(inch))+ " meters");
        }
    }
    private double convertToMeters(double inches) {
        double meters = inches * 0.0254;
        return meters;
    }


}