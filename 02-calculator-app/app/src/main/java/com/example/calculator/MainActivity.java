package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private EditText editText;
private TextView resultText;
private Button num1Button,num2Button,num3Button,num4Button,num5Button,num6Button,num7Button,num8Button,num9Button,zeroButton;
private Button addButton,subButton,mulButton,divButton,dotButton,clear_textButton,submitButton;

private double num1,num2;
private boolean isAdd, isSub, isMul ,isDiv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String TAG = "My_Calculator";
        Log.i(TAG, "onCreate: Start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText2);
        resultText = findViewById(R.id.resultText);
        clear_textButton = findViewById(R.id.clear_text);

        num1Button = findViewById(R.id.num1);
        num2Button = findViewById(R.id.num2);
        num3Button = findViewById(R.id.num3);
        num4Button = findViewById(R.id.num4);
        num5Button = findViewById(R.id.num5);
        num6Button = findViewById(R.id.num6);
        num7Button = findViewById(R.id.num7);
        num8Button = findViewById(R.id.num8);
        num9Button = findViewById(R.id.num9);
        zeroButton = findViewById(R.id.zero);

        addButton = findViewById(R.id.add);
        subButton = findViewById(R.id.sub);
        mulButton = findViewById(R.id.mul);
        divButton = findViewById(R.id.div);
        submitButton = findViewById(R.id.submit);
        dotButton = findViewById(R.id.dot);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()>0){
                    num1 = Double.parseDouble(editText.getText().toString());
                    isAdd = true;
                    Log.i(TAG, "onClick: isAdd:"+isAdd);
                    editText.setText("");
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()>0){
                    num1 = Double.parseDouble(editText.getText().toString());
                    isSub = true;
                    Log.i(TAG, "onClick: isSub:"+isSub);
                    editText.setText("");
                }
            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()>0){
                    num1 = Double.parseDouble(editText.getText().toString());
                    isMul = true;
                    Log.i(TAG, "onClick: isMul:"+isMul);
                    editText.setText("");
                }
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()>0){
                    num1 = Double.parseDouble(editText.getText().toString());
                    isDiv = true;
                    Log.i(TAG, "onClick: isDiv:"+isDiv);
                    editText.setText("");
                }
            }
        });

        clear_textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                resultText.setText("");
                isAdd = false;
                isSub = false;
                isMul = false;
                isDiv = false;
                Log.i(TAG, "onClick: Clear_Text:");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()>0){
                    num2 = Double.parseDouble(editText.getText().toString());
                    if(isAdd){
                        resultText.setText(String.valueOf(num1+num2));
//                        editText.setText(num1 + num2);
                    }
                    if(isSub){
                        resultText.setText(String.valueOf(num1 - num2));
                    }
                    if(isMul){
                        resultText.setText(String.valueOf(num1 * num2));
                    }
                    if(isDiv){
                        resultText.setText(String.valueOf(num1 / num2));
                    }
                    Log.i(TAG, "onClick: Submit");
                    isAdd = false;
                    isSub = false;
                    isMul = false;
                    isDiv = false;
                }
            }
        });

        num1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "1");
                Log.i(TAG, "onClick: num1");
            }
        });

        num2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "2");
                Log.i(TAG, "onClick: num2");
            }
        });

        num3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "3");
                Log.i(TAG, "onClick: num3");
            }
        });

        num4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "4");
                Log.i(TAG, "onClick: num4");
            }
        });

        num5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+ "5");
                Log.i(TAG, "onClick: num5");
            }
        });

        num6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "6");
                Log.i(TAG, "onClick: num6");
            }
        });

        num7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "7");
                Log.i(TAG, "onClick: num7");
            }
        });

        num8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "8");
                Log.i(TAG, "onClick: num8");
            }
        });

        num9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "9");
                Log.i(TAG, "onClick: num9");
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "0");
                Log.i(TAG, "onClick: zero");
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().contains(".")) {
                    editText.setText(editText.getText().toString() + ".");
                    Log.i(TAG, "onClick: Dot");
                }
            }
        });




    }
}