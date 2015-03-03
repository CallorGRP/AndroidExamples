package com.example.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class Activity_08_Activity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_activity_07);

        Button btnView = (Button)findViewById(R.id.btnView);
        Button btnDial = (Button)findViewById(R.id.btnDial);
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
                startActivity(dial);

                break;
            default:
                break;
        }
    }
}
