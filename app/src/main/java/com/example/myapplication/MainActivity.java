package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtHeight;
    private EditText edtWeight;
    private EditText edtAge;
    private TextView txtProgress;
    private SeekBar sbProgress;
    private RadioGroup rgSexo;
    private ImageButton calculateBtn;
    private TextView txtResult;
    private CheckBox cbToJoules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtAge = findViewById(R.id.edtAge);
        txtProgress = findViewById(R.id.txtProgress);
        sbProgress = findViewById(R.id.sbProgress);
        rgSexo = findViewById(R.id.rgSexo);
        calculateBtn = findViewById(R.id.calculate);
        txtResult = findViewById(R.id.txtResult);
        cbToJoules = findViewById(R.id.toJoules);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    rgSexo.getCheckedRadioButtonId();
                    int gender = rgSexo.getCheckedRadioButtonId();
                    Float weight = Float.parseFloat(edtWeight.getText().toString());
                    Float height = Float.parseFloat(edtHeight.getText().toString());
                    Float age = Float.parseFloat(edtAge.getText().toString());
                    int activityPerWeek;
                    activityPerWeek = Integer.parseInt(txtProgress.getText().toString());
                    double result;
                    double variableOne = 0;
                    double variableTwo = 0;
                    double variableThree = 0;
                    double variableFour = 0;

                    switch (gender) {
                        case R.id.rbFeminino:
                            variableOne = 655;
                            variableTwo = 9.6;
                            variableThree = 1.8;
                            variableFour = 4.7;
                            break;
                        case R.id.rbMasculino:
                            variableOne = 66.5;
                            variableTwo = 14;
                            variableThree = 5;
                            variableFour = 6.7;
                            break;
                    }
                    result = variableOne + (variableTwo * weight) + (variableThree * height) - (variableFour * age);
                    double finalResult;
                    finalResult = result * activityPerWeek;
                    String finalStringResult;
                    if(cbToJoules.isChecked()) {
                        finalResult *= 4180;
                        finalStringResult = finalResult + " J";
                    } else {
                        finalStringResult = String.valueOf(finalResult);
                    }

                    txtResult.setText(finalStringResult);

                } catch (Error error) {
                    error.printStackTrace();
                }

            }
        });

        sbProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                txtProgress.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}