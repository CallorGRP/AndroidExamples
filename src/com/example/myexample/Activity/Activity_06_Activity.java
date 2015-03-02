package com.example.myexample.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.myexample.R;

public class Activity_06_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_06);
        Log.e("example", "onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("example", "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("example", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("example", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("example", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("example", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("example", "onDestroy()");
    }
}
