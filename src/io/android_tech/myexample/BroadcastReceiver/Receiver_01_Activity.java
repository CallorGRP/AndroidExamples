package io.android_tech.myexample.BroadcastReceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Receiver_01_Activity extends Activity implements View.OnClickListener {

    Receiver_01_Receiver myReceiver = new Receiver_01_Receiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_receiver_01);

        Button btnRegist = (Button) findViewById(io.android_tech.myexample.R.id.btnRegist);
        Button btnUnregist = (Button) findViewById(io.android_tech.myexample.R.id.btnUnRegist);

        btnRegist.setOnClickListener(this);
        btnUnregist.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnRegist:
                IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
                intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
                intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");

                registerReceiver(myReceiver, intentFilter);

                break;
            case io.android_tech.myexample.R.id.btnUnRegist:
                unregisterReceiver(myReceiver);

                break;
            default:
                break;
        }
    }
}
