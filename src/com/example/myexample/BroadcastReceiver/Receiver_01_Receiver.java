package com.example.myexample.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver_01_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_SCREEN_ON:
                Log.d("BroadcastReceiver_01_BroadcastReceiver", "화면 켜짐");
                break;
            case Intent.ACTION_SCREEN_OFF:
                Log.d("BroadcastReceiver_01_BroadcastReceiver", "화면 꺼짐");
                break;
        }
    }
}
