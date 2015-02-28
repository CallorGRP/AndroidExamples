package com.example.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Activity_04_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_activity_03);

        Intent i = getIntent();
        String data = i.getStringExtra("data");

        TextView tvData = (TextView) findViewById(R.id.data);
        tvData.setText(data);
    }
}
