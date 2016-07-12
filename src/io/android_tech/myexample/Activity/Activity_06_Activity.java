package io.android_tech.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_06_Activity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_activity_06);
        Log.e("example", "Activity A: onCreate()");

        Button btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("example", "Activity A: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("example", "Activity A: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("example", "Activity A: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("example", "Activity A: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("example", "Activity A: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("example", "Activity A: onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnStart:
                Intent i = new Intent(this, Activity_07_Activity.class);
                startActivity(i);

                break;
            default:
                break;
        }
    }
}
