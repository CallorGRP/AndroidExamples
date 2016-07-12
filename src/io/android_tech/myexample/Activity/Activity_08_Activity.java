package io.android_tech.myexample.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import io.android_tech.myexample.R;
import io.android_tech.myexample.R.layout;

public class Activity_08_Activity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_activity_07);

        Button btnView = (Button) findViewById(R.id.btnView);
        Button btnDial = (Button) findViewById(R.id.btnDial);
        btnView.setOnClickListener(this);
        btnDial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnView:
                Intent view = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:123"));
                startActivity(view);

                break;
            case R.id.btnDial:
                Intent dial = new Intent(Intent.ACTION_CALL, Uri.parse("tel:123"));
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                startActivity(dial);

                break;
            default:
                break;
        }
    }
}
