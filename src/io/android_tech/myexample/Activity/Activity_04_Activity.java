package io.android_tech.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_04_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_activity_03);

        Intent i = getIntent();
        String data = i.getStringExtra("data");

        TextView tvData = (TextView) findViewById(io.android_tech.myexample.R.id.data);
        tvData.setText(data);
    }
}
