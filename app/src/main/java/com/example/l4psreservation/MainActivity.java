package com.example.l4psreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText mobileNumber;
    EditText numPax;
    RadioButton rSmoke;
    RadioButton rNonsmoke;
    Button reserveSubmit;

    Button reset;

    DatePicker dp;
    TimePicker tp;

    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editName);
        mobileNumber = findViewById(R.id.editTextNumber);
        numPax = findViewById(R.id.editTextNumber2);
        rSmoke = findViewById(R.id.smokingTable);
        rNonsmoke = findViewById(R.id.normalTable);
        reserveSubmit = findViewById(R.id.rButton);
        reset = findViewById(R.id.resetButton);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        tvDisplay = findViewById(R.id.tvDisplay);

        dp.updateDate(2020, 06, 01);
        tp.setHour(19);
        tp.setMinute(30);

        reserveSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Smoke = "Non-Smoking Area";
                String name = "";
                String Num = "";
                String size = "";
                if (rSmoke.isChecked()) {
                    Smoke = "Smoking-Area";
                }
                if (etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Invalid Name", Toast.LENGTH_LONG).show();
                } else if (mobileNumber.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Invalid Number", Toast.LENGTH_LONG).show();
                } else if (numPax.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Invalid Group size", Toast.LENGTH_LONG).show();
                } else {
                    name = etName.getText().toString();
                    Num = mobileNumber.getText().toString();
                    size = numPax.getText().toString();
                    Toast.makeText(MainActivity.this, "Registration Success", Toast.LENGTH_LONG).show();
                    String text = "Name: " + name + "\n" +
                            "Contact Number: " + Num + "\n" +
                            "Group size: " + size + "\n" +
                            "Sitting Area: " + Smoke + "\n" +
                            "Date: " + dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear() + "\n" +
                            "Time: " + tp.getHour() + ":" + tp.getMinute();
                    tvDisplay.setText(text);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020, 6, 1);
                tp.setHour(19);
                tp.setMinute(30);
                etName.setText("");
                numPax.setText("");
                mobileNumber.setText("");
                rNonsmoke.setChecked(true);
                tvDisplay.setText("");
            }
        });
    }
}

