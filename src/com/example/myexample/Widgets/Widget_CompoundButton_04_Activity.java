package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myexample.R;

public class Widget_CompoundButton_04_Activity extends Activity implements RadioButton.OnClickListener {

    RadioGroup radioGroup1;
    RadioButton radio2_1, radio2_2, radio2_3;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_compoundbutton_04);
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        RadioButton radio2_1 = (RadioButton) findViewById(R.id.radio2_1);
        RadioButton radio2_2 = (RadioButton) findViewById(R.id.radio2_2);
        RadioButton radio2_3 = (RadioButton) findViewById(R.id.radio2_3);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        radio2_1.setOnClickListener(this);
        radio2_2.setOnClickListener(this);
        radio2_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        int selectedId = radioGroup1.getCheckedRadioButtonId();
//        switch (selectedId()) {
//            case R.id.radio2_1:
//                tvStatus.setText("당신의 국적은 : " + )
//                break;
//        }
    }
}
