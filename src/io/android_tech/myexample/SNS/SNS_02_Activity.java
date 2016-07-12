package io.android_tech.myexample.SNS;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class SNS_02_Activity extends FragmentActivity {
    private SNS_02_Fragment mainFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        if (savedInstanceState == null) {
            mainFragment = new SNS_02_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, mainFragment).commit();
        } else {
            mainFragment = (SNS_02_Fragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

}

