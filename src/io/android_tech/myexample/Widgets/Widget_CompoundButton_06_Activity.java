package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Widget_CompoundButton_06_Activity extends Activity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup1;
    RadioButton radio2_1, radio2_2, radio2_3;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_widgets_compoundbutton_06);
        radioGroup1 = (RadioGroup) findViewById(io.android_tech.myexample.R.id.radiogroup1);
        radio2_1 = (RadioButton) findViewById(io.android_tech.myexample.R.id.radio2_1);
        radio2_2 = (RadioButton) findViewById(io.android_tech.myexample.R.id.radio2_2);
        radio2_3 = (RadioButton) findViewById(io.android_tech.myexample.R.id.radio2_3);
        tvStatus = (TextView) findViewById(io.android_tech.myexample.R.id.tvStatus);

        radioGroup1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String status = "";
        if (group.getCheckedRadioButtonId() == io.android_tech.myexample.R.id.radio2_1) {
            status = radio2_1.getText().toString();
        } else if (group.getCheckedRadioButtonId() == io.android_tech.myexample.R.id.radio2_2) {
            status = radio2_2.getText().toString();
        } else if (group.getCheckedRadioButtonId() == io.android_tech.myexample.R.id.radio2_3) {
            status = radio2_3.getText().toString();
        }
        tvStatus.setText(status + "에서 왔습니다.");

    }
}
