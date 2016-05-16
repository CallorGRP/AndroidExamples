package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myexample.R;

public class Widget_CompoundButton_06_Activity extends Activity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup1;
    RadioButton radio2_1, radio2_2, radio2_3;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_compoundbutton_06);
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        radio2_1 = (RadioButton) findViewById(R.id.radio2_1);
        radio2_2 = (RadioButton) findViewById(R.id.radio2_2);
        radio2_3 = (RadioButton) findViewById(R.id.radio2_3);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        radioGroup1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String status = "";
        if (group.getCheckedRadioButtonId() == R.id.radio2_1) {
            status = radio2_1.getText().toString();
        } else if (group.getCheckedRadioButtonId() == R.id.radio2_2) {
            status = radio2_2.getText().toString();
        } else if (group.getCheckedRadioButtonId() == R.id.radio2_3) {
            status = radio2_3.getText().toString();
        }
        tvStatus.setText(status + "에서 왔습니다.");

    }
}
