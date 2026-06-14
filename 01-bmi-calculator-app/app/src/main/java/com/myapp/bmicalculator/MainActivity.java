package com.myapp.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RadioButton radio_button_male;
    private RadioButton radio_Button_Female;
    private EditText edit_text_feet;
    private EditText edit_text_age;
    private EditText edit_text_inches;
    private EditText edit_text_weight;
    private Button button_calculate;
    private TextView text_view_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupButtonClickListener();
    }

    private void findViews(){
        radio_button_male = findViewById(R.id.radio_button_male);
        radio_Button_Female = findViewById(R.id.radio_button_female);

        edit_text_age = findViewById(R.id.edit_text_age);
        edit_text_feet = findViewById(R.id.edit_text_feet);
        edit_text_inches = findViewById(R.id.edit_text_inches);
        edit_text_weight = findViewById(R.id.edit_text_weight);

        button_calculate = findViewById(R.id.button_calculate);

        text_view_result = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmi = calculateBmi();

                String ageText = edit_text_age.getText().toString();
                int age = Integer.parseInt(ageText);
                if(age >= 18){
                    displayResult(bmi);
                }else{
                    displayGuidance(bmi);
                }
            }
        });
    }

    private double calculateBmi() {
        String feetText = edit_text_feet.getText().toString();
        String inchesText = edit_text_inches.getText().toString();
        String weightText = edit_text_weight.getText().toString();

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        double weight = Double.parseDouble(weightText);

        int totalInches = (feet*12) + inches;
        double meters = (double) totalInches*0.0254;

        return weight/(meters*meters);
    }

    private void displayResult(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);
        String fullResultStrnig = "";

        if(bmi < 18.5){
            fullResultStrnig = "         BMI: " + bmiTextResult + "\n\nYou are Underweight!";
        }else if(bmi >= 18.5 && bmi <= 24.9){
            fullResultStrnig = "         BMI: " + bmiTextResult + "\n\nYou are Healthy weight!";

        }else if(bmi >= 25 && bmi <= 29.9){
            fullResultStrnig = "         BMI: " + bmiTextResult + "\n\nYou are Overweight!";
        } else{
            fullResultStrnig = "         BMI: " + bmiTextResult + "\n\nYou are Obese!";
        }

        text_view_result.setText(fullResultStrnig);
    }

    private void displayGuidance(double bmi){
        DecimalFormat myFormattedNumber = new DecimalFormat("0.00");
        String bmiTextResult = myFormattedNumber.format(bmi);
        String fullResultStrnig = "";

        if(radio_button_male.isChecked()){
            fullResultStrnig = "BMI: " + bmiTextResult + "\n\nAs you are under 18, Please consult with your doctor for the healthy range for Boys..";
        }else if(radio_Button_Female.isChecked()){
            fullResultStrnig = "BMI: " + bmiTextResult + "\n\nAs you are under 18, Please consult with your doctor for the healthy range for Girls..";
        }else{
            fullResultStrnig = "\t\t\tBMI: " + bmiTextResult + "\n\nAs you are under 18, Please consult with your doctor for the healthy range..";
        }

        text_view_result.setText(fullResultStrnig);
    }
}
