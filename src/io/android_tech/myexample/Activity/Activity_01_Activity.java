package io.android_tech.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_01_Activity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_activity_01);

        Button btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnStart:
                Intent i = new Intent(this, Activity_02_Activity.class);
                startActivity(i);

                break;
            default:
                break;
        }
    }
}
