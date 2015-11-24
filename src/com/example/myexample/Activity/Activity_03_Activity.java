package com.example.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Activity_03_Activity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_activity_01);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                Intent i = new Intent(this, Activity_04_Activity.class);
                i.putExtra("data", "ABCD!@#");
                startActivity(i);

                break;
            default:
                break;
        }
    }
}
