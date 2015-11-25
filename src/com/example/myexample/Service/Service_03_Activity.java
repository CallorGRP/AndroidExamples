package com.example.myexample.Service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Service_03_Activity extends Activity implements View.OnClickListener {

    Intent serviceIntent;
    Service_03_Service boundService;
    boolean isBound;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Service_03_Service.LocalBinder binder = (Service_03_Service.LocalBinder) service;
            boundService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_service_02);

        serviceIntent = new Intent(this, Service_02_Service.class);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        Button btnPause = (Button) findViewById(R.id.btnPause);
        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        bindService(serviceIntent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                startService(serviceIntent);

                break;
            case R.id.btnPause:
                boundService.pauseMusic();

                break;
            case R.id.btnStop:

                unbindService(mConnection);

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }

}
