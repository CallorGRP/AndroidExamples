package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myexample.R;

public class Widget_CompoundButton_02_Activity extends Activity implements CompoundButton.OnCheckedChangeListener{
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_compoundbutton_02);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        String status = "";
        if ( checkBox1.isChecked() ) status += checkBox1.getText() + " ";
        if ( checkBox2.isChecked() ) status += checkBox2.getText() + " ";
        if ( checkBox3.isChecked() ) status += checkBox3.getText() + " ";
        if ( checkBox4.isChecked() ) status += checkBox4.getText() + " ";

        tvStatus.setText("좋아하는 과일 : " + status);

    }
}
