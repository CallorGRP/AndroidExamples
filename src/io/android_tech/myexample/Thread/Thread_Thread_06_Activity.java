package io.android_tech.myexample.Thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Thread_Thread_06_Activity extends Activity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.android_tech.myexample.R.layout.activity_thread_thread_06);
        textView = (TextView) findViewById(io.android_tech.myexample.R.id.textView);
        Button btn1 = (Button) findViewById(io.android_tech.myexample.R.id.btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case io.android_tech.myexample.R.id.btn1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText("updated!");
                    }
                }).start();
                break;
            default:
                break;
        }

    }
}
