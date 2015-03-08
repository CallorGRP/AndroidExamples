package com.example.myexample.BroadcastReceiver;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;

public class Receiver_02_Activity extends Activity implements View.OnClickListener{

    Receiver_01_Receiver myReceiver = new Receiver_01_Receiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_01);

        Button btnRegist = (Button)findViewById(R.id.btnRegist);
        Button btnUnregist = (Button)findViewById(R.id.btnUnRegist);

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
            case R.id.btnRegist:
                IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
                registerReceiver(myReceiver, intentFilter);

                break;
            case R.id.btnUnRegist:
                unregisterReceiver(myReceiver);

                break;
            default:
                break;
        }
    }
}
