package com.example.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myexample.R;

public class Activity_07_Activity extends Activity implements View.OnClickListener  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_06);
        Log.e("example", "Activity B: onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("example", "Activity B: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("example", "Activity B: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("example", "Activity B: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("example", "Activity B: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("example", "Activity B: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("example", "Activity B: onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                Intent i = new Intent(this, Activity_02_Activity.class);
                startActivity(i);

                break;
            default:
                break;
        }
    }
}
