package com.example.myexample.Service;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Service_02_Activity extends Activity implements View.OnClickListener {

    MediaPlayer music;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_activity_08);

        serviceIntent = new Intent(this,com.example.myexample.Service.Service_02_Service.class);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                startService(serviceIntent);

                break;
            case R.id.btnStop:
                stopService(serviceIntent);

                break;
            default:
                break;
        }
    }
}
