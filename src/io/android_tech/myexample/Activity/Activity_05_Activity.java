package io.android_tech.myexample.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_05_Activity extends Activity implements View.OnClickListener {
    public static final int REQUEST_CODE = 1000;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_activity_04);

        Button btnStart = (Button) findViewById(io.android_tech.myexample.R.id.btnStart);
        textView2 = (TextView) findViewById(io.android_tech.myexample.R.id.textView2);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btnStart:
                Intent i = new Intent(this, Activity_06_Activity.class);
                startActivityForResult(i, REQUEST_CODE);

                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getExtras().getString("result");
                textView2.setText(result);
            }
        }
    }
}
