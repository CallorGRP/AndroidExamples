package com.example.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myexample.R;

public class Widget_CompoundButton_02_Activity extends Activity implements CompoundButton.OnCheckedChangeListener {

    ToggleButton toggleButton1;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_compoundbutton_02);

        toggleButton1 = (ToggleButton)findViewById(R.id.toggleButton1);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        toggleButton1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if ( isChecked ) {
            Toast.makeText(this, "상태:켜짐", Toast.LENGTH_SHORT).show();
            tvStatus.setText("상태:켜짐");
        }
        else {
            Toast.makeText(this, "상태:꺼짐", Toast.LENGTH_SHORT).show();
            tvStatus.setText("상태:꺼짐");
        }
    }
}
