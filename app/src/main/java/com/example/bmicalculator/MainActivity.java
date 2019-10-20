package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText weight,height;
    Button calculate;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        calculate=findViewById(R.id.calculate);
        result=findViewById(R.id.result);

        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String weightstring=weight.getText().toString();
        String heightstring=height.getText().toString();

        if(TextUtils.isEmpty(heightstring)){
            height.setError("Please, enter your height");
            height.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(weightstring)){
            weight.setError("Please, enter your weight");
            weight.requestFocus();
            return;
        }

        if(heightstring !=null && !"".equals(heightstring) && weightstring !=null
        && !"".equals(weightstring)){
            float heightValue=Float.parseFloat(heightstring)/100*100;

            float weightValue=Float.parseFloat(weightstring);

            float bmi=weightValue/(heightValue*heightValue);

            displayBMI(bmi);
        }

    }

    private void displayBMI(float bmi) {
        String category;

        if(bmi <18.5){
            category="Underweight";
        }else if(bmi >=18.5 && bmi <=24.9){
            category="Healthy/Normal weight";
        }else {
            category="Overweight";
        }

        result.setText(String.valueOf("BMI value="+ bmi + "\n\n" +category));
    }
}
