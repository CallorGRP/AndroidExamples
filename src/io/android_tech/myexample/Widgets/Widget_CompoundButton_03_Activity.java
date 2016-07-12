package io.android_tech.myexample.Widgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Widget_CompoundButton_03_Activity extends Activity implements CompoundButton.OnCheckedChangeListener {

    Switch switch1;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_widgets_compoundbutton_03);

        switch1 = (Switch)findViewById(io.android_tech.myexample.R.id.switch1);
        tvStatus = (TextView) findViewById(io.android_tech.myexample.R.id.tvStatus);

        switch1.setOnCheckedChangeListener(this);
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
