package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.myexample.R;

public class Widget_CompoundButton_03_Activity extends Activity {

    ToggleButton toggleButton1;
    CheckBox checkBox1;
    RadioButton radioButton1;
    Switch switch1;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_compoundbutton_03);

    }

}
