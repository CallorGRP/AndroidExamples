package io.android_tech.myexample.Service;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Service_02_Activity extends Activity implements View.OnClickListener {

    MediaPlayer music;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_activity_08);

        serviceIntent = new Intent(this, Service_02_Service.class);

        Button btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);
        Button btnStop = (Button) findViewById(io.android_tech.myexample.R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnStart:
                startService(serviceIntent);

                break;
            case io.android_tech.myexample.R.id.btnStop:
                stopService(serviceIntent);

                break;
            default:
                break;
        }
    }
}
