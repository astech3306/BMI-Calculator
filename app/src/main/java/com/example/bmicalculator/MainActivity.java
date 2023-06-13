package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText scanWeight = findViewById(R.id.scanWeight);
        EditText scanHeight = findViewById(R.id.scanHeight);
        TextView resultText = findViewById(R.id.resultText);
        ImageView imageView = findViewById(R.id.imageView);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(view -> {
            double height = Double.parseDouble(scanHeight.getText().toString());
            double weight = Double.parseDouble(scanWeight.getText().toString());
            double result = weight/(height*height);

            if(result>25){
                resultText.setText(R.string.resultOverweight);
                imageView.setImageResource(R.drawable.overweight);
            }
            else if(result<18){
                resultText.setText(R.string.resultUnderWeight);
                imageView.setImageResource(R.drawable.underweight);
            }
            else{
                resultText.setText(R.string.resultFit);
                imageView.setImageResource(R.drawable.fit);
            }
        });
    }
}